
package com.adwera.covid_19.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountryInfo implements Serializable
{

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("long")
    @Expose
    private Double _long;
    @SerializedName("flag")
    @Expose
    private String flag;
    @SerializedName("iso3")
    @Expose
    private String iso3;
    @SerializedName("iso2")
    @Expose
    private String iso2;
    private final static long serialVersionUID = 1634189142471447147L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CountryInfo() {
    }

    /**
     * 
     * @param flag
     * @param _long
     * @param id
     * @param iso2
     * @param lat
     * @param iso3
     */
    public CountryInfo(Integer id, Double lat, Double _long, String flag, String iso3, String iso2) {
        super();
        this.id = id;
        this.lat = lat;
        this._long = _long;
        this.flag = flag;
        this.iso3 = iso3;
        this.iso2 = iso2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLong() {
        return _long;
    }

    public void setLong(Double _long) {
        this._long = _long;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

}
