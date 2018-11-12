package com.laugracianool.frisby;

import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.MapView;
        import com.google.android.gms.maps.OnMapReadyCallback;
        import com.google.android.gms.maps.model.LatLng;
        import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class SabanetaFragment extends Fragment implements OnMapReadyCallback {

    private TextView tSede, tDescripcion;
    private ImageView iImagen;
    MapView mapView;
    GoogleMap mMap;


    public SabanetaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_apartado, container, false);

        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        tSede = view.findViewById(R.id.tSede);
        tDescripcion = view.findViewById(R.id.tDescripcion);
        iImagen = view.findViewById(R.id.iImagen);

        tSede.setText("Frisby Sabaneta");
        tDescripcion.setText("Dirección: \n  Carrera 45 # 69s 25"+
                "\nHorario: \n" +
                "   lunes\t11:00a21:00\n" +
                "   martes\t11:00a21:00\n" +
                "   miércoles\t11:00a21:00\n" +
                "   jueves\t11:00a21:00\n" +
                "   viernes\t11:00a21:00\n" +
                "   sábado\t11:00a22:00\n" +
                "   domingo\t11:00a21:00\n" +
                "Teléfono: 301 5555555");
        iImagen.setImageResource(R.drawable.frisby);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng frisby = new LatLng(6.152201, -75.615648);
        mMap.addMarker(new MarkerOptions().position(frisby)
                .title("Frisby Sabaneta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(frisby));
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }
}