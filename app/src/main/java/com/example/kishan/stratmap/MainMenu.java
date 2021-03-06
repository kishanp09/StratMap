package com.example.kishan.stratmap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;
import com.google.android.gms.maps.model.LatLng;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this); //necessary for Firebase lib to run

        LatLng myLocation = new LatLng(60, 120);
        Firebase stratFirebase = new Firebase("https://crackling-heat-4003.firebaseio.com/"); //initialize new Firebase
        Firebase point = stratFirebase.child("Locations").child("newPoint");
        point.setValue(myLocation);

        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayInfo(View view) {
      Intent intent=new Intent(this,AboutPage.class);
        startActivity(intent);
    }


    public void mapView(View view) {

        Intent intent=new Intent(this,MapView.class);
        startActivity(intent);


    }

    public void KeyActivity(View view){

        Intent intent=new Intent(this, KeyActivity.class);
        startActivity(intent);

    }

    public void PotholesActivity(View view) {
        Intent intent=new Intent(this,PotholesActivity.class);
        startActivity(intent);
    }


}
