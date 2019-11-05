package com.android3.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.android3.BuildConfig.WEATHER_BASE_URL;

public class RetrofitBuilder {
    private static RetrofitService instance;
    private static  OkHttpClient client;



    public static RetrofitService getInstance(){
        if( instance == null)
            instance = buildRetrofit();

        return instance;
    }

    private  static  RetrofitService buildRetrofit(){
       return new Retrofit.Builder()
                .baseUrl(WEATHER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
               .client(getClient())
                .build()
                .create(RetrofitService.class);
    }

    private static OkHttpClient getClient(){
        if( client == null)
            client = okhttpBuilder();

        return client;
    }


    private static OkHttpClient okhttpBuilder(){
        return new OkHttpClient.Builder()
                .connectTimeout(10,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

    }
}
