package com.example.windows10timt.myweather;

import android.content.Context;
import android.content.SharedPreferences;

import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;

import android.widget.TextView;

import com.example.windows10timt.myweather.data.AdapterLayout5;
import com.example.windows10timt.myweather.data.Astronomy;
import com.example.windows10timt.myweather.data.Atmosphere;
import com.example.windows10timt.myweather.data.Condition;
import com.example.windows10timt.myweather.data.ForecastAdapter;
import com.example.windows10timt.myweather.data.Item;
import com.example.windows10timt.myweather.data.ProductForecast;
import com.example.windows10timt.myweather.data.Wind;
import com.example.windows10timt.myweather.myWidget.MyMapFragment2;
import com.google.android.gms.maps.GoogleMap;


import java.util.ArrayList;


/**
 * Created by Windows 10 TIMT on 12/20/2016.
 */

public class AdapterMylist extends RecyclerView.Adapter<AdapterMylist.MyViewHolder> {

    private Condition conditions;
    private Atmosphere atmosphere;
    private Astronomy astronomy;
    private Wind wind;
    private ArrayList<ProductForecast> productForecasts;
    private Context context;
    private Item item;
    MainActivity mActivity;
    private com.example.windows10timt.myweather.data.Location location2;

    public AdapterMylist(Condition conditions, Atmosphere atmosphere, Astronomy astronomy, Wind wind, ArrayList<ProductForecast> productForecasts, Context context, Item item, MainActivity mActivity, com.example.windows10timt.myweather.data.Location location2 ) {
        this.conditions = conditions;
        this.atmosphere = atmosphere;
        this.astronomy = astronomy;
        this.wind = wind;
        this.productForecasts = productForecasts;
        this.context = context;
        this.item = item;
        this.mActivity = mActivity;
        this.location2 = location2;
    }

    public static final int LAYOUT_1 = 0;
    public static final int LAYOUT_2 = 1;
    public static final int LAYOUT_3 = 2;
    public static final int LAYOUT_4 = 3;
    public static final int LAYOUT_5 = 4;
    public static final int LAYOUT_6 = 5;
    public static final int LAYOUT_7 = 6;
    public static final int LAYOUT_8 = 7;
    public static final int LAYOUT_9 = 8;
    public static final int LAYOUT_10 = 9;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == LAYOUT_1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_3) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_layout, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_4) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_5) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout3, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_6) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_7) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.maps_layout, parent, false);

            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_8) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout2, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == LAYOUT_9) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout4, parent, false);
            return new MyViewHolder(view);
        } else {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_layout, parent, false);
            return new MyViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (getItemViewType(position) == LAYOUT_1) {

            ProductForecast item = productForecasts.get(0);
            ImageView mImageCloud = (ImageView) holder.itemView.findViewById(R.id.mImageCloud);
            TextView mTvTemp = (TextView) holder.itemView.findViewById(R.id.mTvTemp);
            TextView mTvDescription = (TextView) holder.itemView.findViewById(R.id.mTvDescription);
            TextView mHigh = (TextView) holder.itemView.findViewById(R.id.mHigh);
            TextView mLow = (TextView) holder.itemView.findViewById(R.id.mLow);
            TextView mWeatherDay = (TextView) holder.itemView.findViewById(R.id.mWeatherDay);
            String day = item.getDate();
            String temp = conditions.getTemp();
            String description = conditions.getText();
            String high = item.getHigh();
            String low = item.getLow();


            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mActivity.getApplicationContext());
            boolean check = preferences.getBoolean("check", true);

            if (check == true) {
                int temp2 = Integer.valueOf(String.format(temp));
                int high2 = Integer.valueOf(String.format(high));
                int low2 = Integer.valueOf(String.format(low));

                int newTemp = (int) Math.round((temp2 - 32) / 1.8);
                int newHigh = (int) Math.round((high2 - 32) / 1.8);
                int newLow = (int) Math.round((low2 - 32) / 1.8);

                String mTemp = String.valueOf(newTemp);
                String myHigh = String.valueOf(newHigh);
                String myLow = String.valueOf(newLow);
                mTvTemp.setText(mTemp + "°C");

                mHigh.setText("↥ " + myHigh + "°");
                mLow.setText("↧ " + myLow + "°");
            }
            if (check == false) {
                mTvTemp.setText(temp + "°F");
                mHigh.setText("↥" + high + "°");
                mLow.setText("↧" + low + "°");
            }

            mTvDescription.setText(description);
            description.replace(" ", "%20");
            mWeatherDay.setText(day);
            if (description.equals("Showers") || description.equals("Scattered Showers")) {
                mImageCloud.setImageResource(R.drawable.snow);
            } else if (description.equals("Breezy")) {
                mImageCloud.setImageResource(R.drawable.breezy);
            } else if (description.equals("Sunny") || description.equals("Mostly Sunny")) {
                mImageCloud.setImageResource(R.drawable.sunny);
            } else if (description.equals("Partly Cloudy") || description.equals("Cloudy") || description.equals("Mostly Cloudy") || description.equals("Mostly Clear")) {
                mImageCloud.setImageResource(R.drawable.cloud_much);
            } else if (description.equals("Rain") || description.equals("Heavy Rain")) {
                mImageCloud.setImageResource(R.drawable.rain);
            }
        }

        if (getItemViewType(position) == LAYOUT_2) {

        }
        if (getItemViewType(position) == LAYOUT_3) {

            RecyclerView listForecast = (RecyclerView) holder.itemView.findViewById(R.id.listForecast);
            listForecast.setHasFixedSize(true);
            ForecastAdapter adapterMylist = new ForecastAdapter(context, productForecasts);
            LinearLayoutManager manager = new LinearLayoutManager(context);

            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(listForecast.getContext(), manager.getOrientation());
            listForecast.addItemDecoration(dividerItemDecoration);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            listForecast.setLayoutManager(manager);
            listForecast.setAdapter(adapterMylist);

        }

        if (getItemViewType(position) == LAYOUT_4) {
            TextView mTitle = (TextView) holder.itemView.findViewById(R.id.mTitle);
            mTitle.setText("Details");
        }

        if (getItemViewType(position) == LAYOUT_5) {
            String description = conditions.getText();
            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.imageDetails);
            if (description.equals("Showers") || description.equals("Scattered Showers")) {
                imageView.setImageResource(R.drawable.snow);
            } else if (description.equals("Breezy")) {
                imageView.setImageResource(R.drawable.breezy);
            } else if (description.equals("Sunny") || description.equals("Mostly Sunny")) {
                imageView.setImageResource(R.drawable.sunny);
            } else if (description.equals("Partly Cloudy") || description.equals("Cloudy") || description.equals("Mostly Cloudy")) {
                imageView.setImageResource(R.drawable.cloud_much);
            } else if (description.equals("Rain")|| description.equals("Heavy Rain")) {
                imageView.setImageResource(R.drawable.rain);
            }

            RecyclerView layout = (RecyclerView) holder.itemView.findViewById(R.id.mLayout5);
            layout.setHasFixedSize(true);
            AdapterLayout5 adapterLayout5 = new AdapterLayout5(atmosphere, astronomy);
            LinearLayoutManager manager = new LinearLayoutManager(context);
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            layout.setLayoutManager(manager);
            layout.setAdapter(adapterLayout5);
        }
        if (getItemViewType(position) == LAYOUT_6) {
            TextView mTitle = (TextView) holder.itemView.findViewById(R.id.mTitle);
            mTitle.setText("Maps");
        }
        if (getItemViewType(position) == LAYOUT_7) {
//            String lat = item.getLat();
//            String lon = item.getLon();
//            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.mMaps);
//            Picasso.with(context).load("http://maps.google.com/maps/api/staticmap?center=" + lat + "," + lon + "&zoom=5&size=400x300&markers=color:red%7Clable:A%7C" + lat + "," + lon + "&maptype=roadmap&sensor=false").into(imageView);
            FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            MyMapFragment2 fragment = MyMapFragment2.newInstance(item,location2);
            ft.replace(R.id.framelayout,fragment);
            ft.commit();


        }
        if (getItemViewType(position) == LAYOUT_8) {
            TextView mTitle = (TextView) holder.itemView.findViewById(R.id.mTitle);
            mTitle.setText("Wind & Pressure");
        }
        if (getItemViewType(position) == LAYOUT_9) {
            TextView mSpeed = (TextView) holder.itemView.findViewById(R.id.mSpeed);
            TextView mPressure = (TextView) holder.itemView.findViewById(R.id.mPressure);
            ImageView mAnimation = (ImageView) holder.itemView.findViewById(R.id.mAnimation);

            Animation animation = AnimationUtils.loadAnimation(context, R.anim.clockwise);
            int mySpeed = Integer.valueOf(wind.getSpeed());
            if (mySpeed == 0){
                animation.setDuration(0);
            }else {
                animation.setDuration(20000/mySpeed);

            }

            mAnimation.startAnimation(animation);

            String speed = wind.getSpeed();
            String pressure = atmosphere.getPressure();
            mPressure.setText(pressure+" mBar");
            mSpeed.setText(speed+" km/h SE");
        }
//        if (getItemViewType(position) == LAYOUT_10) {
//            ImageView mYahoo = (ImageView) holder.itemView.findViewById(R.id.imageYahoo);
//            Picasso.with(context).load(image.getUrl()).into(mYahoo);
//        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return LAYOUT_1;
        }
        if (position == 1) {
            return LAYOUT_2;
        }
        if (position == 2) {
            return LAYOUT_3;
        }
        if (position == 3) {
            return LAYOUT_4;
        }
        if (position == 4) {
            return LAYOUT_5;
        }
        if (position == 5) {
            return LAYOUT_6;
        }
        if (position == 6) {
            return LAYOUT_7;
        }
        if (position == 7) {
            return LAYOUT_8;
        }
        if (position == 8) {
            return LAYOUT_9;
        }
        if (position == 9) {
            return LAYOUT_10;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 9;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }

    }
}
