/*
 * #%L
 * de.metas.banking.base
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

package de.metas.banking.model.validator;

import de.metas.banking.BankId;
import de.metas.banking.api.BankRepository;
import de.metas.bpartner.quick_input.service.BPartnerQuickInputService;
import de.metas.impexp.config.DataImportConfigId;
import lombok.NonNull;
import org.adempiere.ad.modelvalidator.annotations.Interceptor;
import org.adempiere.ad.modelvalidator.annotations.ModelChange;
import org.compiere.model.I_C_BPartner_QuickInput;
import org.compiere.model.I_C_Bank;
import org.compiere.model.ModelValidator;
import org.springframework.stereotype.Component;

@Component
@Interceptor(I_C_Bank.class)
public class C_Bank
{
	private final BankRepository bankRepo;

	public C_Bank(@NonNull final BankRepository bankRepo)
	{
		this.bankRepo = bankRepo;
	}

	@ModelChange(timings = { ModelValidator.TYPE_BEFORE_NEW})
	public void beforeSave(@NonNull final I_C_Bank bank)
	{
		if(bank.getC_DataImport_ID() <= 0)
		{
			bank.setC_DataImport_ID(DataImportConfigId.toRepoId(bankRepo.retrieveDefaultBankDataImportConfigId()));
		}
	}
}
