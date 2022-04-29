package hr.algebra.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatumTermin")
public class DateDataDto {
    @XmlElement(name = "Datum")
    public String Date;

    @XmlElement(name = "Termin")
    public int appointment;
}
