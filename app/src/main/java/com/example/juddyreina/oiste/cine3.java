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

public class cine3 extends Fragment {
    static final LatLng posCine1 = new LatLng(6.2521168,-75.5875565);//JUMBO
    static final LatLng posCine2 = new LatLng(6.2406758,-75.586198);//BOSQUE PLAZA
    static final LatLng posCine3 = new LatLng(6.2310509,-75.5723843);//PREMIUM PLAZA

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_cine3, container, false);
        double a=(6.2521168+6.2406758+6.2310509)/3;
        double b=(-75.5875565-75.586198-75.5723843)/3;
        final LatLng posC= new LatLng(a,b);

        mMapView = (MapView) v.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        MarkerOptions marker1 = new MarkerOptions().position(posCine1).title("ROYAL FILMS");
        googleMap.addMarker(marker1.title("ROYAL FILMS").snippet("Jumbo 65").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker2 = new MarkerOptions().position(posCine2).title("ROYAL FILMS");
        googleMap.addMarker(marker2.title("ROYAL FILMS").snippet("Bosque Plaza").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker3 = new MarkerOptions().position(posCine3).title("ROYAL FILMS");
        googleMap.addMarker(marker3.title("ROYAL FILMS").snippet("Bosque Plaza").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(posC).zoom(13).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);

        return v;
    }

}
