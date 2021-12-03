package com.proyectofinal.localizacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class LocationManagerActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView localizacion;
    String loc = " ";
    Double lat = 0.0, longi = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_manager);
        localizacion = findViewById(R.id.textViewLatitud);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(LocationManagerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(LocationManagerActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 1, this);
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //if(lat!=location.getLatitude() || longi!=location.getLongitude()){

        try {
            OutputStreamWriter archivo1 = new OutputStreamWriter(openFileOutput("localizacion.txt", Activity.MODE_PRIVATE));

            archivo1.write("Latitud" + "\t\t\t" + "Longitud" + "\n");
            lat = location.getLatitude();
            longi = location.getLongitude();
            loc += String.valueOf(lat) + "\t" + String.valueOf(longi) + "\n";
            archivo1.write(loc);
            archivo1.flush();
            archivo1.close();

            localizacion.setText(loc);

        } catch (IOException e) {
        }
    }

    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {

    }

    @Override
    public void onFlushComplete(int requestCode) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}