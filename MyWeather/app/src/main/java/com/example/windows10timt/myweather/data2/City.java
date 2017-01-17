package com.example.windows10timt.myweather.data2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Windows 10 TIMT on 12/15/2016.
 */

public class City {
    @SerializedName("name")
    private String name;
    @SerializedName("country")
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
