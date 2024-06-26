/*
 * #%L
 * de.metas.ui.web.base
 * %%
 * Copyright (C) 2024 metas GmbH
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

package de.metas.ui.web.window.datatypes.json;

import de.metas.common.rest_api.v2.JsonErrorItem;
import de.metas.ui.web.process.ProcessId;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.annotation.Nullable;
import java.util.List;

@Value
@Builder
@Jacksonized
public class JsonProcessHealthResponse
{
	int countTotal;
	int countErrors;
	String took;

	List<Entry> errors;

	@Value
	@Builder
	@Jacksonized
	public static class Entry
	{
		@NonNull ProcessId processId;
		@Nullable String value;
		@Nullable String name;
		@Nullable String classname;
		@Nullable JsonErrorItem error;
	}
}
