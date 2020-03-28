
package com.adwera.covid_19.models.news;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Source implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("domain")
    @Expose
    private String domain;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("locales")
    @Expose
    private List<String> locales = null;
    @SerializedName("description")
    @Expose
    private String description;
    private final static long serialVersionUID = -6378386420434322319L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Source() {
    }

    /**
     * 
     * @param locales
     * @param domain
     * @param name
     * @param logo
     * @param description
     * @param id
     */
    public Source(String id, String domain, String name, String logo, List<String> locales, String description) {
        super();
        this.id = id;
        this.domain = domain;
        this.name = name;
        this.logo = logo;
        this.locales = locales;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<String> getLocales() {
        return locales;
    }

    public void setLocales(List<String> locales) {
        this.locales = locales;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
