package com.example.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        incializarAdapter();
    }

    public void incializarAdapter(){
        MascotaAdapter adapter = new MascotaAdapter(mascotas);
        listaMascotas.setAdapter(adapter);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("kiara", R.drawable.p1, 5));
        mascotas.add(new Mascota("derbi", R.drawable.p2, 4));
        mascotas.add(new Mascota("peluca", R.drawable.p1, 3));
        mascotas.add(new Mascota("tobi", R.drawable.p2, 2));
        mascotas.add(new Mascota("mora", R.drawable.p1, 1));
    }
}