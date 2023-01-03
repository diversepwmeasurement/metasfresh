//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 12:02:48 PM CET 
//


package de.metas.edi.esb.jaxb.metasfresh;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EDI_cctop_invoic_500_vType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDI_cctop_invoic_500_vType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="C_Invoice_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="EanCom_UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_invoic_500_v_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="ISO_Code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Line" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="LineNetAmt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Name2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PriceActual" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="PriceList" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="QtyInvoiced" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="taxfree" type="{}YES-NO" minOccurs="0"/&gt;
 *         &lt;element name="Value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerProductNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EDI_cctop_invoic_v_ID" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="Leergut" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ProductDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderPOReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderLine" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="QtyInvoicedInOrderedUOM" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="EanCom_Ordered_UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TaxAmtInfo" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="EanCom_Price_UOM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EAN_CU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EAN_TU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="GTIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UPC_CU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UPC_TU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Buyer_GTIN_TU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Buyer_GTIN_CU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Buyer_EAN_CU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Supplier_GTIN_CU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="InvoicableQtyBasedOn" type="{}InvoicableQtyBasedOnEnum" minOccurs="0"/&gt;
 *         &lt;element name="C_UOM_BPartner_ID" type="{}EDI_Exp_C_UOMType" minOccurs="0"/&gt;
 *         &lt;element name="QtyEnteredInBPartnerUOM" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ExternalSeqNo" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDI_cctop_invoic_500_vType", propOrder = {
    "cInvoiceID",
    "eanComUOM",
    "ediCctopInvoic500VID",
    "isoCode",
    "line",
    "lineNetAmt",
    "name",
    "name2",
    "priceActual",
    "priceList",
    "qtyInvoiced",
    "rate",
    "taxfree",
    "value",
    "customerProductNo",
    "ediCctopInvoicVID",
    "leergut",
    "productDescription",
    "orderPOReference",
    "orderLine",
    "qtyInvoicedInOrderedUOM",
    "eanComOrderedUOM",
    "taxAmtInfo",
    "eanComPriceUOM",
    "eancu",
    "eantu",
    "gtin",
    "upccu",
    "upctu",
    "buyerGTINTU",
    "buyerGTINCU",
    "buyerEANCU",
    "supplierGTINCU",
    "invoicableQtyBasedOn",
    "cuombPartnerID",
    "qtyEnteredInBPartnerUOM",
    "externalSeqNo"
})
public class EDICctopInvoic500VType {

    @XmlElement(name = "C_Invoice_ID")
    protected BigInteger cInvoiceID;
    @XmlElement(name = "EanCom_UOM")
    protected String eanComUOM;
    @XmlElement(name = "EDI_cctop_invoic_500_v_ID")
    protected BigInteger ediCctopInvoic500VID;
    @XmlElement(name = "ISO_Code")
    protected String isoCode;
    @XmlElement(name = "Line")
    protected BigInteger line;
    @XmlElement(name = "LineNetAmt")
    protected BigDecimal lineNetAmt;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Name2")
    protected String name2;
    @XmlElement(name = "PriceActual")
    protected BigDecimal priceActual;
    @XmlElement(name = "PriceList")
    protected BigDecimal priceList;
    @XmlElement(name = "QtyInvoiced")
    protected BigDecimal qtyInvoiced;
    @XmlElement(name = "Rate")
    protected BigDecimal rate;
    protected String taxfree;
    @XmlElement(name = "Value")
    protected String value;
    @XmlElement(name = "CustomerProductNo")
    protected String customerProductNo;
    @XmlElement(name = "EDI_cctop_invoic_v_ID")
    protected BigInteger ediCctopInvoicVID;
    @XmlElement(name = "Leergut")
    protected String leergut;
    @XmlElement(name = "ProductDescription")
    protected String productDescription;
    @XmlElement(name = "OrderPOReference")
    protected String orderPOReference;
    @XmlElement(name = "OrderLine")
    protected BigInteger orderLine;
    @XmlElement(name = "QtyInvoicedInOrderedUOM")
    protected BigDecimal qtyInvoicedInOrderedUOM;
    @XmlElement(name = "EanCom_Ordered_UOM")
    protected String eanComOrderedUOM;
    @XmlElement(name = "TaxAmtInfo")
    protected BigDecimal taxAmtInfo;
    @XmlElement(name = "EanCom_Price_UOM")
    protected String eanComPriceUOM;
    @XmlElement(name = "EAN_CU")
    protected String eancu;
    @XmlElement(name = "EAN_TU")
    protected String eantu;
    @XmlElement(name = "GTIN")
    protected String gtin;
    @XmlElement(name = "UPC_CU")
    protected String upccu;
    @XmlElement(name = "UPC_TU")
    protected String upctu;
    @XmlElement(name = "Buyer_GTIN_TU")
    protected String buyerGTINTU;
    @XmlElement(name = "Buyer_GTIN_CU")
    protected String buyerGTINCU;
    @XmlElement(name = "Buyer_EAN_CU")
    protected String buyerEANCU;
    @XmlElement(name = "Supplier_GTIN_CU")
    protected String supplierGTINCU;
    @XmlElement(name = "InvoicableQtyBasedOn")
    @XmlSchemaType(name = "string")
    protected InvoicableQtyBasedOnEnum invoicableQtyBasedOn;
    @XmlElement(name = "C_UOM_BPartner_ID")
    protected EDIExpCUOMType cuombPartnerID;
    @XmlElement(name = "QtyEnteredInBPartnerUOM")
    protected BigDecimal qtyEnteredInBPartnerUOM;
    @XmlElement(name = "ExternalSeqNo")
    protected BigInteger externalSeqNo;

    /**
     * Gets the value of the cInvoiceID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCInvoiceID() {
        return cInvoiceID;
    }

    /**
     * Sets the value of the cInvoiceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCInvoiceID(BigInteger value) {
        this.cInvoiceID = value;
    }

    /**
     * Gets the value of the eanComUOM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEanComUOM() {
        return eanComUOM;
    }

    /**
     * Sets the value of the eanComUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEanComUOM(String value) {
        this.eanComUOM = value;
    }

    /**
     * Gets the value of the ediCctopInvoic500VID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEDICctopInvoic500VID() {
        return ediCctopInvoic500VID;
    }

    /**
     * Sets the value of the ediCctopInvoic500VID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEDICctopInvoic500VID(BigInteger value) {
        this.ediCctopInvoic500VID = value;
    }

    /**
     * Gets the value of the isoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCode() {
        return isoCode;
    }

    /**
     * Sets the value of the isoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCode(String value) {
        this.isoCode = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLine(BigInteger value) {
        this.line = value;
    }

    /**
     * Gets the value of the lineNetAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLineNetAmt() {
        return lineNetAmt;
    }

    /**
     * Sets the value of the lineNetAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLineNetAmt(BigDecimal value) {
        this.lineNetAmt = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the name2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName2() {
        return name2;
    }

    /**
     * Sets the value of the name2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName2(String value) {
        this.name2 = value;
    }

    /**
     * Gets the value of the priceActual property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceActual() {
        return priceActual;
    }

    /**
     * Sets the value of the priceActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceActual(BigDecimal value) {
        this.priceActual = value;
    }

    /**
     * Gets the value of the priceList property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPriceList() {
        return priceList;
    }

    /**
     * Sets the value of the priceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPriceList(BigDecimal value) {
        this.priceList = value;
    }

    /**
     * Gets the value of the qtyInvoiced property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQtyInvoiced() {
        return qtyInvoiced;
    }

    /**
     * Sets the value of the qtyInvoiced property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQtyInvoiced(BigDecimal value) {
        this.qtyInvoiced = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRate(BigDecimal value) {
        this.rate = value;
    }

    /**
     * Gets the value of the taxfree property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxfree() {
        return taxfree;
    }

    /**
     * Sets the value of the taxfree property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxfree(String value) {
        this.taxfree = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the customerProductNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerProductNo() {
        return customerProductNo;
    }

    /**
     * Sets the value of the customerProductNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerProductNo(String value) {
        this.customerProductNo = value;
    }

    /**
     * Gets the value of the ediCctopInvoicVID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEDICctopInvoicVID() {
        return ediCctopInvoicVID;
    }

    /**
     * Sets the value of the ediCctopInvoicVID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEDICctopInvoicVID(BigInteger value) {
        this.ediCctopInvoicVID = value;
    }

    /**
     * Gets the value of the leergut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLeergut() {
        return leergut;
    }

    /**
     * Sets the value of the leergut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLeergut(String value) {
        this.leergut = value;
    }

    /**
     * Gets the value of the productDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Sets the value of the productDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDescription(String value) {
        this.productDescription = value;
    }

    /**
     * Gets the value of the orderPOReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderPOReference() {
        return orderPOReference;
    }

    /**
     * Sets the value of the orderPOReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderPOReference(String value) {
        this.orderPOReference = value;
    }

    /**
     * Gets the value of the orderLine property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrderLine() {
        return orderLine;
    }

    /**
     * Sets the value of the orderLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrderLine(BigInteger value) {
        this.orderLine = value;
    }

    /**
     * Gets the value of the qtyInvoicedInOrderedUOM property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQtyInvoicedInOrderedUOM() {
        return qtyInvoicedInOrderedUOM;
    }

    /**
     * Sets the value of the qtyInvoicedInOrderedUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQtyInvoicedInOrderedUOM(BigDecimal value) {
        this.qtyInvoicedInOrderedUOM = value;
    }

    /**
     * Gets the value of the eanComOrderedUOM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEanComOrderedUOM() {
        return eanComOrderedUOM;
    }

    /**
     * Sets the value of the eanComOrderedUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEanComOrderedUOM(String value) {
        this.eanComOrderedUOM = value;
    }

    /**
     * Gets the value of the taxAmtInfo property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxAmtInfo() {
        return taxAmtInfo;
    }

    /**
     * Sets the value of the taxAmtInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxAmtInfo(BigDecimal value) {
        this.taxAmtInfo = value;
    }

    /**
     * Gets the value of the eanComPriceUOM property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEanComPriceUOM() {
        return eanComPriceUOM;
    }

    /**
     * Sets the value of the eanComPriceUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEanComPriceUOM(String value) {
        this.eanComPriceUOM = value;
    }

    /**
     * Gets the value of the eancu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEANCU() {
        return eancu;
    }

    /**
     * Sets the value of the eancu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEANCU(String value) {
        this.eancu = value;
    }

    /**
     * Gets the value of the eantu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEANTU() {
        return eantu;
    }

    /**
     * Sets the value of the eantu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEANTU(String value) {
        this.eantu = value;
    }

    /**
     * Gets the value of the gtin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGTIN() {
        return gtin;
    }

    /**
     * Sets the value of the gtin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGTIN(String value) {
        this.gtin = value;
    }

    /**
     * Gets the value of the upccu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUPCCU() {
        return upccu;
    }

    /**
     * Sets the value of the upccu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUPCCU(String value) {
        this.upccu = value;
    }

    /**
     * Gets the value of the upctu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUPCTU() {
        return upctu;
    }

    /**
     * Sets the value of the upctu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUPCTU(String value) {
        this.upctu = value;
    }

    /**
     * Gets the value of the buyerGTINTU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerGTINTU() {
        return buyerGTINTU;
    }

    /**
     * Sets the value of the buyerGTINTU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerGTINTU(String value) {
        this.buyerGTINTU = value;
    }

    /**
     * Gets the value of the buyerGTINCU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerGTINCU() {
        return buyerGTINCU;
    }

    /**
     * Sets the value of the buyerGTINCU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerGTINCU(String value) {
        this.buyerGTINCU = value;
    }

    /**
     * Gets the value of the buyerEANCU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerEANCU() {
        return buyerEANCU;
    }

    /**
     * Sets the value of the buyerEANCU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerEANCU(String value) {
        this.buyerEANCU = value;
    }

    /**
     * Gets the value of the supplierGTINCU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplierGTINCU() {
        return supplierGTINCU;
    }

    /**
     * Sets the value of the supplierGTINCU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplierGTINCU(String value) {
        this.supplierGTINCU = value;
    }

    /**
     * Gets the value of the invoicableQtyBasedOn property.
     * 
     * @return
     *     possible object is
     *     {@link InvoicableQtyBasedOnEnum }
     *     
     */
    public InvoicableQtyBasedOnEnum getInvoicableQtyBasedOn() {
        return invoicableQtyBasedOn;
    }

    /**
     * Sets the value of the invoicableQtyBasedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoicableQtyBasedOnEnum }
     *     
     */
    public void setInvoicableQtyBasedOn(InvoicableQtyBasedOnEnum value) {
        this.invoicableQtyBasedOn = value;
    }

    /**
     * Gets the value of the cuombPartnerID property.
     * 
     * @return
     *     possible object is
     *     {@link EDIExpCUOMType }
     *     
     */
    public EDIExpCUOMType getCUOMBPartnerID() {
        return cuombPartnerID;
    }

    /**
     * Sets the value of the cuombPartnerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDIExpCUOMType }
     *     
     */
    public void setCUOMBPartnerID(EDIExpCUOMType value) {
        this.cuombPartnerID = value;
    }

    /**
     * Gets the value of the qtyEnteredInBPartnerUOM property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQtyEnteredInBPartnerUOM() {
        return qtyEnteredInBPartnerUOM;
    }

    /**
     * Sets the value of the qtyEnteredInBPartnerUOM property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQtyEnteredInBPartnerUOM(BigDecimal value) {
        this.qtyEnteredInBPartnerUOM = value;
    }

    /**
     * Gets the value of the externalSeqNo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getExternalSeqNo() {
        return externalSeqNo;
    }

    /**
     * Sets the value of the externalSeqNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setExternalSeqNo(BigInteger value) {
        this.externalSeqNo = value;
    }

}
