package com.example.windows10timt.myweather;

import com.example.windows10timt.myweather.data.Data;
import com.example.windows10timt.myweather.data2.City;
import com.example.windows10timt.myweather.data2.Example;
import com.example.windows10timt.myweather.data2.PostApi;
import com.squareup.okhttp.ResponseBody;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Windows 10 TIMT on 12/16/2016.
 */

public interface UserService {
    @GET("public/yql")
    Call<Data> getTask(@Query("q") String q ,@Query("format") String format);


}
