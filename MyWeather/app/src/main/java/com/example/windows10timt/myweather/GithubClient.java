package com.example.windows10timt.myweather;

import com.example.windows10timt.myweather.data2.City;
import com.example.windows10timt.myweather.data2.Example;
import com.example.windows10timt.myweather.data2.PostApi;
import com.google.gson.annotations.Expose;
import com.squareup.okhttp.ResponseBody;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Windows 10 TIMT on 12/15/2016.
 */

public interface GithubClient {

    @GET("forecast/daily")
    Call<Example> getUser(@Query("lat") double lat , @Query("lon") double lon , @Query("cnt") int cnt , @Query("appid") String appid);


}
