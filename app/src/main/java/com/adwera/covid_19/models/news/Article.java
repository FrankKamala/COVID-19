
package com.adwera.covid_19.models.news;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article implements Serializable
{

    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("primary_author")
    @Expose
    private String primaryAuthor;
    @SerializedName("authors")
    @Expose
    private List<String> authors = null;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("primary_image_link")
    @Expose
    private String primaryImageLink;
    @SerializedName("image_links")
    @Expose
    private List<String> imageLinks = null;
    @SerializedName("date_published")
    @Expose
    private String datePublished;
    @SerializedName("source")
    @Expose
    private Source source;
    private final static long serialVersionUID = 7859847385663314212L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Article() {
    }

    /**
     * 
     * @param snippet
     * @param datePublished
     * @param primaryAuthor
     * @param link
     * @param source
     * @param title
     * @param imageLinks
     * @param authors
     * @param primaryImageLink
     */
    public Article(String link, String title, String primaryAuthor, List<String> authors, String snippet, String primaryImageLink, List<String> imageLinks, String datePublished, Source source) {
        super();
        this.link = link;
        this.title = title;
        this.primaryAuthor = primaryAuthor;
        this.authors = authors;
        this.snippet = snippet;
        this.primaryImageLink = primaryImageLink;
        this.imageLinks = imageLinks;
        this.datePublished = datePublished;
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrimaryAuthor() {
        return primaryAuthor;
    }

    public void setPrimaryAuthor(String primaryAuthor) {
        this.primaryAuthor = primaryAuthor;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    public String getPrimaryImageLink() {
        return primaryImageLink;
    }

    public void setPrimaryImageLink(String primaryImageLink) {
        this.primaryImageLink = primaryImageLink;
    }

    public List<String> getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(List<String> imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

}
