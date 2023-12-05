/*
 * #%L
 * de.metas.cucumber
 * %%
 * Copyright (C) 2021 metas GmbH
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

package de.metas.cucumber.stepdefs;

import com.google.common.collect.ImmutableList;
import de.metas.common.util.StringUtils;
import de.metas.util.Check;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.adempiere.model.InterfaceWrapperHelper;
import org.assertj.core.api.Assertions;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@UtilityClass
public class StepDefUtil
{
	public void tryAndWait(final long maxWaitSeconds, final long checkingIntervalMs, final Supplier<Boolean> worker) throws InterruptedException
	{
		final long nowMillis = System.currentTimeMillis(); // don't use SystemTime.millis(); because it's probably "rigged" for testing purposes,
		final long deadLineMillis = nowMillis + (maxWaitSeconds * 1000L);

		boolean conditionIsMet = worker.get();

		while (System.currentTimeMillis() < deadLineMillis && !conditionIsMet)
		{
			Thread.sleep(checkingIntervalMs);
			conditionIsMet = worker.get();
		}
	}

	/**
	 * Waits for the given {@code worker} to supply an optional that is present.
	 * Fails if this doesn't happen within the given {@code maxWaitSeconds} timeout.
	 *
	 * @param maxWaitSeconds set to a value <=0 to wait forever (use only when developing locally)
	 */
	public <T> T tryAndWaitForItem(
			final long maxWaitSeconds,
			final long checkingIntervalMs,
			@NonNull final ItemProvider<T> worker,
			@Nullable final Runnable logContext) throws InterruptedException
	{
		final long deadLineMillis = computeDeadLineMillis(maxWaitSeconds);

		ItemProvider.ProviderResult<T> lastWorkerResult = null;
		while (deadLineMillis > System.currentTimeMillis())
		{
			Thread.sleep(checkingIntervalMs);

			lastWorkerResult = worker.execute();
			if (lastWorkerResult.isResultFound())
			{
				return lastWorkerResult.getResult();
			}
		}

		if (logContext != null)
		{
			logContext.run();
		}
		Assertions.fail("the given supplier didn't succeed within the " + maxWaitSeconds + "second timeout. "
								+ "The logging output of the last try is:\n" + lastWorkerResult == null ? "<null>" : lastWorkerResult.getLog());
		return null;

	}

	public <T> T tryAndWaitForItem(
			final long maxWaitSeconds,
			final long checkingIntervalMs,
			@NonNull final ItemProvider<T> worker) throws InterruptedException
	{
		return tryAndWaitForItem(maxWaitSeconds, checkingIntervalMs, worker, (Supplier<String>)null);
	}

	@NonNull
	public List<String> splitIdentifiers(@NonNull final String identifiers)
	{
		return Arrays.asList(identifiers.split(","));
	}

	public void validateErrorMessage(@NonNull final Exception e, @Nullable final String errorMessage) throws Exception
	{
		if (Check.isNotBlank(errorMessage))
		{
			assertThat(e.getMessage()).contains(errorMessage);
		}
		else
		{
			throw e;
		}
	}

	/**
	 * Waits for the given {@code worker} to supply an optional that is present.
	 * Fails if this doesn't happen within the given {@code maxWaitSeconds} timeout.
	 *
	 * @param maxWaitSeconds set to a value <=0 to wait forever (use only when developing locally)
	 */
	public <T> T tryAndWaitForItem(
			final long maxWaitSeconds,
			final long checkingIntervalMs,
			@NonNull final ItemProvider<T> worker,
			@Nullable final Supplier<String> logContext) throws InterruptedException
	{
		final long deadLineMillis = computeDeadLineMillis(maxWaitSeconds);

		ItemProvider.ProviderResult<T> lastWorkerResult = null;
		while (deadLineMillis > System.currentTimeMillis())
		{
			Thread.sleep(checkingIntervalMs);

			lastWorkerResult = worker.execute();
			if (lastWorkerResult.isResultFound())
			{
				return lastWorkerResult.getResult();
			}
		}

		final String context = Optional.ofNullable(logContext).map(Supplier::get).orElse("Context not provided!");

		org.junit.jupiter.api.Assertions.fail("the given supplier didn't succeed within the " + maxWaitSeconds + "second timeout. "
													  + "The logging output of the last try is:\n" + (lastWorkerResult == null ? "<null>" : lastWorkerResult.getLog())
													  + "\n Context: " + context);
		return null;

	}

	public int extractId(@NonNull final String idOrIdentifier, @NonNull final StepDefData<?> stepDefDataTable)
	{
		try
		{
			return Integer.parseInt(idOrIdentifier);
		}
		catch (final NumberFormatException exception)
		{
			final Object model = stepDefDataTable.get(idOrIdentifier);

			return InterfaceWrapperHelper.getId(model);
		}
	}
	
	public ImmutableList<String> extractIdentifiers(@NonNull final String identifier)
	{
		return Arrays.stream(identifier.split(","))
				.map(StringUtils::trim)
				.collect(ImmutableList.toImmutableList());
	}
	
	private long computeDeadLineMillis(final long maxWaitSeconds)
	{
		final long nowMillis = System.currentTimeMillis(); // don't use SystemTime.millis(); because it's probably "rigged" for testing purposes,
		final long deadLineMillis = maxWaitSeconds > 0 ? nowMillis + (maxWaitSeconds * 1000L) : Long.MAX_VALUE;
		return deadLineMillis;
	}
}
