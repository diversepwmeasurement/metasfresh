/*
 * #%L
 * de-metas-common-externalreference
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

package de.metas.common.externalreference;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.metas.common.externalsystem.JsonExternalSystemName;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.List;

/**
 * A request can have one or multiple items.
 * Each item is a little request of its own and {@link JsonExternalReferenceLookupResponse}
 * contains one response item for each request item.
 */
@Value
public class JsonExternalReferenceLookupRequest
{
	JsonExternalSystemName systemName;

	List<JsonExternalReferenceLookupItem> items;

	@Builder
	@JsonCreator
	private JsonExternalReferenceLookupRequest(
			@JsonProperty("systemName") @NonNull final JsonExternalSystemName systemName,
			@JsonProperty("items") @Singular final List<JsonExternalReferenceLookupItem> items)
	{
		this.systemName = systemName;
		this.items = items;
	}

	public String toString()
	{
		try
		{
			return new ObjectMapper().writeValueAsString(this);
		}
		catch (final JsonProcessingException e)
		{
			throw new RuntimeException("toString() failed for JsonExternalReferenceLookupRequest", e);
		}
	}
}
