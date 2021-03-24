package de.metas.invoicecandidate.api.impl;

import static de.metas.common.util.CoalesceUtil.coalesce;
import static org.adempiere.model.InterfaceWrapperHelper.loadOutOfTrx;

import java.time.LocalDate;

/*
 * #%L
 * de.metas.swat.base
 * %%
 * Copyright (C) 2015 metas GmbH
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

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Nullable;

import ch.qos.logback.classic.Level;
import de.metas.order.IOrderDAO;
import de.metas.order.OrderId;
import org.adempiere.ad.table.api.AdTableId;
import org.adempiere.ad.table.api.IADTableDAO;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_DocType;
import org.compiere.model.I_M_InOutLine;
import org.compiere.model.I_M_PricingSystem;
import org.compiere.model.X_C_DocType;
import org.compiere.util.TimeUtil;
import org.slf4j.Logger;

import com.google.common.base.MoreObjects;
import de.metas.aggregation.api.AggregationId;
import de.metas.aggregation.api.AggregationKey;
import de.metas.aggregation.api.IAggregationFactory;
import de.metas.aggregation.api.IAggregationKeyBuilder;
import de.metas.aggregation.model.X_C_Aggregation;
import de.metas.bpartner.BPartnerContactId;
import de.metas.bpartner.BPartnerId;
import de.metas.bpartner.BPartnerLocationId;
import de.metas.bpartner.service.IBPartnerBL;
import de.metas.bpartner.service.IBPartnerBL.RetrieveContactRequest;
import de.metas.bpartner.service.IBPartnerBL.RetrieveContactRequest.ContactType;
import de.metas.bpartner.service.IBPartnerBL.RetrieveContactRequest.IfNotFound;
import de.metas.bpartner.service.IBPartnerDAO;
import de.metas.common.util.CoalesceUtil;
import de.metas.document.IDocTypeDAO;
import de.metas.i18n.AdMessageKey;
import de.metas.inout.InOutId;
import de.metas.invoice.service.IInvoiceBL;
import de.metas.invoicecandidate.InvoiceCandidateId;
import de.metas.invoicecandidate.api.IAggregationBL;
import de.metas.invoicecandidate.api.IInvoiceCandAggregate;
import de.metas.invoicecandidate.api.IInvoiceCandBL;
import de.metas.invoicecandidate.api.IInvoiceCandDAO;
import de.metas.invoicecandidate.api.IInvoiceHeader;
import de.metas.invoicecandidate.api.IInvoiceLineAggregationRequest;
import de.metas.invoicecandidate.api.IInvoiceLineAttribute;
import de.metas.invoicecandidate.api.IInvoiceLineRW;
import de.metas.invoicecandidate.api.InvoiceCandidate_Constants;
import de.metas.invoicecandidate.model.I_C_InvoiceCandidate_InOutLine;
import de.metas.invoicecandidate.model.I_C_Invoice_Candidate;
import de.metas.invoicecandidate.spi.IAggregator;
import de.metas.lang.SOTrx;
import de.metas.money.Money;
import de.metas.pricing.PriceListId;
import de.metas.pricing.PriceListVersionId;
import de.metas.pricing.PricingSystemId;
import de.metas.pricing.service.IPriceListDAO;
import de.metas.user.User;
import de.metas.util.Check;
import de.metas.util.GuavaCollectors;
import de.metas.util.ILoggable;
import de.metas.util.Loggables;
import de.metas.util.Services;
import lombok.Builder;
import lombok.NonNull;
import org.adempiere.ad.table.api.AdTableId;
import org.adempiere.ad.table.api.IADTableDAO;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.model.InterfaceWrapperHelper;
import org.compiere.model.I_C_BPartner;
import org.compiere.model.I_C_BPartner_Location;
import org.compiere.model.I_C_DocType;
import org.compiere.model.I_M_InOutLine;
import org.compiere.model.I_M_PricingSystem;
import org.compiere.model.X_C_DocType;
import org.compiere.util.TimeUtil;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static de.metas.common.util.CoalesceUtil.coalesce;
import static org.adempiere.model.InterfaceWrapperHelper.loadOutOfTrx;

/**
 * Aggregates multiple {@link I_C_Invoice_Candidate} records and returns a result that that is suitable to create invoices.
 *
 * @see IAggregator
 */

public final class AggregationEngine
{

	public static AggregationEngine newInstance()
	{
		return builder().build();
	}

	//
	// services
	private static final transient Logger logger = InvoiceCandidate_Constants.getLogger(AggregationEngine.class);
	private final transient IInvoiceCandDAO invoiceCandDAO = Services.get(IInvoiceCandDAO.class);
	private final transient IInvoiceCandBL invoiceCandBL = Services.get(IInvoiceCandBL.class);
	private final transient IInvoiceBL invoiceBL = Services.get(IInvoiceBL.class);
	private final transient IAggregationBL aggregationBL = Services.get(IAggregationBL.class);
	private final transient IAggregationFactory aggregationFactory = Services.get(IAggregationFactory.class);
	private final transient IPriceListDAO priceListDAO = Services.get(IPriceListDAO.class);
	private final transient IBPartnerDAO bpartnerDAO = Services.get(IBPartnerDAO.class);
	private final transient IOrderDAO orderDAO = Services.get(IOrderDAO.class);

	private final transient IDocTypeDAO docTypeDAO = Services.get(IDocTypeDAO.class);

	private static final AdMessageKey ERR_INVOICE_CAND_PRICE_LIST_MISSING_2P = AdMessageKey.of("InvoiceCand_PriceList_Missing");

	//
	// Parameters
	private final IBPartnerBL bpartnerBL;
	private final boolean alwaysUseDefaultHeaderAggregationKeyBuilder;
	private final LocalDate today;
	private final LocalDate dateInvoicedParam;
	private final LocalDate dateAcctParam;
	private final boolean useDefaultBillLocationAndContactIfNotOverride;

	private final AdTableId inoutLineTableId;
	/**
	 * Map: HeaderAggregationKey to {@link InvoiceHeaderAndLineAggregators}
	 */
	private final Map<AggregationKey, InvoiceHeaderAndLineAggregators> key2headerAndAggregators = new LinkedHashMap<>();

	@Builder
	private AggregationEngine(
			final IBPartnerBL bpartnerBL,
			final boolean alwaysUseDefaultHeaderAggregationKeyBuilder,
			@Nullable final LocalDate dateInvoicedParam,
			@Nullable final LocalDate dateAcctParam,
			final boolean useDefaultBillLocationAndContactIfNotOverride)
	{
		this.bpartnerBL = coalesce(bpartnerBL, Services.get(IBPartnerBL.class));

		this.alwaysUseDefaultHeaderAggregationKeyBuilder = alwaysUseDefaultHeaderAggregationKeyBuilder;

		this.today = invoiceCandBL.getToday();

		this.dateInvoicedParam = dateInvoicedParam;
		this.dateAcctParam = dateAcctParam;
		this.useDefaultBillLocationAndContactIfNotOverride = useDefaultBillLocationAndContactIfNotOverride;

		final IADTableDAO adTableDAO = Services.get(IADTableDAO.class);
		inoutLineTableId = AdTableId.ofRepoId(adTableDAO.retrieveTableId(I_M_InOutLine.Table_Name));
	}

	@Override
	public String toString()
	{
		return MoreObjects.toStringHelper(this)
				.add("key2headerAndAggregators", key2headerAndAggregators)
				.add("alwaysUseDefaultHeaderAggregationKeyBuilder", alwaysUseDefaultHeaderAggregationKeyBuilder)
				.toString();
	}

	public AggregationEngine addInvoiceCandidate(@NonNull final I_C_Invoice_Candidate ic)
	{
		Check.assume(!ic.isToClear(), "{} has IsToClear='N'", ic);
		Check.assume(!ic.isProcessed(), "{} not processed", ic);

		final InvoiceCandidateId invoiceCandidateId = InvoiceCandidateId.ofRepoId(ic.getC_Invoice_Candidate_ID());
		final List<I_C_InvoiceCandidate_InOutLine> iciols = invoiceCandDAO.retrieveICIOLAssociationsExclRE(invoiceCandidateId);

		//
		// Case: No IC-IOL association found;
		// => Proceed with normal invoice aggregation
		if (iciols.isEmpty())
		{
			// Log a possible internal error: no IC-IOL association although invoice candidate was created from inout line.
			if (ic.getAD_Table_ID() == inoutLineTableId.getRepoId())
			{
				final AdempiereException ex = new AdempiereException(
						"No IC-IOL associations were found although invoice candidate points to M_InOutLine."
								+ "\n This case shall not happen because and IC-IOL association should be created by InOut handler."
								+ "\n @C_Invoice_Candidate_ID@: " + ic
								+ "\n @HeaderAggregationKey@: " + getHeaderAggregationKey(ic));
				logger.warn(ex.getLocalizedMessage(), ex);
			}

			final I_C_InvoiceCandidate_InOutLine iciol = null; // no IC-IOL association
			final boolean isLastIcIol = false; // doesn't really matter as there is no icIol at all
			addInvoiceCandidateForInOutLine(ic, iciol, isLastIcIol);
			return this; // stop here
		}

		//
		// Case: we have IC-IOL associations
		// => add them one by one; create a separate aggregation key for each of them, if needed (06630)

		// task 08606: find the last iciol for this candidate which is not in dispute
		// If the QtytoInvoice for 'ic' is greater than the delivered qty for all the iols, then we will assign/allocate the surplus qty to this one.
		// Notes:
		// * we need to assign it to the icIol that is added last, because if the qty is allocated too early, it is not available to other iciol anymore. In other words, we want to allocate the IC's
		// *full* qtyToInvoice, but when doing so, we need to prefer those icIols whose iols actuually do have a Qtydelivered.
		// * we assume that if there is any iciol at all (i.e. !icIols.isEmpty() ), then there is also one that is not in dispute, because each in-dispute-iol comes in a pair with a
		// not-in-dispute-iol.
		I_C_InvoiceCandidate_InOutLine lastNondisputeIcIol = null;
		for (final I_C_InvoiceCandidate_InOutLine iciol : iciols)
		{
			if (InterfaceWrapperHelper.create(iciol.getM_InOutLine(), de.metas.invoicecandidate.model.I_M_InOutLine.class).isInDispute())
			{
				continue;
			}
			lastNondisputeIcIol = iciol;
		}

		// now add them, flagging the last one for special treatment (see comment above)
		for (final I_C_InvoiceCandidate_InOutLine icIol : iciols)
		{
			final boolean isLast = icIol == lastNondisputeIcIol;
			addInvoiceCandidateForInOutLine(ic, icIol, isLast);
		}

		return this;
	}

	private AggregationKey getHeaderAggregationKey(final I_C_Invoice_Candidate ic)
	{
		AggregationKey aggregationKey;
		if (alwaysUseDefaultHeaderAggregationKeyBuilder)
		{
			final Properties ctx = InterfaceWrapperHelper.getCtx(ic);
			final IAggregationKeyBuilder<I_C_Invoice_Candidate> defaultAggregationKeyBuilder = aggregationFactory.getDefaultAggregationKeyBuilder(
					ctx,
					I_C_Invoice_Candidate.class,
					ic.isSOTrx(),
					X_C_Aggregation.AGGREGATIONUSAGELEVEL_Header);

			aggregationKey = defaultAggregationKeyBuilder.buildAggregationKey(ic);
		}
		else
		{
			aggregationKey = new AggregationKey(ic.getHeaderAggregationKey(), AggregationId.ofRepoIdOrNull(ic.getHeaderAggregationKeyBuilder_ID()));
		}

		//
		// Append DateInvoiced to our aggregation key
		final LocalDate dateInvoiced = computeDateInvoiced(ic);
		aggregationKey = aggregationKey.append("DateInvoiced=" + dateInvoiced);

		//
		// Append DateAcct to our aggregation key
		final LocalDate dateAcct = computeDateInvoiced(ic);
		aggregationKey = aggregationKey.append("DateAcct=" + dateAcct);

		return aggregationKey;
	}

	/**
	 * Add an Invoice Candidate to be aggregated.
	 * <p>
	 * If the InOutLine association <code>iciol</code> is not <code>null</code>, create an extended aggregation key for it; otherwise create a normal header key.
	 *
	 * @param iciol       IC-IOL association (could be <code>null</code>)
	 * @param isLastIcIol if true, then we need to allocate all the given <code>ic</code>'s remaining qtyToInvoice to the given icIol.
	 */
	private void addInvoiceCandidateForInOutLine(
			@NonNull final I_C_Invoice_Candidate icRecord,
			@Nullable final I_C_InvoiceCandidate_InOutLine iciol,
			final boolean isLastIcIol)
	{
		final I_M_InOutLine icInOutLine = iciol == null ? null : iciol.getM_InOutLine();
		final InOutId inoutId = icInOutLine != null ? InOutId.ofRepoIdOrNull(icInOutLine.getM_InOut_ID()) : null;

		//
		// Get and parse aggregation key
		// => resolve last variables, right before invoicing
		final AggregationKey headerAggregationKey;
		{
			final AggregationKey headerAggregationKeyUnparsed = getHeaderAggregationKey(icRecord);
			final AggregationKeyEvaluationContext evalCtx = AggregationKeyEvaluationContext.builder()
					.invoiceCandidate(icRecord)
					.inoutLine(icInOutLine)
					.build();
			headerAggregationKey = headerAggregationKeyUnparsed.parse(evalCtx);
		}

		//
		// Get/Create InvoiceHeaderAndLineAggregators structure for current header aggregation key
		InvoiceHeaderAndLineAggregators headerAndAggregators = key2headerAndAggregators.get(headerAggregationKey);
		if (headerAndAggregators == null)
		{
			headerAndAggregators = new InvoiceHeaderAndLineAggregators(headerAggregationKey);
			key2headerAndAggregators.put(headerAggregationKey, headerAndAggregators);

			final InvoiceHeaderImplBuilder invoiceHeader = headerAndAggregators.getInvoiceHeader();
			addToInvoiceHeader(invoiceHeader, icRecord, inoutId);

			// task 08451: log why we create a new invoice header
			final ILoggable loggable = Loggables.withLogger(logger, Level.DEBUG);
			loggable.addLog("Created new InvoiceHeaderAndLineAggregators instance. current number: {}\n"
							+ "Params: ['ic'={}, 'headerAggregationKey'={}, 'inutId'={}, 'iciol'={}];\n"
							+ " ic's own headerAggregationKey = {};\n"
							+ " new headerAndAggregators = {}",
					key2headerAndAggregators.size(), icRecord, headerAggregationKey, inoutId, iciol, icRecord.getHeaderAggregationKey(), headerAndAggregators);
		}
		else
		{
			final InvoiceHeaderImplBuilder invoiceHeader = headerAndAggregators.getInvoiceHeader();
			addToInvoiceHeader(invoiceHeader, icRecord, inoutId);
		}

		//
		// Get/Create the Invoice Line aggregator
		final int invoiceCandidateAggId = icRecord.getC_Invoice_Candidate_Agg_ID();
		IAggregator lineAggregator = headerAndAggregators.getLineAggregator(invoiceCandidateAggId);
		if (lineAggregator == null)
		{
			lineAggregator = aggregationBL.createInvoiceLineAggregatorInstance(icRecord);
			headerAndAggregators.setLineAggregator(invoiceCandidateAggId, lineAggregator);
		}

		// note: even if the iol is in dispute, we will call the aggregator. Allthough we don't expect it to be invoiced there are currently different ways of "not invoicing":
		// 1. ignore them alltogether
		// 2. invoice them, but also subtract directly them in another invoice line

		final InvoiceLineAggregationRequest.Builder icAggregationRequestBuilder = InvoiceLineAggregationRequest.builder()
				.setC_Invoice_Candidate(icRecord)
				.setC_InvoiceCandidate_InOutLine(iciol);

		// different orders need to go into different invoice lines
		// and different order lines need to go into different invoice lines
		// but note: if the ic references an InOutLine (Gebinde/Packagingmaterial!), then ICs may be aggregated into one invoice line.
		// This works, because all those IC have the same C_OrderLine_ID (i.e. 0).
		// icAggregationRequest.addLineAggregationKeyElement(ic.getC_Order_ID());
		// icAggregationRequest.addLineAggregationKeyElement(ic.getC_OrderLine_ID());

		// task 08543: *do not* aggregate different ICs into one invoice line. This includes "Gebinde/Packagingmaterial!"
		// background: the user expects the invoice candidates to be transformed into invoice lines one-by-one.
		// NOTE: this shall be configured in line aggregation definition.
		// For legacy key builder we moved to de.metas.invoicecandidate.agg.key.impl.ICLineAggregationKeyBuilder_OLD.buildAggregationKey(I_C_Invoice_Candidate)
		// icAggregationRequestBuilder.addLineAggregationKeyElement(ic.getC_Invoice_Candidate_ID());

		if (iciol != null)
		{
			final I_M_InOutLine inOutLine = iciol.getM_InOutLine();

			//
			// Extract relevant product attribute instances from inout line
			// Those shall be present on invoice line.
			// FIXME: this shall not be hardcoded, but handled by C_Aggregation configuration, as an AggregationItem of type Attribute
			final List<IInvoiceLineAttribute> invoiceLineAttributes = aggregationBL.extractInvoiceLineAttributes(inOutLine);
			icAggregationRequestBuilder.addInvoiceLineAttributes(invoiceLineAttributes);

			//
			// Sales iols from different inOuts shall go into different invoice lines
			// NOTE: this shall be configured in line aggregation definition.
			// For legacy key builder we moved to de.metas.invoicecandidate.agg.key.impl.ICLineAggregationKeyBuilder_OLD.buildAggregationKey(I_C_Invoice_Candidate)
			// if (ic.isSOTrx())
			// {
			// icAggregationRequestBuilder.addLineAggregationKeyElement(inOutLine.getM_InOut_ID());
			// }

			// this is only relevant if iciol != null. Otherwise we allocate the full invoicable Qty anyways.
			icAggregationRequestBuilder.setAllocateRemainingQty(isLastIcIol);
		}

		//
		// Add invoice candidate to invoice line aggregator
		final IInvoiceLineAggregationRequest icAggregationRequest = icAggregationRequestBuilder.build();
		lineAggregator.addInvoiceCandidate(icAggregationRequest);
	}

	private void addToInvoiceHeader(
			@NonNull final InvoiceHeaderImplBuilder invoiceHeader,
			@NonNull final I_C_Invoice_Candidate icRecord,
			@Nullable final InOutId inoutId)
	{
		try
		{
			final BPartnerLocationId billBPLocationId = getBillLocationId(icRecord);
			final BPartnerContactId billContactId = getBillContactId(icRecord, billBPLocationId);

			invoiceHeader.setAD_Org_ID(icRecord.getAD_Org_ID());
			invoiceHeader.setBill_BPartner_ID(billBPLocationId.getBpartnerId().getRepoId());
			invoiceHeader.setBill_Location_ID(billBPLocationId.getRepoId());
			invoiceHeader.setBill_User_ID(BPartnerContactId.toRepoId(billContactId));
			invoiceHeader.setC_BPartner_SalesRep_ID(icRecord.getC_BPartner_SalesRep_ID());
			invoiceHeader.setC_BPartner_SalesRep_ID(icRecord.getC_BPartner_SalesRep_ID());
			invoiceHeader.setC_Order_ID(icRecord.getC_Order_ID());
			invoiceHeader.setPOReference(icRecord.getPOReference()); // task 07978
		final OrderId orderId = OrderId.ofRepoIdOrNull(icRecord.getC_Order_ID());
		if (orderId != null)
		{
			invoiceHeader.setExternalId(orderDAO.getById(orderId).getExternalId());
		}

			// why not using DateToInvoice[_Override] if available?
			// ts: DateToInvoice[_Override] is "just" the field saying from which date onwards this icRecord may be invoiced
			// tsa: true, but as far as i can see, using the Override is available could be also intuitive for user. More, in some test this logic is also assumed.
			final LocalDate dateInvoiced = computeDateInvoiced(icRecord);
			logger.debug("Setting invoiceHeader's dateInvoiced={}", dateInvoiced);
			invoiceHeader.setDateInvoiced(dateInvoiced);

			final LocalDate dateAcct = computeDateAcct(icRecord);
			logger.debug("Setting invoiceHeader's dateAcct={}", dateAcct);
			invoiceHeader.setDateAcct(dateAcct);

			// #367 Invoice candidates invoicing Pricelist not found
			// https://github.com/metasfresh/metasfresh/issues/367
			// If we know the PLV, then just go with the PLV's M_PriceList_ID (new behavior).
			// Otherwise falls back to looking up the M_PriceList_ID via M_PricingSystem, location and SOTrx (old behavior).
			// The old behavior can fail as described by #367.
			final int M_PriceList_ID;
			if (icRecord.getM_PriceList_Version_ID() > 0)
			{
				M_PriceList_ID = priceListDAO.getPriceListByPriceListVersionId(PriceListVersionId.ofRepoId(icRecord.getM_PriceList_Version_ID())).getM_PriceList_ID();
			}
			else
			{
				final BPartnerLocationId bpLocationId = BPartnerLocationId.ofRepoId(icRecord.getBill_BPartner_ID(), icRecord.getBill_Location_ID());
				final PriceListId plId = priceListDAO.retrievePriceListIdByPricingSyst(
						PricingSystemId.ofRepoIdOrNull(icRecord.getM_PricingSystem_ID()),
						bpLocationId,
						SOTrx.ofBoolean(icRecord.isSOTrx()));
				if (plId == null)
				{
					throw new AdempiereException(ERR_INVOICE_CAND_PRICE_LIST_MISSING_2P,
							new Object[] {
									icRecord.getM_PricingSystem_ID() > 0 ? loadOutOfTrx(icRecord.getM_PricingSystem_ID(), I_M_PricingSystem.class).getName() : "NO PRICING-SYTEM",
									invoiceHeader.getBill_Location_ID() > 0 ? loadOutOfTrx(invoiceHeader.getBill_Location_ID(), I_C_BPartner_Location.class).getName() : "NO BILL-TO-LOCATION" });
				}
				M_PriceList_ID = plId.getRepoId();
			}
			invoiceHeader.setM_PriceList_ID(M_PriceList_ID);
			// #367 end

			// 03805: set also the currency id
			invoiceHeader.setC_Currency_ID(icRecord.getC_Currency_ID());

			// 04258: set header and footer
			invoiceHeader.setDescription(icRecord.getDescriptionHeader());
			invoiceHeader.setDescriptionBottom(icRecord.getDescriptionBottom());

			invoiceHeader.setIsSOTrx(icRecord.isSOTrx());

			invoiceHeader.setTaxIncluded(invoiceCandBL.isTaxIncluded(icRecord)); // task 08541

			if (icRecord.getC_DocTypeInvoice_ID() > 0)
			{
				final I_C_DocType docTypeInvoice = docTypeDAO.getById(icRecord.getC_DocTypeInvoice_ID());
				invoiceHeader.setC_DocTypeInvoice(docTypeInvoice);
			}

			// 06630: set shipment id to header
			invoiceHeader.setM_InOut_ID(InOutId.toRepoId(inoutId));
		}
		catch (final RuntimeException rte)
		{
			throw AdempiereException.wrapIfNeeded(rte).appendParametersToMessage()
					.setParameter("C_Invoice_Candidate_ID", icRecord.getC_Invoice_Candidate_ID())
					.setParameter("M_InOut_ID", InOutId.toRepoId(inoutId));
		}
	}

	private LocalDate computeDateInvoiced(@NonNull final I_C_Invoice_Candidate ic)
	{
		return CoalesceUtil.coalesceSuppliers(
				() -> {
					if (dateInvoicedParam != null)
					{
						logger.debug("computeDateInvoiced - returning aggregator's dateInvoicedParam={} as dateInvoiced", dateInvoicedParam);
					}
					return dateInvoicedParam;
				},
				() -> {
					final LocalDate result = TimeUtil.asLocalDate(ic.getPresetDateInvoiced());
					if (result != null)
					{
						logger.debug("computeDateInvoiced - returning ic's presetDateInvoiced={} as dateInvoiced", result);
					}
					return result;
				},
				() -> {
					final LocalDate result = TimeUtil.asLocalDate(ic.getDateInvoiced());
					if (result != null)
					{
						logger.debug("computeDateInvoiced - returning ic's dateInvoiced={} as dateInvoiced", result);
					}
					return result;
				},
				() -> {
					logger.debug("computeDateInvoiced - returning aggregator's today={} as dateInvoiced", today);
					return today;
				});
	}

	private LocalDate computeDateAcct(@NonNull final I_C_Invoice_Candidate ic)
	{
		return CoalesceUtil.coalesceSuppliers(
				() -> {
					if (dateAcctParam != null)
					{
						logger.debug("computeDateAcct - returning aggregator's dateAcctParam={} as dateAcct", dateAcctParam);
					}
					return dateAcctParam;
				},
				() -> {
					final LocalDate result = TimeUtil.asLocalDate(ic.getPresetDateInvoiced());
					if (result != null)
					{
						logger.debug("computeDateAcct - returning ic's presetDateInvoiced={} as dateAcct", result);
					}
					return result;
				},
				() -> {
					final LocalDate result = TimeUtil.asLocalDate(ic.getDateAcct());
					if (result != null)
					{
						logger.debug("computeDateAcct - returning ic's dateAcct={} as dateAcct", result);
					}
					return result;
				},
				() -> {
					logger.debug("computeDateAcct - falling back to aggregator's computeDateInvoiced as dateAcct");
					return computeDateInvoiced(ic);
				});
	}

	@NonNull
	private BPartnerLocationId getBillLocationId(@NonNull final I_C_Invoice_Candidate ic)
	{
		final BPartnerId bpartnerId = BPartnerId.ofRepoId(ic.getBill_BPartner_ID());
		final BPartnerLocationId billBPLocationOverrideId = BPartnerLocationId.ofRepoIdOrNull(bpartnerId, ic.getBill_Location_Override_ID());
		if (billBPLocationOverrideId != null)
		{
			return billBPLocationOverrideId;
		}

		if (useDefaultBillLocationAndContactIfNotOverride)
		{
			final BPartnerLocationId defaulBillLocationId = bpartnerDAO.retrieveCurrentBillLocationOrNull(bpartnerId);
			if (defaulBillLocationId != null)
			{
				return defaulBillLocationId;
			}
		}

		return BPartnerLocationId.ofRepoId(bpartnerId, ic.getBill_Location_ID());
	}

	private BPartnerContactId getBillContactId(
			@NonNull final I_C_Invoice_Candidate ic,
			final BPartnerLocationId billBPLocationId)
	{
		final BPartnerId bpartnerId = BPartnerId.ofRepoId(ic.getBill_BPartner_ID());
		final BPartnerContactId billContactOverrideId = BPartnerContactId.ofRepoIdOrNull(bpartnerId, ic.getBill_User_ID_Override_ID());
		if (billContactOverrideId != null)
		{
			return billContactOverrideId;
		}

		if (useDefaultBillLocationAndContactIfNotOverride)
		{
			final User defaultBillContact = bpartnerBL.retrieveContactOrNull(RetrieveContactRequest.builder()
					.onlyActive(true)
					.contactType(ContactType.BILL_TO_DEFAULT)
					.bpartnerId(billBPLocationId.getBpartnerId())
					.bPartnerLocationId(billBPLocationId)
					.ifNotFound(IfNotFound.RETURN_NULL)
					.build());
			if (defaultBillContact != null)
			{
				return BPartnerContactId.ofRepoId(defaultBillContact.getBpartnerId(), defaultBillContact.getId().getRepoId());
			}
		}
		return BPartnerContactId.ofRepoIdOrNull(bpartnerId, ic.getBill_User_ID());
	}

	public List<IInvoiceHeader> aggregate()
	{
		final List<IInvoiceHeader> invoiceHeaders = new ArrayList<>();

		for (final InvoiceHeaderAndLineAggregators headerAndAggregators : key2headerAndAggregators.values())
		{
			final IInvoiceHeader invoiceHeader = aggregate(headerAndAggregators);

			final ILoggable loggable = Loggables.get();
			if (!Loggables.isNull(loggable))
			{
				loggable.addLog("Aggregated InvoiceHeaderAndLineAggregators=" + headerAndAggregators + "; result IInvoiceHeader=" + invoiceHeader);
			}

			// Skip it if the invoice could not be aggregated for some reason
			if (invoiceHeader == null)
			{
				continue;
			}

			invoiceHeaders.add(invoiceHeader);
		}

		return invoiceHeaders;
	}

	/**
	 * Aggregates all invoice lines and populate {@link IInvoiceHeader}'s lines.
	 *
	 * @param headerAndAggregators
	 * @return {@link IInvoiceHeader} or <code>null</code>
	 */
	private IInvoiceHeader aggregate(final InvoiceHeaderAndLineAggregators headerAndAggregators)
	{
		final InvoiceHeaderImplBuilder invoiceHeaderBuilder = headerAndAggregators.getInvoiceHeader();
		final InvoiceHeaderImpl invoiceHeader = invoiceHeaderBuilder.build();

		final ArrayList<IAggregator> lineAggregators = new ArrayList<>(headerAndAggregators.getLineAggregators());

		//
		// Initialize invoice header's lines
		final List<IInvoiceCandAggregate> lines = new ArrayList<>();
		invoiceHeader.setLines(lines);

		//
		// Iterate invoice line aggregators and ask them to create the line aggregates
		for (final IAggregator lineAggregator : lineAggregators)
		{
			final List<IInvoiceCandAggregate> invoiceCandAggregates = lineAggregator.aggregate();
			lines.addAll(invoiceCandAggregates);
		}

		// If there are no lines, there is no point to have this invoice header, so discard it
		if (lines.isEmpty())
		{
			return null;
		}

		// Set Invoice's DocBaseType
		setDocBaseType(invoiceHeader);

		return invoiceHeader;
	}

	// NOTE: not static because we are using services
	private/* static */void setDocBaseType(final InvoiceHeaderImpl invoiceHeader)
	{
		final boolean invoiceIsSOTrx = invoiceHeader.isSOTrx();
		final String docBaseType;

		//
		// Case: Invoice DocType was preset
		if (invoiceHeader.getC_DocTypeInvoice() != null)
		{
			final I_C_DocType invoiceDocType = invoiceHeader.getC_DocTypeInvoice();
			Check.assume(invoiceIsSOTrx == invoiceDocType.isSOTrx(), "InvoiceHeader's IsSOTrx={} shall match document type {}", invoiceIsSOTrx, invoiceDocType);

			docBaseType = invoiceDocType.getDocBaseType();
		}
		//
		// Case: no invoice DocType was set
		// We need to find out the DocBaseType based on Total Amount and IsSOTrx
		else
		{
			final Money totalAmt = invoiceHeader.calculateTotalNetAmtFromLines();

			if (invoiceIsSOTrx)
			{
				if (totalAmt.signum() < 0)
				{
					// AR Credit Memo Invoice (sales)
					docBaseType = X_C_DocType.DOCBASETYPE_ARCreditMemo;
				}
				else
				{
					// Regular AR Invoice (sales)
					docBaseType = X_C_DocType.DOCBASETYPE_ARInvoice;
				}
			}
			else
			{
				if (totalAmt.signum() < 0)
				{
					docBaseType = X_C_DocType.DOCBASETYPE_APCreditMemo;
				}
				else
				{
					docBaseType = X_C_DocType.DOCBASETYPE_APInvoice;
				}
			}
		}

		//
		// NOTE: in credit memos, amount are positive but the invoice effect is reversed
		if (invoiceBL.isCreditMemo(docBaseType))
		{
			invoiceHeader.negateAllLineAmounts();
		}

		invoiceHeader.setDocBaseType(docBaseType);
		invoiceHeader.setC_PaymentTerm_ID(getC_PaymentTerm_ID(invoiceHeader));
	}

	private int getC_PaymentTerm_ID(final InvoiceHeaderImpl invoiceHeader)
	{
		final int C_PaymentTerm_ID = extractC_PaymentTerm_IDFromLines(invoiceHeader);

		if (C_PaymentTerm_ID > 0)
		{
			return C_PaymentTerm_ID;
		}
		// task 07242: setting the payment term from the given bill partner. Note that C_BP_Group has no payment term columns, so we don't need a BL to fall back to C_BP_Group
		final I_C_BPartner billPartner = InterfaceWrapperHelper.loadOutOfTrx(invoiceHeader.getBillBPartnerId(), I_C_BPartner.class);
		if (invoiceHeader.isSOTrx())
		{
			return billPartner.getC_PaymentTerm_ID();
		}
		else
		{
			return billPartner.getPO_PaymentTerm_ID();
		}
	}

	/**
	 * extract C_PaymentTerm_ID from invoice candidate
	 *
	 * @return
	 */
	private int extractC_PaymentTerm_IDFromLines(@NonNull final InvoiceHeaderImpl invoiceHeader)
	{
		final List<IInvoiceCandAggregate> lines = invoiceHeader.getLines();
		if (lines == null || lines.isEmpty())
		{
			return -1;
		}

		final Map<Integer, IInvoiceLineRW> uniquePaymentTermLines = mapUniqueIInvoiceLineRWPerPaymentTerm(lines);
		// extract payment term if all lines have same C_PaymentTerm_ID
		if (uniquePaymentTermLines.size() == 1)
		{
			final Set<Integer> ids = uniquePaymentTermLines.keySet();
			final int id = ids.iterator().next();
			if (id > 0)
			{
				return id;
			}
		}

		return -1;
	}

	private Map<Integer, IInvoiceLineRW> mapUniqueIInvoiceLineRWPerPaymentTerm(@NonNull final List<IInvoiceCandAggregate> lines)
	{
		final List<IInvoiceLineRW> invoiceLinesRW = new ArrayList<>();
		lines.forEach(lineAgg -> invoiceLinesRW.addAll(lineAgg.getAllLines()));

		return invoiceLinesRW.stream()
				.collect(GuavaCollectors.toImmutableMapByKey(line -> line.getC_PaymentTerm_ID()));
	}
}
