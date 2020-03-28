
package com.adwera.covid_19.models.news;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestMetadata implements Serializable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("processed_at")
    @Expose
    private String processedAt;
    @SerializedName("total_time_taken")
    @Expose
    private Double totalTimeTaken;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("profile")
    @Expose
    private String profile;
    private final static long serialVersionUID = -7806379981149351371L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RequestMetadata() {
    }

    /**
     * 
     * @param createdAt
     * @param totalResults
     * @param profile
     * @param processedAt
     * @param totalTimeTaken
     * @param id
     */
    public RequestMetadata(String id, String createdAt, String processedAt, Double totalTimeTaken, Integer totalResults, String profile) {
        super();
        this.id = id;
        this.createdAt = createdAt;
        this.processedAt = processedAt;
        this.totalTimeTaken = totalTimeTaken;
        this.totalResults = totalResults;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(String processedAt) {
        this.processedAt = processedAt;
    }

    public Double getTotalTimeTaken() {
        return totalTimeTaken;
    }

    public void setTotalTimeTaken(Double totalTimeTaken) {
        this.totalTimeTaken = totalTimeTaken;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

}
