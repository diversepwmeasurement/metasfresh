
package de.metas.postfinance.jaxb;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "B2BService", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface B2BService {


    /**
     * 
     * @param billerID
     * @param archiveData
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfInvoiceReport
     */
    @WebMethod(operationName = "GetInvoiceListBiller", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetInvoiceListBiller")
    @WebResult(name = "GetInvoiceListBillerResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetInvoiceListBiller", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoiceListBiller")
    @ResponseWrapper(localName = "GetInvoiceListBillerResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoiceListBillerResponse")
    public ArrayOfInvoiceReport getInvoiceListBiller(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param billDetail
     * @param transactionID
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfDownloadFile
     */
    @WebMethod(operationName = "GetInvoiceBiller", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetInvoiceBiller")
    @WebResult(name = "GetInvoiceBillerResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetInvoiceBiller", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoiceBiller")
    @ResponseWrapper(localName = "GetInvoiceBillerResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoiceBillerResponse")
    public ArrayOfDownloadFile getInvoiceBiller(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "TransactionID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String transactionID,
        @WebParam(name = "BillDetail", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean billDetail);

    /**
     * 
     * @param billerID
     * @param archiveData
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfProtocolReport
     */
    @WebMethod(operationName = "GetProcessProtocolList", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetProcessProtocolList")
    @WebResult(name = "GetProcessProtocolListResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetProcessProtocolList", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetProcessProtocolList")
    @ResponseWrapper(localName = "GetProcessProtocolListResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetProcessProtocolListResponse")
    public ArrayOfProtocolReport getProcessProtocolList(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param archiveData
     * @param createDate
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfDownloadFile
     */
    @WebMethod(operationName = "GetProcessProtocol", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetProcessProtocol")
    @WebResult(name = "GetProcessProtocolResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetProcessProtocol", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetProcessProtocol")
    @ResponseWrapper(localName = "GetProcessProtocolResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetProcessProtocolResponse")
    public ArrayOfDownloadFile getProcessProtocol(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "CreateDate", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        XMLGregorianCalendar createDate,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param archiveData
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfProtocolReport
     */
    @WebMethod(operationName = "GetRegistrationProtocolList", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetRegistrationProtocolList")
    @WebResult(name = "GetRegistrationProtocolListResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetRegistrationProtocolList", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetRegistrationProtocolList")
    @ResponseWrapper(localName = "GetRegistrationProtocolListResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetRegistrationProtocolListResponse")
    public ArrayOfProtocolReport getRegistrationProtocolList(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param archiveData
     * @param createDate
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfDownloadFile
     */
    @WebMethod(operationName = "GetRegistrationProtocol", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetRegistrationProtocol")
    @WebResult(name = "GetRegistrationProtocolResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetRegistrationProtocol", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetRegistrationProtocol")
    @ResponseWrapper(localName = "GetRegistrationProtocolResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetRegistrationProtocolResponse")
    public ArrayOfDownloadFile getRegistrationProtocol(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "CreateDate", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        XMLGregorianCalendar createDate,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param invoices
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfProcessedInvoice
     */
    @WebMethod(operationName = "UploadFilesReport", action = "http://ch.swisspost.ebill.b2bservice/B2BService/UploadFilesReport")
    @WebResult(name = "UploadFilesReportResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "UploadFilesReport", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.UploadFilesReport")
    @ResponseWrapper(localName = "UploadFilesReportResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.UploadFilesReportResponse")
    public ArrayOfProcessedInvoice uploadFilesReport(
        @WebParam(name = "invoices", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        ArrayOfInvoice invoices,
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID);

    /**
     * 
     * @param parameter
     * @return
     *     returns de.metas.postfinance.jaxb.SearchInvoicesResponse2
     */
    @WebMethod(operationName = "SearchInvoices", action = "http://ch.swisspost.ebill.b2bservice/B2BService/SearchInvoices")
    @WebResult(name = "SearchInvoicesResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "SearchInvoices", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.SearchInvoices")
    @ResponseWrapper(localName = "SearchInvoicesResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.SearchInvoicesResponse")
    public SearchInvoicesResponse2 searchInvoices(
        @WebParam(name = "Parameter", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        SearchInvoiceParameter parameter);

    /**
     * 
     * @param billerID
     * @param recipientID
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfEBillRecipientSubscriptionStatus
     */
    @WebMethod(operationName = "GetEBillRecipientSubscriptionStatus", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetEBillRecipientSubscriptionStatus")
    @WebResult(name = "GetEBillRecipientSubscriptionStatusResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetEBillRecipientSubscriptionStatus", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetEBillRecipientSubscriptionStatus")
    @ResponseWrapper(localName = "GetEBillRecipientSubscriptionStatusResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetEBillRecipientSubscriptionStatusResponse")
    public ArrayOfEBillRecipientSubscriptionStatus getEBillRecipientSubscriptionStatus(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "RecipientID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String recipientID);

    /**
     * 
     * @param billerID
     * @param recipientID
     * @return
     *     returns de.metas.postfinance.jaxb.EBillRecipientSubscriptionStatusBulk
     */
    @WebMethod(operationName = "GetEBillRecipientSubscriptionStatusBulk", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetEBillRecipientSubscriptionStatusBulk")
    @WebResult(name = "GetEBillRecipientSubscriptionStatusBulkResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetEBillRecipientSubscriptionStatusBulk", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetEBillRecipientSubscriptionStatusBulk")
    @ResponseWrapper(localName = "GetEBillRecipientSubscriptionStatusBulkResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetEBillRecipientSubscriptionStatusBulkResponse")
    public EBillRecipientSubscriptionStatusBulk getEBillRecipientSubscriptionStatusBulk(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "RecipientID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        ArrayOfstring recipientID);

    /**
     * 
     * @param billerID
     * @param subscriptionInitiationEmailAddress
     * @return
     *     returns de.metas.postfinance.jaxb.EBillRecipientSubscriptionInitiation
     */
    @WebMethod(operationName = "InitiateEBillRecipientSubscription", action = "http://ch.swisspost.ebill.b2bservice/B2BService/InitiateEBillRecipientSubscription")
    @WebResult(name = "InitiateEBillRecipientSubscriptionResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "InitiateEBillRecipientSubscription", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.InitiateEBillRecipientSubscription")
    @ResponseWrapper(localName = "InitiateEBillRecipientSubscriptionResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.InitiateEBillRecipientSubscriptionResponse")
    public EBillRecipientSubscriptionInitiation initiateEBillRecipientSubscription(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "SubscriptionInitiationEmailAddress", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String subscriptionInitiationEmailAddress);

    /**
     * 
     * @param billerID
     * @param subscriptionInitiationActivationCode
     * @param subscriptionInitiationToken
     * @return
     *     returns de.metas.postfinance.jaxb.EBillRecipientSubscriptionConfirmation
     */
    @WebMethod(operationName = "ConfirmEBillRecipientSubscription", action = "http://ch.swisspost.ebill.b2bservice/B2BService/ConfirmEBillRecipientSubscription")
    @WebResult(name = "ConfirmEBillRecipientSubscriptionResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "ConfirmEBillRecipientSubscription", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.ConfirmEBillRecipientSubscription")
    @ResponseWrapper(localName = "ConfirmEBillRecipientSubscriptionResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.ConfirmEBillRecipientSubscriptionResponse")
    public EBillRecipientSubscriptionConfirmation confirmEBillRecipientSubscription(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "SubscriptionInitiationToken", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String subscriptionInitiationToken,
        @WebParam(name = "SubscriptionInitiationActivationCode", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String subscriptionInitiationActivationCode);

    /**
     * 
     * @param billerID
     * @param archiveData
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfBillerReport
     */
    @WebMethod(operationName = "GetBillerReportList", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetBillerReportList")
    @WebResult(name = "GetBillerReportListResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetBillerReportList", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetBillerReportList")
    @ResponseWrapper(localName = "GetBillerReportListResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetBillerReportListResponse")
    public ArrayOfBillerReport getBillerReportList(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param fileType
     * @param createDate
     * @return
     *     returns de.metas.postfinance.jaxb.DownloadFile
     */
    @WebMethod(operationName = "GetBillerReport", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetBillerReport")
    @WebResult(name = "GetBillerReportResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetBillerReport", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetBillerReport")
    @ResponseWrapper(localName = "GetBillerReportResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetBillerReportResponse")
    public DownloadFile getBillerReport(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "CreateDate", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String createDate,
        @WebParam(name = "FileType", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String fileType);

    /**
     * 
     * @param billerID
     * @param eBillAccountID
     * @param transactionID
     * @param fileType
     * @return
     *     returns de.metas.postfinance.jaxb.DownloadFile
     */
    @WebMethod(operationName = "GetInvoicePayer", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetInvoicePayer")
    @WebResult(name = "GetInvoicePayerResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetInvoicePayer", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoicePayer")
    @ResponseWrapper(localName = "GetInvoicePayerResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoicePayerResponse")
    public DownloadFile getInvoicePayer(
        @WebParam(name = "eBillAccountID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String eBillAccountID,
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "TransactionID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String transactionID,
        @WebParam(name = "FileType", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String fileType);

    /**
     * 
     * @param eBillAccountID
     * @param archiveData
     * @return
     *     returns de.metas.postfinance.jaxb.ArrayOfInvoiceReport
     */
    @WebMethod(operationName = "GetInvoiceListPayer", action = "http://ch.swisspost.ebill.b2bservice/B2BService/GetInvoiceListPayer")
    @WebResult(name = "GetInvoiceListPayerResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "GetInvoiceListPayer", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoiceListPayer")
    @ResponseWrapper(localName = "GetInvoiceListPayerResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.GetInvoiceListPayerResponse")
    public ArrayOfInvoiceReport getInvoiceListPayer(
        @WebParam(name = "eBillAccountID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String eBillAccountID,
        @WebParam(name = "ArchiveData", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        boolean archiveData);

    /**
     * 
     * @param billerID
     * @param eBillAccountID
     * @param exceptionTest
     * @param errorTest
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ExecutePing", action = "http://ch.swisspost.ebill.b2bservice/B2BService/ExecutePing")
    @WebResult(name = "ExecutePingResult", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
    @RequestWrapper(localName = "ExecutePing", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.ExecutePing")
    @ResponseWrapper(localName = "ExecutePingResponse", targetNamespace = "http://ch.swisspost.ebill.b2bservice", className = "de.metas.postfinance.jaxb.ExecutePingResponse")
    public String executePing(
        @WebParam(name = "BillerID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String billerID,
        @WebParam(name = "eBillAccountID", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        String eBillAccountID,
        @WebParam(name = "ErrorTest", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        Boolean errorTest,
        @WebParam(name = "ExceptionTest", targetNamespace = "http://ch.swisspost.ebill.b2bservice")
        Boolean exceptionTest);

}
