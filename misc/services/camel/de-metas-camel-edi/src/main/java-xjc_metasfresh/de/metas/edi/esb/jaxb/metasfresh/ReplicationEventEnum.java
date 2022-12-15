//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.09 at 05:46:30 PM CET 
//


package de.metas.edi.esb.jaxb.metasfresh;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReplicationEventEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReplicationEventEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="3"/&gt;
 *     &lt;enumeration value="5"/&gt;
 *     &lt;enumeration value="9"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "ReplicationEventEnum")
@XmlEnum
public enum ReplicationEventEnum {

    @XmlEnumValue("3")
    BeforeDelete("3"),
    @XmlEnumValue("5")
    AfterChange("5"),
    @XmlEnumValue("9")
    BeforeDeleteReplication("9");
    private final String value;

    ReplicationEventEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReplicationEventEnum fromValue(String v) {
        for (ReplicationEventEnum c: ReplicationEventEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
