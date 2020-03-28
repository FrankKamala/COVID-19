package com.adwera.covid_19.network.news;

import com.adwera.covid_19.models.news.CoronaNews;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsApi {
    @GET("news")
    Call<List<CoronaNews>> getnewsAll();

}
