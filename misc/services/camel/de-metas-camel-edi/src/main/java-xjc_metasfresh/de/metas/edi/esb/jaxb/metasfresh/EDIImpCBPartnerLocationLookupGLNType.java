//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.03.15 at 05:39:15 PM CET 
//


package de.metas.edi.esb.jaxb.metasfresh;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EDI_Imp_C_BPartner_Location_Lookup_GLNType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EDI_Imp_C_BPartner_Location_Lookup_GLNType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="C_BPartner_ID" type="{}EDI_C_BPartner_Lookup_BPL_GLN_vType" minOccurs="0"/&gt;
 *         &lt;element name="GLN" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EDI_Imp_C_BPartner_Location_Lookup_GLNType", propOrder = {
    "cbPartnerID",
    "gln"
})
public class EDIImpCBPartnerLocationLookupGLNType {

    @XmlElement(name = "C_BPartner_ID")
    protected EDICBPartnerLookupBPLGLNVType cbPartnerID;
    @XmlElement(name = "GLN", required = true)
    protected String gln;

    /**
     * Gets the value of the cbPartnerID property.
     * 
     * @return
     *     possible object is
     *     {@link EDICBPartnerLookupBPLGLNVType }
     *     
     */
    public EDICBPartnerLookupBPLGLNVType getCBPartnerID() {
        return cbPartnerID;
    }

    /**
     * Sets the value of the cbPartnerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDICBPartnerLookupBPLGLNVType }
     *     
     */
    public void setCBPartnerID(EDICBPartnerLookupBPLGLNVType value) {
        this.cbPartnerID = value;
    }

    /**
     * Gets the value of the gln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGLN() {
        return gln;
    }

    /**
     * Sets the value of the gln property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGLN(String value) {
        this.gln = value;
    }

}
