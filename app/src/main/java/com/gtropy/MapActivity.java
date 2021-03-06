package com.gtropy;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap map;
    Double lati;
    Double longi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment=(SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap gmap){
        this.map=gmap;
        Intent inten=getIntent();
        lati=inten.getDoubleExtra("lattitude",0.0);
        longi=inten.getDoubleExtra("longitude",0.0);
        String title=inten.getStringExtra("title");
        LatLng abc= new LatLng(lati,longi);
        map.addMarker(new MarkerOptions().position(abc).title(title));
        map.moveCamera(CameraUpdateFactory.newLatLng(abc));
    }
}
