package de.metas.handlingunits.age;

/*
 * #%L
 * metasfresh-pharma
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

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;

@Value
@EqualsAndHashCode
public final class Age
{
	private final int ageInMonths;

	public static Age ZERO = ofAgeInMonths(0);

	@NonNull
	public static Age ofAgeInMonths(final int ageInMonths)
	{
		return ageInMonths == 0 ? ZERO : new Age(ageInMonths);
	}

	private Age(final int ageInMonths)
	{
		this.ageInMonths = ageInMonths;
	}

	@NonNull
	public Age add(final @NonNull Age other)
	{
		if (other.isZero())
		{
			return this;
		}
		if (isZero())
		{
			return other;
		}

		return ofAgeInMonths(this.ageInMonths + other.ageInMonths);
	}

	public boolean isZero()
	{
		return ageInMonths == 0;
	}

	public String toStringValue()
	{
		return String.valueOf(ageInMonths);
	}
}
