//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.12 at 05:52:48 PM EET 
//


package at.erpel.schemas._1p0.documents.extensions.edifact;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ForecastExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForecastExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PlanningHorizion" type="{http://erpel.at/schemas/1p0/documents/extensions/edifact}ExtendedPeriodType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastExtensionType", propOrder = {
    "planningHorizion"
})
public class ForecastExtensionType {

    @XmlElement(name = "PlanningHorizion")
    protected ExtendedPeriodType planningHorizion;

    /**
     * Gets the value of the planningHorizion property.
     * 
     * @return
     *     possible object is
     *     {@link ExtendedPeriodType }
     *     
     */
    public ExtendedPeriodType getPlanningHorizion() {
        return planningHorizion;
    }

    /**
     * Sets the value of the planningHorizion property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtendedPeriodType }
     *     
     */
    public void setPlanningHorizion(ExtendedPeriodType value) {
        this.planningHorizion = value;
    }

}
