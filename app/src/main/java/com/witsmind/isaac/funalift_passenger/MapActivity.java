package com.witsmind.isaac.funalift_passenger;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
       private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MarkerOptions destination_marker= new MarkerOptions().position(new LatLng(0.293610,32.609270));
        destination_marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.pickup));

        MarkerOptions pick_up_marker =new MarkerOptions().position(new LatLng(0.315770,32.575859));
        pick_up_marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.dropoff));

        mMap=googleMap;
       // LatLng initial_pointer =new LatLng(0.347596, 32.582520);
        mMap.addMarker(destination_marker);
        mMap.addMarker(pick_up_marker);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(destination_marker.getPosition(),15));

    }
}
