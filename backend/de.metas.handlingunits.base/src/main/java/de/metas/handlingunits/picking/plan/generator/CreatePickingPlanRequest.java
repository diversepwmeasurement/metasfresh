/*
 * #%L
 * de.metas.handlingunits.base
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

package de.metas.handlingunits.picking.plan.generator;

import com.google.common.collect.ImmutableList;
import de.metas.picking.api.Packageable;
import de.metas.util.Check;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Collection;

@Value
public class CreatePickingPlanRequest
{
	@NonNull ImmutableList<Packageable> packageables;
	boolean considerAttributes;

	@Builder
	private CreatePickingPlanRequest(
			@NonNull final Collection<Packageable> packageables,
			final boolean considerAttributes)
	{
		Check.assumeNotEmpty(packageables, "packageables shall not be empty");

		this.packageables = ImmutableList.copyOf(packageables);
		this.considerAttributes = considerAttributes;
	}
}
