package com.example.tplabov;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class PaisVH extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView tvNombre;
    TextView tvCasosActuales;
    TextView tvCasosTotales;
    TextView tvMuertesTotales;
    TextView tvMuertesActuales;
    ImageView imageURL;
    View item;
    Activity a;

    public PaisVH(View itemView, Activity a){
        super(itemView);
        this.tvNombre = itemView.findViewById(R.id.tvNombre);
        this.tvCasosActuales = itemView.findViewById(R.id.tvCasosActuales);
        this.tvCasosTotales = itemView.findViewById(R.id.tvCasosTotales);
        this.tvMuertesTotales = itemView.findViewById(R.id.tvMuertesTotales);
        this.tvMuertesActuales = itemView.findViewById(R.id.tvMuertesActuales);;
        this.imageURL = itemView.findViewById(R.id.imgPais);
        this.item = itemView.findViewById(R.id.pais);
        this.a = a;
    }

    public void onClick(View v){

        BitmapDrawable drawable = (BitmapDrawable) imageURL.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        Intent i = new Intent(this.a, InfoActivity.class);
        i.putExtra("nombre", this.tvNombre.getText());
        i.putExtra("casosActuales", this.tvCasosActuales.getText());
        i.putExtra("casosTotales", this.tvCasosTotales.getText());
        i.putExtra("muertesTotales", this.tvMuertesTotales.getText());
        i.putExtra("muertesActuales", this.tvMuertesActuales.getText());
        i.putExtra("indice", this.getAdapterPosition());
        i.putExtra("imageURL", bitmap);

        a.startActivityForResult(i, 1);

    }

}
