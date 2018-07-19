package com.cykj.service.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yangsq
 * @date 2018/7/19 15:25.
 */
@Entity
@Table(name = "weather_prediction", schema = "css", catalog = "")
public class WeatherPrediction implements Serializable {
    private int idweatherPrediction;
    private String city;
    private String crawlingTime;
    private String prediction7D;
    private String prediction3HTemp;
    private String prediction3HWater;
    private String prediction3HWind;
    private String prediction3HWindDirection;
    private String prediction3HPressure;
    private String prediction3HHumity;
    private String prediction3HCloud;
    private String prediction3HTimeList;

    @Id
    @Column(name = "idweather_prediction")
    public int getIdweatherPrediction() {
        return idweatherPrediction;
    }

    public void setIdweatherPrediction(int idweatherPrediction) {
        this.idweatherPrediction = idweatherPrediction;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "crawling_time")
    public String getCrawlingTime() {
        return crawlingTime;
    }

    public void setCrawlingTime(String crawlingTime) {
        this.crawlingTime = crawlingTime;
    }

    @Basic
    @Column(name = "prediction_7d")
    public String getPrediction7D() {
        return prediction7D;
    }

    public void setPrediction7D(String prediction7D) {
        this.prediction7D = prediction7D;
    }

    @Basic
    @Column(name = "prediction_3h_temp")
    public String getPrediction3HTemp() {
        return prediction3HTemp;
    }

    public void setPrediction3HTemp(String prediction3HTemp) {
        this.prediction3HTemp = prediction3HTemp;
    }

    @Basic
    @Column(name = "prediction_3h_water")
    public String getPrediction3HWater() {
        return prediction3HWater;
    }

    public void setPrediction3HWater(String prediction3HWater) {
        this.prediction3HWater = prediction3HWater;
    }

    @Basic
    @Column(name = "prediction_3h_wind")
    public String getPrediction3HWind() {
        return prediction3HWind;
    }

    public void setPrediction3HWind(String prediction3HWind) {
        this.prediction3HWind = prediction3HWind;
    }

    @Basic
    @Column(name = "prediction_3h_wind_direction")
    public String getPrediction3HWindDirection() {
        return prediction3HWindDirection;
    }

    public void setPrediction3HWindDirection(String prediction3HWindDirection) {
        this.prediction3HWindDirection = prediction3HWindDirection;
    }

    @Basic
    @Column(name = "prediction_3h_pressure")
    public String getPrediction3HPressure() {
        return prediction3HPressure;
    }

    public void setPrediction3HPressure(String prediction3HPressure) {
        this.prediction3HPressure = prediction3HPressure;
    }

    @Basic
    @Column(name = "prediction_3h_humity")
    public String getPrediction3HHumity() {
        return prediction3HHumity;
    }

    public void setPrediction3HHumity(String prediction3HHumity) {
        this.prediction3HHumity = prediction3HHumity;
    }

    @Basic
    @Column(name = "prediction_3h_cloud")
    public String getPrediction3HCloud() {
        return prediction3HCloud;
    }

    public void setPrediction3HCloud(String prediction3HCloud) {
        this.prediction3HCloud = prediction3HCloud;
    }

    @Basic
    @Column(name = "prediction_3h_time_list")
    public String getPrediction3HTimeList() {
        return prediction3HTimeList;
    }

    public void setPrediction3HTimeList(String prediction3HTimeList) {
        this.prediction3HTimeList = prediction3HTimeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherPrediction that = (WeatherPrediction) o;

        if (idweatherPrediction != that.idweatherPrediction) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (crawlingTime != null ? !crawlingTime.equals(that.crawlingTime) : that.crawlingTime != null) return false;
        if (prediction7D != null ? !prediction7D.equals(that.prediction7D) : that.prediction7D != null) return false;
        if (prediction3HTemp != null ? !prediction3HTemp.equals(that.prediction3HTemp) : that.prediction3HTemp != null)
            return false;
        if (prediction3HWater != null ? !prediction3HWater.equals(that.prediction3HWater) : that.prediction3HWater != null)
            return false;
        if (prediction3HWind != null ? !prediction3HWind.equals(that.prediction3HWind) : that.prediction3HWind != null)
            return false;
        if (prediction3HWindDirection != null ? !prediction3HWindDirection.equals(that.prediction3HWindDirection) : that.prediction3HWindDirection != null)
            return false;
        if (prediction3HPressure != null ? !prediction3HPressure.equals(that.prediction3HPressure) : that.prediction3HPressure != null)
            return false;
        if (prediction3HHumity != null ? !prediction3HHumity.equals(that.prediction3HHumity) : that.prediction3HHumity != null)
            return false;
        if (prediction3HCloud != null ? !prediction3HCloud.equals(that.prediction3HCloud) : that.prediction3HCloud != null)
            return false;
        if (prediction3HTimeList != null ? !prediction3HTimeList.equals(that.prediction3HTimeList) : that.prediction3HTimeList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idweatherPrediction;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (crawlingTime != null ? crawlingTime.hashCode() : 0);
        result = 31 * result + (prediction7D != null ? prediction7D.hashCode() : 0);
        result = 31 * result + (prediction3HTemp != null ? prediction3HTemp.hashCode() : 0);
        result = 31 * result + (prediction3HWater != null ? prediction3HWater.hashCode() : 0);
        result = 31 * result + (prediction3HWind != null ? prediction3HWind.hashCode() : 0);
        result = 31 * result + (prediction3HWindDirection != null ? prediction3HWindDirection.hashCode() : 0);
        result = 31 * result + (prediction3HPressure != null ? prediction3HPressure.hashCode() : 0);
        result = 31 * result + (prediction3HHumity != null ? prediction3HHumity.hashCode() : 0);
        result = 31 * result + (prediction3HCloud != null ? prediction3HCloud.hashCode() : 0);
        result = 31 * result + (prediction3HTimeList != null ? prediction3HTimeList.hashCode() : 0);
        return result;
    }
}
