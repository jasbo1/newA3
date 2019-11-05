package com.android3.data.network;

import com.android3.data.entity.weather.CurrentWeatherEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

@GET(ApiEndpoint.CURRENT_WEATHER)
    Call<CurrentWeatherEntity> getCurrentWeather(@Query("q") String city , @Query("appid") String appId );

   @GET(ApiEndpoint.WEATHER_FOR_16_DAYS)
    Call<CurrentWeatherEntity> getWeather(@Query("q") String city , @Query("appid") String appId );
}