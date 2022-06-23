package com.example.tplabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.io.ByteArrayOutputStream;

public class InfoActivity extends AppCompatActivity {

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ActionBar actionBar = super.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        String nombre = extras.getString("nombre");
        Integer casosActuales = Integer.parseInt(extras.getString("casosActuales"));
        Integer casosTotales = Integer.parseInt(extras.getString("casosTotales"));
        Integer muertesTotales = Integer.parseInt(extras.getString("muertesTotales"));
        Integer muertesActuales = Integer.parseInt(extras.getString("muertesActuales"));
        Bitmap bandera = extras.getParcelable("imageURL");
        Integer indice = extras.getInt("indice");

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bandera.compress(Bitmap.CompressFormat.PNG, 80, stream);
        byte[] byteArrayBandera = stream.toByteArray();

        Pais pais = new Pais(nombre, casosTotales, casosActuales, muertesTotales, muertesActuales, byteArrayBandera, indice);

        PaisView view = new PaisView(pais, this);
        view.MostrarModelo();


        View fab = this.findViewById(R.id.fab);
        shareButtonListener shareButton = new shareButtonListener(pais, this);
        fab.setOnClickListener(shareButton);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}