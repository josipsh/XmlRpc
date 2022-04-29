package hr.algebra.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Hrvatska")
public class CountryCroatiaDto {

    @XmlElement(name = "DatumTermin")
    public DateDataDto Date;

    @XmlElement(name = "Grad")
    public List<CityDto> City;
}
