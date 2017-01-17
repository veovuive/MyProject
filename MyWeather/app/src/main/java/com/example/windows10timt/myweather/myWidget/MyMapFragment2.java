package com.example.windows10timt.myweather.myWidget;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windows10timt.myweather.R;
import com.example.windows10timt.myweather.data.Item;
import com.example.windows10timt.myweather.data.Location;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Windows 10 TIMT on 1/11/2017.
 */

public class MyMapFragment2 extends Fragment {
    public Item item;
    public Location location;

    public static MyMapFragment2 newInstance(Item item, Location location) {
        MyMapFragment2 myFrag = new MyMapFragment2();
        myFrag.item = item;
        myFrag.location = location;
        return myFrag;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mMaps);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                double lat = Double.valueOf(item.getLat());
                double lon = Double.valueOf(item.getLon());
                LatLng here = new LatLng(lat, lon);
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(here, 7);
                googleMap.addMarker(new MarkerOptions().position(here).title(location.getCity()));
                googleMap.moveCamera(cameraUpdate);
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                googleMap.setMyLocationEnabled(true);

            }
        });
        return view;
    }

}
