package com.example.mascotas;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ContactoActivity extends AppCompatActivity {
    String nombre;
    String correo;
    String mensaje;
    TextInputLayout tilNombre;
    TextInputLayout tilCorreo;
    TextInputLayout tilMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        tilNombre   = (TextInputLayout) findViewById(R.id.tilNombre);
        tilCorreo   = (TextInputLayout) findViewById(R.id.tilCorreo);
        tilMensaje  = (TextInputLayout) findViewById(R.id.tilMensaje);
        btnEnviar   = (Button)          findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, correo);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contacto");
                intent.putExtra(Intent.EXTRA_TEXT, mensaje);


                try {
                    startActivity(Intent.createChooser(intent, "Enviar email."));
                }
                catch (android.content.ActivityNotFoundException e) {
                }
            }
        });
    }

    public void obteberDatos(){
        nombre  = tilNombre.getEditText().getText().toString();
        correo  = tilCorreo.getEditText().getText().toString();
        mensaje = tilMensaje.getEditText().getText().toString();
    }





}