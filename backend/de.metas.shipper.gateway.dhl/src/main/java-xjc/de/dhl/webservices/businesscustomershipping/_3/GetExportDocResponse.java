//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:45 PM CET 
//


package de.dhl.webservices.businesscustomershipping._3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://dhl.de/webservices/businesscustomershipping/3.0}Version"/&gt;
 *         &lt;element name="Status" type="{http://dhl.de/webservices/businesscustomershipping/3.0}Statusinformation"/&gt;
 *         &lt;element name="ExportDocData" type="{http://dhl.de/webservices/businesscustomershipping/3.0}ExportDocData" maxOccurs="30" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "version",
    "status",
    "exportDocData"
})
@XmlRootElement(name = "GetExportDocResponse")
public class GetExportDocResponse {

    @XmlElement(name = "Version", namespace = "http://dhl.de/webservices/businesscustomershipping/3.0", required = true)
    protected Version version;
    @XmlElement(name = "Status", required = true)
    protected Statusinformation status;
    @XmlElement(name = "ExportDocData")
    protected List<ExportDocData> exportDocData;

    /**
     * The version of the webservice implementation.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Statusinformation }
     *     
     */
    public Statusinformation getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Statusinformation }
     *     
     */
    public void setStatus(Statusinformation value) {
        this.status = value;
    }

    /**
     * Gets the value of the exportDocData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exportDocData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExportDocData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExportDocData }
     * 
     * 
     */
    public List<ExportDocData> getExportDocData() {
        if (exportDocData == null) {
            exportDocData = new ArrayList<ExportDocData>();
        }
        return this.exportDocData;
    }

}
