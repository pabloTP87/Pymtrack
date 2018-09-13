package com.example.pablo.pymtrack;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SuchiMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suchi_maps);
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

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        LatLng suchiZone = new LatLng(-53.137387, -70.890430);
        mMap.addMarker(new MarkerOptions().position(suchiZone).title("Sushi zone"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(suchiZone));

        LatLng masterChina = new LatLng(-53.137798, -70.889378);
        mMap.addMarker(new MarkerOptions().position(masterChina).title("Master china"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(masterChina));

        LatLng sushiTrump = new LatLng(-53.142052, -70.890462);
        mMap.addMarker(new MarkerOptions().position(sushiTrump).title("Sushi delicias"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sushiTrump));
    }
}
