
package com.adwera.covid_19.models.news;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestInfo implements Serializable
{

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("credits_used")
    @Expose
    private Integer creditsUsed;
    @SerializedName("credits_remaining")
    @Expose
    private Integer creditsRemaining;
    private final static long serialVersionUID = -8327409866517215051L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestInfo() {
    }

    /**
     * 
     * @param success
     * @param creditsUsed
     * @param creditsRemaining
     */
    public RequestInfo(Boolean success, Integer creditsUsed, Integer creditsRemaining) {
        super();
        this.success = success;
        this.creditsUsed = creditsUsed;
        this.creditsRemaining = creditsRemaining;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCreditsUsed() {
        return creditsUsed;
    }

    public void setCreditsUsed(Integer creditsUsed) {
        this.creditsUsed = creditsUsed;
    }

    public Integer getCreditsRemaining() {
        return creditsRemaining;
    }

    public void setCreditsRemaining(Integer creditsRemaining) {
        this.creditsRemaining = creditsRemaining;
    }

}
