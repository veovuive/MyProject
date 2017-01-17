package com.example.windows10timt.myweather.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Windows 10 TIMT on 12/13/2016.
 */

public class Results {
    @SerializedName("channel")
    @Expose
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
