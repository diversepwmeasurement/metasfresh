package de.metas.handlingunits.locking;

import org.adempiere.mm.attributes.api.impl.LotNumberDateAttributeDAO;
import org.adempiere.mm.attributes.spi.IAttributeValueContext;
import org.adempiere.util.Services;
import org.springframework.stereotype.Component;

import de.metas.handlingunits.attribute.Constants;
import de.metas.handlingunits.attribute.IAttributeValue;
import de.metas.handlingunits.attribute.storage.IAttributeStorage;
import de.metas.handlingunits.attribute.storage.IAttributeStorageFactoryService;
import de.metas.handlingunits.attribute.storage.IAttributeStorageListener;
import de.metas.handlingunits.attribute.storage.impl.AbstractHUAttributeStorage;
import lombok.NonNull;

/*
 * #%L
 * de.metas.handlingunits.base
 * %%
 * Copyright (C) 2018 metas GmbH
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

@Component
public class LockedAttributeStorageListener implements IAttributeStorageListener
{

	private final transient HULotNumberQuarantineService lotNumberLockService;

	public LockedAttributeStorageListener(@NonNull final HULotNumberQuarantineService lotNumberLockService)
	{

		this.lotNumberLockService = lotNumberLockService;

		Services.get(IAttributeStorageFactoryService.class).addAttributeStorageListener(this);
	}

	@Override
	public void onAttributeValueChanged(
			@NonNull final IAttributeValueContext attributeValueContext,
			@NonNull final IAttributeStorage storage,
			IAttributeValue attributeValue,
			Object valueOld)
	{
		final AbstractHUAttributeStorage huAttributeStorage = AbstractHUAttributeStorage.castOrNull(storage);

		final boolean storageIsAboutHUs = huAttributeStorage != null;
		if (!storageIsAboutHUs)
		{
			return;
		}

		if (!storage.hasAttribute(Constants.ATTR_Quarantine))
		{
			return;
		}

		final String attributeIdentifier = attributeValue.getM_Attribute().getValue();
		final boolean relevantAttributeHasChanged = LotNumberDateAttributeDAO.LotNumberAttribute.equals(attributeIdentifier);

		if (!relevantAttributeHasChanged)
		{
			return;
		}

		if (lotNumberLockService.isQuarantineLotNumber(huAttributeStorage))
		{
			storage.setValue(Constants.ATTR_Quarantine, Constants.ATTR_Quarantine_Value_Quarantine);
		}
		else
		{
			storage.setValue(Constants.ATTR_Quarantine, null);
		}
	}

}
