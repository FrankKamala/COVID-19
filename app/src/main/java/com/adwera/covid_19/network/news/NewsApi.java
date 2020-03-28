package com.adwera.covid_19.network.news;

import com.adwera.covid_19.Constants.Constants;
import com.adwera.covid_19.models.news.NewsSearchResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    String locale = Constants.Locale;
    //news?q=corona&type=headlines&locale=en-KE&output=json&page=1&api_key=391591438ADF4258A668756FC309BB54
    @GET("news")
    Call<NewsSearchResponse> getNews(
            @Query("q") String corona,
            @Query("type") String headlines,
            @Query("locale") String locale,
            @Query("output") String output,
             @Query("page") int page,
            @Query("api_key") String apiKey

    );

}
