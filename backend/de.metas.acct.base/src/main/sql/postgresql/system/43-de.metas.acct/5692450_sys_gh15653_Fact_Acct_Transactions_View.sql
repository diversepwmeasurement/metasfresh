DROP VIEW IF EXISTS Fact_Acct_Transactions_View;

CREATE VIEW Fact_Acct_Transactions_View AS
SELECT fact_acct_id,
       ad_client_id,
       ad_org_id,
       isactive,
       created,
       createdby,
       updated,
       updatedby,
       c_acctschema_id,
       account_id,
       datetrx,
       dateacct,
       c_period_id,
       ad_table_id,
       record_id,
       line_id,
       gl_category_id,
       gl_budget_id,
       c_tax_id,
       m_locator_id,
       postingtype,
       c_currency_id,
       amtsourcedr,
       amtsourcecr,
       amtacctdr,
       amtacctcr,
       c_uom_id,
       qty,
       m_product_id,
       c_bpartner_id,
       ad_orgtrx_id,
       c_locfrom_id,
       c_locto_id,
       c_salesregion_id,
       c_project_id,
       c_campaign_id,
       c_activity_id,
       user1_id,
       user2_id,
       description,
       a_asset_id,
       c_subacct_id,
       userelement1_id,
       userelement2_id,
       c_projectphase_id,
       c_projecttask_id,
       currencyrate,
       docstatus,
       subline_id,
       documentno,
       c_doctype_id,
       docbasetype,
       vatcode,
       counterpart_fact_acct_id,

       --
       userElementString1,
       userElementString2,
       userElementString3,
       userElementString4,
       userElementString5,
       userElementString6,
       userElementString7,
       --
       acctbalance(account_id, AmtAcctDr, amtacctcr) AS balance,
       userElementDate1,
       userElementDate2
FROM Fact_Acct fact;