package com.example.windows10timt.myweather;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Settings extends AppCompatActivity {
    private ImageView arrow;
    private ToggleButton mTogg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        arrow = (ImageView) findViewById(R.id.arrow);
        mTogg = (ToggleButton) findViewById(R.id.mTogg);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext().getApplicationContext());
        boolean check = preferences.getBoolean("check", true);
        if (check == true){
            mTogg.setChecked(true);
        }else if (check == false){
            mTogg.setChecked(false);
        }


        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTogg.isChecked() == true) {
                    mTogg.setChecked(true);
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("check", true);
                    editor.commit();
                    finish();

                }
                if (mTogg.isChecked() == false) {
                    mTogg.setChecked(false);
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putBoolean("check", false);
                    editor.commit();
                    finish();
                }


            }
        });

    }
}
