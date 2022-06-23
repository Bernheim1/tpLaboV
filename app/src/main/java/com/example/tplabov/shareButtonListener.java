package com.example.tplabov;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

public class shareButtonListener implements View.OnClickListener{

    String tvNombre;
    Integer tvCasosActuales;
    Integer tvCasosTotales;
    Integer tvMuertesTotales;
    Integer tvMuertesActuales;
    Image imgPais;
    View item;
    Activity a;

    public shareButtonListener(Pais pais, Activity a){
        this.tvNombre = pais.getNombre();
        this.tvCasosActuales = pais.getCasosActuales();
        this.tvCasosTotales = pais.getCasosTotales();
        this.tvMuertesTotales = pais.getMuertesTotales();
        this.tvMuertesActuales = pais.getMuertesActuales();
//      this.imgPais = itemView.findViewById(R.id.imgPais);
        this.a = a;
    }

    @Override
    public void onClick(View view) {

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, tvNombre);
        Log.d("nombre:", tvNombre);
//        shareIntent.putExtra(Intent.EXTRA_STREAM,);
//        shareIntent.setType("image/*");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        a.startActivity(Intent.createChooser(shareIntent, "Compartir pais"));


    }


}
