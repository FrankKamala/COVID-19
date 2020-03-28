
package com.adwera.covid_19.models.news;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsSearchResponse implements Serializable
{

    @SerializedName("request_info")
    @Expose
    private RequestInfo requestInfo;
    @SerializedName("request_metadata")
    @Expose
    private RequestMetadata requestMetadata;
    @SerializedName("request_parameters")
    @Expose
    private RequestParameters requestParameters;
    @SerializedName("articles")
    @Expose
    private List<Article> articles = null;
    private final static long serialVersionUID = -5626534868722380129L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public NewsSearchResponse() {
    }

    /**
     * 
     * @param requestMetadata
     * @param requestParameters
     * @param requestInfo
     * @param articles
     */
    public NewsSearchResponse(RequestInfo requestInfo, RequestMetadata requestMetadata, RequestParameters requestParameters, List<Article> articles) {
        super();
        this.requestInfo = requestInfo;
        this.requestMetadata = requestMetadata;
        this.requestParameters = requestParameters;
        this.articles = articles;
    }

    public RequestInfo getRequestInfo() {
        return requestInfo;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.requestInfo = requestInfo;
    }

    public RequestMetadata getRequestMetadata() {
        return requestMetadata;
    }

    public void setRequestMetadata(RequestMetadata requestMetadata) {
        this.requestMetadata = requestMetadata;
    }

    public RequestParameters getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        this.requestParameters = requestParameters;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}
