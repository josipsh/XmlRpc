package hr.algebra;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class QueryResult implements Externalizable {
    public static final long serialVersionUID = 1L;

    private String cityName;
    private String countryName;
    private String dateTime;
    private String errorMessage;

    public QueryResult() {
    }

    public QueryResult(String cityName, String countryName, String dateTime, String errorMessage) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.dateTime = dateTime;
        this.errorMessage = errorMessage;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getDateTime() {
        return dateTime;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(cityName);
        out.writeUTF(countryName);
        out.writeUTF(dateTime);
        out.writeUTF(errorMessage);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        cityName = in.readUTF();
        countryName = in.readUTF();
        dateTime = in.readUTF();
        errorMessage = in.readUTF();
    }
}