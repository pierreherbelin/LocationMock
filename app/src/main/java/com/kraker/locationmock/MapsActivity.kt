package com.kraker.locationmock

import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var location = Location("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val markerPosition = LatLng(location.latitude, location.longitude)
        Log.d("LocationMock", "Requested latitude = " + location.latitude)
        Log.d("LocationMock", "Requested longitude = " + location.longitude)
        mMap.addMarker(MarkerOptions().position(markerPosition).title("Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(markerPosition))
    }
}
