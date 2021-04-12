/*
 * #%L
 * de.metas.elasticsearch
 * %%
 * Copyright (C) 2020 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */

package de.metas.elasticsearch.impl;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Suppliers;
import de.metas.elasticsearch.IESSystem;
import de.metas.elasticsearch.config.ESModelIndexerConfigBuilder;
import de.metas.elasticsearch.config.ESModelIndexerProfile;
import de.metas.elasticsearch.scheduler.IESModelIndexingScheduler;
import de.metas.elasticsearch.trigger.IESModelIndexerTrigger;
import de.metas.logging.LogManager;
import de.metas.util.Check;
import de.metas.util.Services;
import de.metas.util.StringUtils;
import lombok.NonNull;
import org.adempiere.model.InterfaceWrapperHelper;
import org.adempiere.service.ISysConfigBL;
import org.compiere.Adempiere;
import org.slf4j.Logger;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ESSystem implements IESSystem
{
	private static final Logger logger = LogManager.getLogger(ESSystem.class);

	@VisibleForTesting
	public static final String ESServer_Classname = "de.metas.elasticsearch.ESServer";

	private static final String SYSTEM_PROPERTY_elastic_enable = "elastic_enable";

	public static final String SYSCONFIG_PostKpiEvents = "de.metas.elasticsearch.PostKpiEvents";
	private static final boolean SYSCONFIG_PostKpiEvents_Default = true;

	@Override
	public boolean isEnabled()
	{
		if (Adempiere.isUnitTestMode())
		{
			return false;
		}

		// Check if disabled by system property (as documented on sysconfig description)
		if (StringUtils.toBoolean(System.getProperty(SYSTEM_PROPERTY_elastic_enable)))
		{
			return false;
		}

		// Check if it was disabled by sysconfig
		{
			final ISysConfigBL sysConfigBL = Services.get(ISysConfigBL.class);
			return sysConfigBL.getBooleanValue(SYSCONFIG_PostKpiEvents, SYSCONFIG_PostKpiEvents_Default);
		}
	}

	private void assertEnabled()
	{
		Check.assume(isEnabled(), "Elasticsearch system is enabled");
	}

	@Override
	public ESModelIndexerConfigBuilder newModelIndexerConfig(
			@NonNull final ESModelIndexerProfile profile,
			@NonNull final String indexName,
			@NonNull final Class<?> modelClass)
	{
		final Consumer<ESModelIndexerConfigBuilder> configInstaller = this::installConfig;
		final String modelTableName = InterfaceWrapperHelper.getTableName(modelClass);
		return new ESModelIndexerConfigBuilder(configInstaller, profile, indexName, modelTableName);
	}

	@Override
	public ESModelIndexerConfigBuilder newModelIndexerConfig(
			@NonNull final ESModelIndexerProfile profile,
			@NonNull final String indexName,
			@NonNull final String modelTableName)
	{
		final Consumer<ESModelIndexerConfigBuilder> configInstaller = this::installConfig;
		return new ESModelIndexerConfigBuilder(configInstaller, profile, indexName, modelTableName);
	}

	private void installConfig(final ESModelIndexerConfigBuilder config)
	{
		assertEnabled();

		//
		// Add configuration on server too (if exists)
		final IESServer esServer = getESServer();
		if (esServer != null)
		{
			esServer.installConfig(config);
		}

		//
		// Install model indexer's triggers
		for (final IESModelIndexerTrigger trigger : config.getTriggers())
		{
			trigger.install();
			logger.info("Installed trigger: {}", trigger);
		}
	}

	private final Supplier<IESServer> serverSupplier = Suppliers.memoize(this::findESServer);

	private IESServer getESServer()
	{
		return serverSupplier.get();
	}

	private IESServer findESServer()
	{
		try
		{
			final IESServer esServer = (IESServer)Thread.currentThread()
					.getContextClassLoader()
					.loadClass(ESServer_Classname)
					.newInstance();

			logger.info("Found ESServer: {}", esServer);
			return esServer;
		}
		catch (final ClassNotFoundException e)
		{
			logger.info("ESServer class was not found: {}", ESServer_Classname);
			return null;
		}
		catch (final Exception e)
		{
			logger.warn("Failed instantiating ESServer for {}", ESServer_Classname, e);
			return null;
		}
	}

	@Override
	public IESModelIndexingScheduler scheduler()
	{
		return Services.get(IESModelIndexingScheduler.class);
	}
}
