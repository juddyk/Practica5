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
    static final LatLng posCine1 = new LatLng(6.2144415,-75.5787166);//MONTERREY
//    static final LatLng posCine2 = new LatLng(6.2406758,-75.586198);//Las Americas
    static final LatLng posCine3 = new LatLng(6.270196,-75.5805519);//Florida

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        double a=(6.2144415+6.270196)/2;
        double b=(-75.5787166-75.5805519)/2;
        final LatLng posC= new LatLng(a,b);
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
        MarkerOptions marker3 = new MarkerOptions().position(posCine3).title("PROCINAL");
        googleMap.addMarker(marker3.title("PROCINAL").snippet("Florida").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(posC).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);

        return v;
    }

}
