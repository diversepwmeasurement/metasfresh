package org.eevolution.api;

import java.util.Arrays;

import org.adempiere.exceptions.AdempiereException;
import org.eevolution.model.X_PP_Product_BOMLine;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import lombok.Getter;
import lombok.NonNull;

/*
 * #%L
 * de.metas.business
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

public enum BOMComponentType
{
	Component(X_PP_Product_BOMLine.COMPONENTTYPE_Component), //
	CoProduct(X_PP_Product_BOMLine.COMPONENTTYPE_Co_Product), //
	ByProduct(X_PP_Product_BOMLine.COMPONENTTYPE_By_Product), //
	Phantom(X_PP_Product_BOMLine.COMPONENTTYPE_Phantom), //
	Packing(X_PP_Product_BOMLine.COMPONENTTYPE_Packing), //
	// Planning(X_PP_Product_BOMLine.COMPONENTTYPE_Planning), //
	Tools(X_PP_Product_BOMLine.COMPONENTTYPE_Tools), //
	// Option(X_PP_Product_BOMLine.COMPONENTTYPE_Option), //
	Variant(X_PP_Product_BOMLine.COMPONENTTYPE_Variant), //
	// Scrap(X_PP_Product_BOMLine.COMPONENTTYPE_Scrap), //
	// Product(X_PP_Product_BOMLine.COMPONENTTYPE_Product) //
	;

	public static final int AD_REFERENCE_ID = X_PP_Product_BOMLine.COMPONENTTYPE_AD_Reference_ID;

	@Getter
	private final String code;

	BOMComponentType(final String code)
	{
		this.code = code;
	}

	public static String toCodeOrNull(final BOMComponentType componentType)
	{
		return componentType != null ? componentType.getCode() : null;
	}

	public static BOMComponentType ofCode(@NonNull final String code)
	{
		final BOMComponentType type = typesByCode.get(code);
		if (type == null)
		{
			throw new AdempiereException("No " + BOMComponentType.class + " found for code: " + code);
		}
		return type;
	}

	private static final ImmutableMap<String, BOMComponentType> typesByCode = Maps.uniqueIndex(Arrays.asList(values()), BOMComponentType::getCode);

	public boolean isComponent()
	{
		return this == Component;
	}

	public boolean isPacking()
	{
		return this == Packing;
	}

	public boolean isComponentOrPacking()
	{
		return isComponent() || isPacking();
	}

	public boolean isCoProduct()
	{
		return this == CoProduct;
	}

	public boolean isByProduct()
	{
		return this == ByProduct;
	}

	public boolean isByOrCoProduct()
	{
		return isByProduct() || isCoProduct();
	}

	public boolean isVariant()
	{
		return this == Variant;
	}

	public boolean isPhantom()
	{
		return this == Phantom;
	}

	public boolean isTools()
	{
		return this == Tools;
	}
}
