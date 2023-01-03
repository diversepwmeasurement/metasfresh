//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 12:03:26 PM CET 
//


package de.metas.edi.esb.jaxb.stepcom.invoic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DETAIL_Xrech complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DETAIL_Xrech"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DOCUMENTID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="LINENUMBER" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="SUBLINENUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ACTIONREQUEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DPRIN1" type="{}DPRIN1" maxOccurs="4"/&gt;
 *         &lt;element name="DPRDE1" type="{}DPRDE1" maxOccurs="5"/&gt;
 *         &lt;element name="DMESU1" type="{}DMESU1" maxOccurs="0" minOccurs="0"/&gt;
 *         &lt;element name="DQUAN1" type="{}DQUAN1" maxOccurs="5"/&gt;
 *         &lt;element name="DADDI1" type="{}DADDI1" maxOccurs="0" minOccurs="0"/&gt;
 *         &lt;element name="DDATE1" type="{}DDATE1" maxOccurs="0" minOccurs="0"/&gt;
 *         &lt;element name="DAMOU1" type="{}DAMOU1" maxOccurs="2"/&gt;
 *         &lt;element name="DTEXT1" type="{}DTEXT1" minOccurs="0"/&gt;
 *         &lt;element name="DPRIC1" type="{}DPRIC1" maxOccurs="2"/&gt;
 *         &lt;element name="DREFE1" type="{}DREFE1" maxOccurs="4" minOccurs="0"/&gt;
 *         &lt;element name="DPLAC1" type="{}DPLAC1" maxOccurs="0" minOccurs="0"/&gt;
 *         &lt;element name="DTAXI1" type="{}DTAXI1" minOccurs="0"/&gt;
 *         &lt;element name="DADRE1" type="{}DADRE1" maxOccurs="0" minOccurs="0"/&gt;
 *         &lt;element name="DALCH1" type="{}DALCH1" maxOccurs="10" minOccurs="0"/&gt;
 *         &lt;element name="DTRSD1" type="{}DTRSD1" maxOccurs="0" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DETAIL_Xrech", propOrder = {
    "documentid",
    "linenumber",
    "sublinenumber",
    "actionrequest",
    "dprin1",
    "dprde1",
    "dquan1",
    "damou1",
    "dtext1",
    "dpric1",
    "drefe1",
    "dtaxi1",
    "dalch1"
})
public class DETAILXrech {

    @XmlElement(name = "DOCUMENTID", required = true)
    protected String documentid;
    @XmlElement(name = "LINENUMBER", required = true)
    protected String linenumber;
    @XmlElement(name = "SUBLINENUMBER")
    protected String sublinenumber;
    @XmlElement(name = "ACTIONREQUEST")
    protected String actionrequest;
    @XmlElement(name = "DPRIN1", required = true)
    protected List<DPRIN1> dprin1;
    @XmlElement(name = "DPRDE1", required = true)
    protected List<DPRDE1> dprde1;
    @XmlElement(name = "DQUAN1", required = true)
    protected List<DQUAN1> dquan1;
    @XmlElement(name = "DAMOU1", required = true)
    protected List<DAMOU1> damou1;
    @XmlElement(name = "DTEXT1")
    protected DTEXT1 dtext1;
    @XmlElement(name = "DPRIC1", required = true)
    protected List<DPRIC1> dpric1;
    @XmlElement(name = "DREFE1")
    protected List<DREFE1> drefe1;
    @XmlElement(name = "DTAXI1")
    protected DTAXI1 dtaxi1;
    @XmlElement(name = "DALCH1")
    protected List<DALCH1> dalch1;

    /**
     * Gets the value of the documentid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCUMENTID() {
        return documentid;
    }

    /**
     * Sets the value of the documentid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCUMENTID(String value) {
        this.documentid = value;
    }

    /**
     * Gets the value of the linenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINENUMBER() {
        return linenumber;
    }

    /**
     * Sets the value of the linenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINENUMBER(String value) {
        this.linenumber = value;
    }

    /**
     * Gets the value of the sublinenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSUBLINENUMBER() {
        return sublinenumber;
    }

    /**
     * Sets the value of the sublinenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSUBLINENUMBER(String value) {
        this.sublinenumber = value;
    }

    /**
     * Gets the value of the actionrequest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIONREQUEST() {
        return actionrequest;
    }

    /**
     * Sets the value of the actionrequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIONREQUEST(String value) {
        this.actionrequest = value;
    }

    /**
     * Gets the value of the dprin1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dprin1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPRIN1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DPRIN1 }
     * 
     * 
     */
    public List<DPRIN1> getDPRIN1() {
        if (dprin1 == null) {
            dprin1 = new ArrayList<DPRIN1>();
        }
        return this.dprin1;
    }

    /**
     * Gets the value of the dprde1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dprde1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPRDE1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DPRDE1 }
     * 
     * 
     */
    public List<DPRDE1> getDPRDE1() {
        if (dprde1 == null) {
            dprde1 = new ArrayList<DPRDE1>();
        }
        return this.dprde1;
    }

    /**
     * Gets the value of the dquan1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dquan1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDQUAN1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DQUAN1 }
     * 
     * 
     */
    public List<DQUAN1> getDQUAN1() {
        if (dquan1 == null) {
            dquan1 = new ArrayList<DQUAN1>();
        }
        return this.dquan1;
    }

    /**
     * Gets the value of the damou1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the damou1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDAMOU1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DAMOU1 }
     * 
     * 
     */
    public List<DAMOU1> getDAMOU1() {
        if (damou1 == null) {
            damou1 = new ArrayList<DAMOU1>();
        }
        return this.damou1;
    }

    /**
     * Gets the value of the dtext1 property.
     * 
     * @return
     *     possible object is
     *     {@link DTEXT1 }
     *     
     */
    public DTEXT1 getDTEXT1() {
        return dtext1;
    }

    /**
     * Sets the value of the dtext1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link DTEXT1 }
     *     
     */
    public void setDTEXT1(DTEXT1 value) {
        this.dtext1 = value;
    }

    /**
     * Gets the value of the dpric1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dpric1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDPRIC1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DPRIC1 }
     * 
     * 
     */
    public List<DPRIC1> getDPRIC1() {
        if (dpric1 == null) {
            dpric1 = new ArrayList<DPRIC1>();
        }
        return this.dpric1;
    }

    /**
     * Gets the value of the drefe1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drefe1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDREFE1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DREFE1 }
     * 
     * 
     */
    public List<DREFE1> getDREFE1() {
        if (drefe1 == null) {
            drefe1 = new ArrayList<DREFE1>();
        }
        return this.drefe1;
    }

    /**
     * Gets the value of the dtaxi1 property.
     * 
     * @return
     *     possible object is
     *     {@link DTAXI1 }
     *     
     */
    public DTAXI1 getDTAXI1() {
        return dtaxi1;
    }

    /**
     * Sets the value of the dtaxi1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link DTAXI1 }
     *     
     */
    public void setDTAXI1(DTAXI1 value) {
        this.dtaxi1 = value;
    }

    /**
     * Gets the value of the dalch1 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dalch1 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDALCH1().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DALCH1 }
     * 
     * 
     */
    public List<DALCH1> getDALCH1() {
        if (dalch1 == null) {
            dalch1 = new ArrayList<DALCH1>();
        }
        return this.dalch1;
    }

}
