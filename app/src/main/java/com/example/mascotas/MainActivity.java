package com.example.mascotas;

import android.content.Intent;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("");

        ImageView imgesttrella = (ImageView) findViewById(R.id.btnEstrella);
        imgesttrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Favoritos.class);
                startActivity(intent);
            }
        });

        listaMascotas = (RecyclerView) findViewById(R.id.rvMain);
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
        mascotas.add(new Mascota("pia", R.drawable.p2, 0));
        mascotas.add(new Mascota("chato", R.drawable.p1, 0));
        mascotas.add(new Mascota("wera", R.drawable.p2, 0));
    }
}