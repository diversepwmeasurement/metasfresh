//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:19:20 PM CET 
//


package at.erpel.schemas._1p0.documents.ext;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryDetailsExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryDetailsExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/extensions/edifact}DeliveryDetailsExtension"/&gt;
 *         &lt;element ref="{http://erpel.at/schemas/1p0/documents/ext}ErpelDeliveryDetailsExtension"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryDetailsExtensionType", propOrder = {
    "deliveryDetailsExtension",
    "erpelDeliveryDetailsExtension"
})
public class DeliveryDetailsExtensionType {

    @XmlElement(name = "DeliveryDetailsExtension", namespace = "http://erpel.at/schemas/1p0/documents/extensions/edifact")
    protected at.erpel.schemas._1p0.documents.extensions.edifact.DeliveryDetailsExtensionType deliveryDetailsExtension;
    @XmlElement(name = "ErpelDeliveryDetailsExtension")
    protected CustomType erpelDeliveryDetailsExtension;

    /**
     * Gets the value of the deliveryDetailsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link at.erpel.schemas._1p0.documents.extensions.edifact.DeliveryDetailsExtensionType }
     *     
     */
    public at.erpel.schemas._1p0.documents.extensions.edifact.DeliveryDetailsExtensionType getDeliveryDetailsExtension() {
        return deliveryDetailsExtension;
    }

    /**
     * Sets the value of the deliveryDetailsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link at.erpel.schemas._1p0.documents.extensions.edifact.DeliveryDetailsExtensionType }
     *     
     */
    public void setDeliveryDetailsExtension(at.erpel.schemas._1p0.documents.extensions.edifact.DeliveryDetailsExtensionType value) {
        this.deliveryDetailsExtension = value;
    }

    /**
     * Gets the value of the erpelDeliveryDetailsExtension property.
     * 
     * @return
     *     possible object is
     *     {@link CustomType }
     *     
     */
    public CustomType getErpelDeliveryDetailsExtension() {
        return erpelDeliveryDetailsExtension;
    }

    /**
     * Sets the value of the erpelDeliveryDetailsExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomType }
     *     
     */
    public void setErpelDeliveryDetailsExtension(CustomType value) {
        this.erpelDeliveryDetailsExtension = value;
    }

}
