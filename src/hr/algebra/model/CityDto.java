package hr.algebra.model;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Grad")
public class CityDto {

    @XmlAttribute(name = "autom")
    public int atribute;

    @XmlElement(name = "Podatci")
    public DataDto Data;

    @XmlElement(name = "GradIme")
    public String cityName;

    @XmlElement(name = "Lat")
    public double latitude;

    @XmlElement(name = "Lon")
    public double longitude;
}
