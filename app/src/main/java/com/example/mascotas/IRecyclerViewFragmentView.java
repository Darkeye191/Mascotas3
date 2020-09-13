package com.example.mascotas;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView  {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adapter);
}
