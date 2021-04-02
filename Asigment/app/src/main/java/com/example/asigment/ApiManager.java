package com.example.asigment;

import com.example.asigment.model.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiManager {
    String SERVER = "http://dataservice.accuweather.com/";

    @GET("data.json")
    Call<Weather> getData();

    @GET("datas.json")
    Call<List<Weather>> getDatas();

    @GET("/forecasts/v1/hourly/12hour/353412?apikey=mpIVteKTZvIl1gysRuTIGn8EBQgEp4II&language=vi-vn&metric=true")
    Call<List<Weather>>getWeather();

}
