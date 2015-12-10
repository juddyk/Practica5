package com.example.juddyreina.oiste;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class cine2 extends Fragment {
    static final LatLng posCine1 = new LatLng(6.232723,-75.6034859);//MONTERREY
    static final LatLng posCine2 = new LatLng(6.2406758,-75.586198);//FLORIDA

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_cine2, container, false);

        mMapView = (MapView) v.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        MarkerOptions marker1 = new MarkerOptions().position(posCine1).title("PROCINAL");
        googleMap.addMarker(marker1.title("PROCINAL").snippet("Monterrey").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker2 = new MarkerOptions().position(posCine2).title("PROCINAL");
        googleMap.addMarker(marker2.title("PROCINAL").snippet("Florida").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(posCine2).zoom(13).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);

        return v;
    }

}
