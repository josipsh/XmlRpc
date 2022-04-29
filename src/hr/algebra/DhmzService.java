package hr.algebra;

import hr.algebra.model.CityDto;
import hr.algebra.model.CountryCroatiaDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Objects;

public class DhmzService {

    public QueryResult fetchNewestDataFotCity(String city) {

        try {
            CountryCroatiaDto data = doRequest();
            return getCityFromData(data, city);
        } catch (Exception exception) {
            return new QueryResult();
        }
    }

    private QueryResult getCityFromData(CountryCroatiaDto data, String city) {
        QueryResult result = new QueryResult();
        result.setDate(data.Date.Date);

        List<CityDto> cities = data.City;

        for (CityDto item : cities) {
            if (Objects.equals(item.cityName, city)) {
                result.setTemp(item.Data.Temp);
                result.setHumidity(item.Data.humidity);
                result.setPressure(item.Data.pressure);
                result.setWindSpeed(item.Data.windSpeed);
                result.setWeather(item.Data.weather);
                result.setCountryName("Croatia");
                result.setCityName(item.cityName);
                result.setErrorMessage("");

                return result;
            }
        }

        result.setWeather("");
        result.setCountryName("");
        result.setCityName("");
        result.setErrorMessage("This city does not exist");

        return result;
    }

    private CountryCroatiaDto doRequest() throws IOException, JAXBException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://vrijeme.hr/hrvatska_n.xml")
                .get()
                .build();

        Response response = client.newCall(request).execute();

        JAXBContext jaxbContext = JAXBContext.newInstance(CountryCroatiaDto.class);
        StringReader reader = new StringReader(response.body().string());

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (CountryCroatiaDto) unmarshaller.unmarshal(reader);
    }
}
