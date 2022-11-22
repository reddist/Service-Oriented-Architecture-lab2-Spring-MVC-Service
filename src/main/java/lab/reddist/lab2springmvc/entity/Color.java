package lab.reddist.lab2springmvc.entity;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum
public enum Color {
    @XmlEnumValue("black") BLACK,
    @XmlEnumValue("blue") BLUE,
    @XmlEnumValue("yellow") YELLOW,
    @XmlEnumValue("brown") BROWN
}
