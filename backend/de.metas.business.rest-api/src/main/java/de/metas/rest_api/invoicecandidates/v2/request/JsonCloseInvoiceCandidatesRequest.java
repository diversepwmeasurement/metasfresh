/*
 * #%L
 * de.metas.business.rest-api
 * %%
 * Copyright (C) 2022 metas GmbH
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

package de.metas.rest_api.invoicecandidates.v2.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;

import java.util.List;

@Value
public class JsonCloseInvoiceCandidatesRequest
{
	@Schema(required = true,
			description = "Specifies the invoice candidates to close.")
	List<JsonInvoiceCandidateReference> invoiceCandidates;

	@JsonCreator
	public JsonCloseInvoiceCandidatesRequest(
			@JsonProperty("invoiceCandidates") @Singular @NonNull final List<JsonInvoiceCandidateReference> invoiceCandidates)
	{
		this.invoiceCandidates = invoiceCandidates;
	}
}
