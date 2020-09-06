package com.example.mascotas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);


        glm.setOrientation(GridLayoutManager.HORIZONTAL);
        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        incializarAdapter();
        return v;


    }
    public MascotaAdapter adaptador;
    public void incializarAdapter(){
        adaptador = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("kiara", R.drawable.p1, 5));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 4));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 3));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 2));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 1));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 0));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 0));
        mascotas.add(new Mascota("kiara", R.drawable.p1, 0));
    }
}
