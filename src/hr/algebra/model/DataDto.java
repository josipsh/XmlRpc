package hr.algebra.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Podatci")
public class DataDto {

    @XmlElement(name = "Temp")
    public double Temp;

    @XmlElement(name = "Vlaga")
    public double humidity;

    @XmlElement(name = "Tlak")
    public double pressure;

    @XmlElement(name = "TlakTend")
    public String pressureUnknown;

    @XmlElement(name = "VjetarSmjer")
    public String windOrijentation;

    @XmlElement(name = "VjetarBrzina")
    public double windSpeed;

    @XmlElement(name = "Vrijeme")
    public String weather;

    @XmlElement(name = "VrijemeZnak")
    public String weatherSymbol;
}
