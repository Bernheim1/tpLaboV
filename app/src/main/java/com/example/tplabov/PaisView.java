package com.example.tplabov;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

public class PaisView {

    Pais pais;
    Activity a;
    TextView tvNombre;
    TextView tvCasosActuales;
    TextView tvCasosTotales;
    TextView tvMuertesTotales;
    TextView tvMuertesActuales;
    ImageView bandera;


    public PaisView(Pais pais, Activity a){

        this.pais = pais;
        this.a = a;

        if(this.tvNombre == null){
            this.tvNombre = this.a.findViewById(R.id.tvNombre);
            this.tvCasosActuales = this.a.findViewById(R.id.tvCasosActuales);
            this.tvCasosTotales = this.a.findViewById(R.id.tvCasosTotales);
            this.tvMuertesTotales = this.a.findViewById(R.id.tvMuertesTotales);
            this.tvMuertesActuales = this.a.findViewById(R.id.tvMuertesActuales);
            this.bandera = this.a.findViewById(R.id.imgPais);
        }
    }

    public void MostrarModelo(){

        tvNombre.setText(this.pais.getNombre());
        tvCasosActuales.setText(this.pais.getCasosActuales().toString());
        tvCasosTotales.setText(this.pais.getCasosTotales().toString());
        tvMuertesTotales.setText(this.pais.getMuertesTotales().toString());
        tvMuertesActuales.setText(this.pais.getMuertesActuales().toString());
        bandera.setImageBitmap(BitmapFactory.decodeByteArray(this.pais.getBandera(),0,this.pais.getBandera().length));

    }
}
