package com.example.juddyreina.oiste;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class cine1 extends Fragment{

    static final LatLng posCine1 = new LatLng(6.232723,-75.6034859);//MOLINOS
    static final LatLng posCine2 = new LatLng(6.2406758,-75.586198);//UNICENTRO
    static final LatLng posCine3 = new LatLng(6.2081491,-75.563652);//VIZCAYA
    static final LatLng posCine4 = new LatLng(6.1998158,-75.5756559);//SANTAFE
    static final LatLng posCine5 = new LatLng(6.2001107,-75.576092);//OVIEDO

    MapView mMapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_cine1, container, false);

        mMapView = (MapView) v.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume();// needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        googleMap = mMapView.getMap();
        MarkerOptions marker1 = new MarkerOptions().position(posCine1).title("CINE COLOMBIA");
        googleMap.addMarker(marker1.title("CINE COLOMBIA").snippet("Molinos").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker2 = new MarkerOptions().position(posCine2).title("CINE COLOMBIA");
        googleMap.addMarker(marker2.title("CINE COLOMBIA").snippet("Unicentro").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker3 = new MarkerOptions().position(posCine3).title("CINE COLOMBIA");
        googleMap.addMarker(marker3.title("CINE COLOMBIA").snippet("Vizcaya").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker4 = new MarkerOptions().position(posCine4).title("CINE COLOMBIA");
        googleMap.addMarker(marker4.title("CINE COLOMBIA").snippet("Santa Fe").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));
        MarkerOptions marker5 = new MarkerOptions().position(posCine5).title("CINE COLOMBIA");
        googleMap.addMarker(marker5.title("CINE COLOMBIA").snippet("Oviedo").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cine)));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(posCine2).zoom(13).build();
        googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        googleMap.setMyLocationEnabled(true);

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
