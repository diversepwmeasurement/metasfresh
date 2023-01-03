//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 12:03:26 PM CET 
//


package at.erpel.schemas._1p0.documents;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PackagingDetailsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PackagingDetailsType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumberOfPackages" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="CustomersPackagingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SuppliersPackagingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PackagingCapacity" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackagingDetailsType", propOrder = {
    "numberOfPackages",
    "customersPackagingNumber",
    "suppliersPackagingNumber",
    "packagingCapacity"
})
public class PackagingDetailsType {

    @XmlElement(name = "NumberOfPackages")
    protected BigDecimal numberOfPackages;
    @XmlElement(name = "CustomersPackagingNumber")
    protected String customersPackagingNumber;
    @XmlElement(name = "SuppliersPackagingNumber")
    protected String suppliersPackagingNumber;
    @XmlElement(name = "PackagingCapacity")
    protected BigDecimal packagingCapacity;

    /**
     * Gets the value of the numberOfPackages property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNumberOfPackages() {
        return numberOfPackages;
    }

    /**
     * Sets the value of the numberOfPackages property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNumberOfPackages(BigDecimal value) {
        this.numberOfPackages = value;
    }

    /**
     * Gets the value of the customersPackagingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomersPackagingNumber() {
        return customersPackagingNumber;
    }

    /**
     * Sets the value of the customersPackagingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomersPackagingNumber(String value) {
        this.customersPackagingNumber = value;
    }

    /**
     * Gets the value of the suppliersPackagingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuppliersPackagingNumber() {
        return suppliersPackagingNumber;
    }

    /**
     * Sets the value of the suppliersPackagingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuppliersPackagingNumber(String value) {
        this.suppliersPackagingNumber = value;
    }

    /**
     * Gets the value of the packagingCapacity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPackagingCapacity() {
        return packagingCapacity;
    }

    /**
     * Sets the value of the packagingCapacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPackagingCapacity(BigDecimal value) {
        this.packagingCapacity = value;
    }

}
