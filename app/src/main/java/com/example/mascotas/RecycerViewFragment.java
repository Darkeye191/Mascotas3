package com.example.mascotas;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecycerViewFragment extends Fragment implements  IRecyclerViewFragmentView {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_lista, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfil);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("kiara", R.drawable.p1, 5));
        mascotas.add(new Mascota("derbi", R.drawable.p2, 4));
        mascotas.add(new Mascota("peluca", R.drawable.p1, 3));
        mascotas.add(new Mascota("tobi", R.drawable.p2, 2));
        mascotas.add(new Mascota("mora", R.drawable.p1, 1));
        mascotas.add(new Mascota("pia", R.drawable.p2, 0));
        mascotas.add(new Mascota("chato", R.drawable.p1, 0));
        mascotas.add(new Mascota("wera", R.drawable.p2, 0));
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adaptador = new MascotaAdapter(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adapter) {
        listaMascotas.setAdapter(adapter);
    }
}
