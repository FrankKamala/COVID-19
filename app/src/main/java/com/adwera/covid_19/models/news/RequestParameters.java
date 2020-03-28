
package com.adwera.covid_19.models.news;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestParameters implements Serializable
{

    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("type")
    @Expose
    private String type;
    private final static long serialVersionUID = -628629020183263949L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestParameters() {
    }

    /**
     * 
     * @param q
     * @param locale
     * @param type
     */
    public RequestParameters(String locale, String q, String type) {
        super();
        this.locale = locale;
        this.q = q;
        this.type = type;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
