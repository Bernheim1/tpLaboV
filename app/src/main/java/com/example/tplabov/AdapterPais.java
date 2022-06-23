package com.example.tplabov;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class AdapterPais extends RecyclerView.Adapter<PaisVH> {

    static List<Pais> paises;
    static List<Pais> paisesOriginal;
    Activity a;

    public AdapterPais(){

    }

    public AdapterPais(List<Pais> paises, Activity a){
        this.paises = paises;
        this.paisesOriginal = new ArrayList<>();
        this.paisesOriginal.addAll(paises);
        this.a = a;
    }

    @NonNull
    @Override
    public PaisVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pais, parent, false);

        return new PaisVH(v, this.a);
    }

    @Override
    public void onBindViewHolder(@NonNull PaisVH holder, int position) {

        holder.tvNombre.setText(AdapterPais.paises.get(position).getNombre());
        holder.tvCasosActuales.setText(AdapterPais.paises.get(position).getCasosActuales().toString());
        holder.tvCasosTotales.setText(AdapterPais.paises.get(position).getCasosTotales().toString());
        holder.tvMuertesTotales.setText(AdapterPais.paises.get(position).getMuertesTotales().toString());
        holder.tvMuertesActuales.setText(AdapterPais.paises.get(position).getMuertesActuales().toString());

        String url = AdapterPais.paises.get(position).getImageURl();
        if(AdapterPais.paises.get(position).getBandera() == null || AdapterPais.paises.get(position).getBandera().length == 0){
            Handler handler = new Handler((Handler.Callback) this.a);
            HiloConexion hilo = new HiloConexion(handler, url, false, position);
            hilo.start();
        }else{
            byte[] img = AdapterPais.paises.get(position).getBandera();
            holder.imageURL.setImageBitmap(BitmapFactory.decodeByteArray(img,0,img.length));
        }

        holder.item.setOnClickListener(holder);

    }

    @Override
    public int getItemCount() {
        return this.paises.size();
    }

    public void ActualizarItem(Integer indice, Pais pais){
        AdapterPais.paises.set(indice, pais);
    }

    public void filter(String s){
        if(s.length() == 0){
            paises.clear();
            paises.addAll(paisesOriginal);
        }else{
            paises.clear();
            for(Pais i : paisesOriginal){
                if(i.getNombre().toLowerCase().contains(s.toLowerCase())){
                    paises.add(i);
                }
            }
        }
        notifyDataSetChanged();
    }
}
