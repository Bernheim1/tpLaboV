package com.example.tplabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback, SearchView.OnQueryTextListener {

    AdapterPais adapterPais;
    public static  final  int MENSAJE_STRING =1;
    private SearchView svSearch;
    public static List<Pais> paises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar a = super.getSupportActionBar();

        this.svSearch = super.findViewById(R.id.svSearch);
        Handler handler = new Handler(this);

        HiloConexion hilo = new HiloConexion(handler,true);
        hilo.start();



    }

    @Override
    public boolean handleMessage(@NonNull Message message) {

        if(message.arg1 == MENSAJE_STRING){
            Log.d("log", "estoy en el handle");

            List<Pais> aux = this.parsearRespusta(message.obj.toString());

            this.adapterPais = new AdapterPais(aux, this);

            RecyclerView rv = super.findViewById(R.id.rvPaises);
            rv.setAdapter(adapterPais);
            rv.setLayoutManager(new LinearLayoutManager(this));
        }else if(message.arg1 == 3){
            byte[] img = (byte[]) message.obj;
            if(img != null){
                this.paises.get(message.arg2).setBandera(img);
                this.adapterPais.notifyItemChanged(message.arg2);
            }
        }

        return false;
    }

    public List<Pais> parsearRespusta(String paises){
        this.paises = new ArrayList<>();

        JSONArray json = null;
        try {
            json = new JSONArray(paises);
            for(int i = 0; i < json.length(); i++){
                JSONObject elemento = json.getJSONObject(i);
                JSONObject auxBandera = elemento.getJSONObject("countryInfo");
                String urlBandera = auxBandera.getString("flag");
                Pais pais = new Pais(elemento.getString("country"), Integer.parseInt(elemento.getString("cases")), Integer.parseInt(elemento.getString("todayCases")), Integer.parseInt(elemento.getString("deaths")), Integer.parseInt(elemento.getString("todayDeaths")), urlBandera);
                this.paises.add(pais);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return this.paises;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapterPais.filter(s);
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.svSearch);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }
}