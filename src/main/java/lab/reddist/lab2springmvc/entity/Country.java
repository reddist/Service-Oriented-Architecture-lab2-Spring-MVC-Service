package lab.reddist.lab2springmvc.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum Country {
    @XmlEnumValue("india") INDIA,
    @XmlEnumValue("vatican") VATICAN,
    @XmlEnumValue("thailand") THAILAND,
    @XmlEnumValue("north_korea") NORTH_KOREA,
    @XmlEnumValue("japan") JAPAN
}

