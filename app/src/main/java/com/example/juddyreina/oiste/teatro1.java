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

public class teatro1 extends Fragment {
    static final LatLng pos1 = new LatLng(6.2432169,-75.5797098);//MONTERREY

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_teatro1, container, false);

        mMapView = (MapView) v.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        MarkerOptions marker1 = new MarkerOptions().position(pos1).title("METROPOLITANO");
        googleMap.addMarker(marker1.title("METROPOLITANO").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_teatro)));
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(pos1).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);

        return v;
    }

}
