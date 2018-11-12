package com.laugracianool.frisby;



import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment {

    ArrayList<Sedes> listaSedes;
    RecyclerView recyclerView;
    private android.support.v4.app.FragmentManager fm;
    private FragmentTransaction ft;


    public ListadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listado, container, false);

        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        listaSedes = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarSedes();

        ListadoAdapter listadoAdapter = new ListadoAdapter(listaSedes);

        listadoAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes().equals("Nuestro Uraba")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new ApartadoFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }else if(listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes().equals("Centro comercial puerta del norte")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new BelloFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes().equals("City plaza")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new EnvigadoFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes().equals("Centro comercial Mayorca")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new ItaguiFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes().equals("Frisby la Estrella")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new LaEstrellaFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                else if(listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes().equals("Frisby Sabaneta")){
                    Toast.makeText(getContext(),"Seleccion: "+ listaSedes.get(recyclerView.getChildAdapterPosition(v)).getSedes(),Toast.LENGTH_LONG).show();
                    transaction.replace(R.id.frame,new LaEstrellaFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        recyclerView.setAdapter(listadoAdapter);
        return view;
    }

    private void llenarSedes() {
        listaSedes.add(new Sedes("Nuestro Uraba","Carrera 100 # 1 la Milla de oro de Apartado",R.drawable.frisbyApartado));
        listaSedes.add(new Sedes("Centro comercial puerta del norte","Diagonal 55 # 34 67",R.drawable.frisbyBello));
        listaSedes.add(new Sedes("City plaza","Cll 36 D sur No.27 105 Lc 285 Ccial La city plaza",R.drawable.frisbyEnvigado));
        listaSedes.add(new Sedes("Centro comercial Mayorca","Carrera 51 sur # 48 57",R.drawable.frisbyItagui));
        listaSedes.add(new Sedes("Frisby la Estrella","Calle 77 Sur # 50 A 195",R.drawable.frisbyLaEstrella));
        listaSedes.add(new Sedes("Frisby Sabaneta","Carrera 45 # 69s 25",R.drawable.frisbySabaneta));
    }

}
