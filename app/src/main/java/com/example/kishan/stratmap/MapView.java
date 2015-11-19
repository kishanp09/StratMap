package com.example.kishan.stratmap;

import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapView extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient):
        // Add a marker in Sydney and move the camera
        LatLng mylocation = new LatLng(42.2932850, -83.7138350);
        mMap.addMarker(new MarkerOptions().position(mylocation).title("Hazard").snippet("Potholes").draggable(true));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylocation));
        mMap.setMyLocationEnabled(true);
        mMap.addMarker(new MarkerOptions()
                .position(mylocation)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).draggable(true).title("Hazard").snippet("Traffic"));

        mMap.addMarker(new MarkerOptions()
                .position(mylocation)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).draggable(true).title("Hazard").snippet("Debris"));


    }

    public void PotholesPress(View view) {

        LatLng location = new LatLng(50,50);
        mMap.addMarker(new MarkerOptions().position(location).title("Hazard").snippet("Potholes").draggable(true));




    }

    public void TrafficPress(View view){

        LatLng location = new LatLng(42,-90);
        mMap.addMarker(new MarkerOptions()
                .position(location)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).draggable(true).title("Hazard").snippet("Traffic"));


    }

    public void DebrisPress(View view){
        mMap.setMyLocationEnabled(true);
        LatLng location = new LatLng(52,150);
        mMap.addMarker(new MarkerOptions()
                .position(location)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)).draggable(true).title("Hazard").snippet("Debris"));



    }
}