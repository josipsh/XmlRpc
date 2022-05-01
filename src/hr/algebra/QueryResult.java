package hr.algebra;

import com.sun.org.apache.bcel.internal.classfile.ConstantString;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.sql.ResultSet;

public class QueryResult implements Externalizable {
    public static final long serialVersionUID = 1L;

    private String date;
    private double temp;
    private double humidity;
    private double pressure;
    private double windSpeed;
    private String weather;
    private String cityName;
    private String countryName;
    private String errorMessage;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public QueryResult() {
    }

    public QueryResult(String date, double temp, double humidity, double pressure, double windSpeed, String weather, String cityName, String countryName, String errorMessage) {
        this.date = date;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.weather = weather;
        this.cityName = cityName;
        this.countryName = countryName;
        this.errorMessage = errorMessage;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(cityName);
        out.writeUTF(countryName);
        out.writeUTF(date);
        out.writeDouble(temp);
        out.writeDouble(humidity);
        out.writeDouble(pressure);
        out.writeDouble(windSpeed);
        out.writeUTF(weather);
        out.writeUTF(errorMessage);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
        cityName = in.readUTF();
        countryName = in.readUTF();
        date = in.readUTF();
        temp = in.readDouble();
        humidity = in.readDouble();
        pressure = in.readDouble();
        windSpeed = in.readDouble();
        weather = in.readUTF();
        errorMessage = in.readUTF();
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "date='" + date + '\'' +
                ", temp=" + temp +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", weather='" + weather + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }

    public String toJson() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        sb.append("\"temp\": \""+ temp + "\",");
        sb.append("\"humidity\": \""+ humidity + "\",");
        sb.append("\"windSpeed\": \""+ windSpeed + "\",");
        sb.append("\"pressure\": \""+ pressure + "\",");
        sb.append("\"weather\": \""+ weather + "\",");
        sb.append("\"date\": \""+ date + "\",");
        sb.append("\"cityName\": \""+ cityName + "\",");
        sb.append("\"countryName\": \""+ countryName + "\",");
        sb.append("\"errorMessage\": \""+ errorMessage+"\"");
        sb.append("}");

        return sb.toString();
    }
}