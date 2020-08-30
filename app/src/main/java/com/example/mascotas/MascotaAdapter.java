package com.example.mascotas;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHoler> {
    public MascotaAdapter(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    ArrayList<Mascota> mascotas;

    @NonNull
    @Override
    public MascotaViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmascota, parent, false);
        return new MascotaViewHoler(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHoler mascotaViewHoler, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHoler.imgfoto.setImageResource(mascota.getFoto());
        mascotaViewHoler.tvrate.setText(mascota.getRate()+"");
        mascotaViewHoler.tvnombre.setText(mascota.getNombre());
        mascotaViewHoler.btnhueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHoler extends RecyclerView.ViewHolder{

        private ImageView imgfoto;
        private TextView tvnombre;
        private TextView tvrate;
        private ImageView btnhueso;

        public MascotaViewHoler(@NonNull View itemView) {
            super(itemView);
            imgfoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvnombre = (TextView) itemView.findViewById(R.id.txtNombre);
            tvrate = (TextView) itemView.findViewById(R.id.txvRate);
            btnhueso = (ImageView) itemView.findViewById(R.id.btnhueso);
        }
    }
}
