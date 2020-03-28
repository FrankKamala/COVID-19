package com.adwera.covid_19.network;

import com.adwera.covid_19.models.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface CoronaApi {

    //returns all countries affected
    @GET("countries")
    Call<List<Country>> allCountriesAffected();
    @GET("countries/{country-name}")
    Call<Country> searchCountry(@Path("country-name") String country);

}
