package com.proyectofinal.localizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttonLocation;
    Button buttonFused;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttonLocation=findViewById(R.id.buttonLocation);
        //buttonFused=findViewById(R.id.buttonFused);
    }

    public void onLocationManager(View view){
        buttonLocation= (Button) view;
        Intent intent= new Intent(this,LocationManagerActivity.class);
        startActivity(intent);
    }

    public void onFusedLocation(View view){
        buttonFused = (Button) view;
        Intent intent= new Intent(this,FusedLocationActivity.class);
        startActivity(intent);
    }
}