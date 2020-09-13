package com.example.mascotas;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;


    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABSE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTabla = "CREATE TABLE " + ConstantesBD.TABLE_CONTACT + "(" +
                ConstantesBD.TABLE_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TABLE_CONTACT_NOMBRE + " TEXT, " +
                ConstantesBD.TABLE_CONTACT_RATE + " TEXT, " +
                ConstantesBD.TABLE_CONTACT_FOTO + " INTEGER"+
                " )";
        String queryCrearTablaLikesMascota = "CREATE TABLE " +ConstantesBD.TABLE_LIKES + "("+
                ConstantesBD.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesBD.TABLE_LIKES_ID_MASCOTA + " INTEGER, "+
                ConstantesBD.TABLE_LIKES_NUMERO_LIKES + " INTEGER, "+
                "FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBD.TABLE_CONTACT + "(" + ConstantesBD.TABLE_CONTACT_ID + ")" +
                ")";


        db.execSQL(queryCrearTabla);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBD.TABLE_CONTACT);
        db.execSQL("DROP TABLE IF EXISTS "+ ConstantesBD.TABLE_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMasctas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM "+ConstantesBD.TABLE_CONTACT;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while(registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setRate(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryLikes = "SELECT COUNT("+ConstantesBD.TABLE_LIKES_NUMERO_LIKES+") as likes " +
                    " FROM " + ConstantesBD.TABLE_LIKES +
                    " WHERE " + ConstantesBD.TABLE_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRate(registrosLikes.getInt(0));
            }else {
                mascotaActual.setRate(0);
            }


            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentResolver){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_CONTACT, null, contentResolver);
        db.close();
    }
    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota contacto){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBD.TABLE_LIKES_NUMERO_LIKES+")" +
                " FROM " + ConstantesBD.TABLE_LIKES +
                " WHERE " + ConstantesBD.TABLE_LIKES_ID_MASCOTA + "="+contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
