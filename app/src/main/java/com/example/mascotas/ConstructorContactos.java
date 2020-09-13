package com.example.mascotas;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

public class ConstructorContactos {

    public static final int LIKE = 1;
    private Context contex;
    public ConstructorContactos(Context context){
        this.contex = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(contex);
        insertar3MAscotas(db);
        return db.obtenerTodasMasctas();
    }

    public void insertar3MAscotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE,  "kiara");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO,  R.drawable.p1);

        db.insertarMascota(contentValues);

        ContentValues contentValues1 = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE,  "derbi");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO,  R.drawable.p2);

        db.insertarMascota(contentValues);
        ContentValues contentValues2 = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE,  "peluca");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO,  R.drawable.p1);

        db.insertarMascota(contentValues);
        ContentValues contentValues3 = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_CONTACT_NOMBRE,  "tobi");
        contentValues.put(ConstantesBD.TABLE_CONTACT_FOTO,  R.drawable.p2);

        db.insertarMascota(contentValues);
    }
    public void darlike(Mascota mascota){
        BaseDatos db = new BaseDatos(contex);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_NUMERO_LIKES, LIKE);
        db.insertarLike(contentValues);
    }
    public int obtenerLike(Mascota mascota){
        BaseDatos db = new BaseDatos(contex);
        return db.obtenerLikesMascota(mascota);

    }

}
