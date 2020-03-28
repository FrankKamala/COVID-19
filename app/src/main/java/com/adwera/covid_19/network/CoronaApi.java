package com.adwera.covid_19.network;

import com.adwera.covid_19.models.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface CoronaApi {

    //returns all countries affected
    @GET("countries")
    Call<List<Country>> allCountriesAffected();

}
