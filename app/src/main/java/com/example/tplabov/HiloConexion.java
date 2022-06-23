package com.example.tplabov;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class HiloConexion extends Thread{

    Handler colaMensajes;
    boolean texto;
    String url;
    int position;

    public HiloConexion(Handler colaMensajes,boolean texto){
        this.colaMensajes = colaMensajes;
        this.texto=texto;
    }

    public HiloConexion(Handler colaMensajes, String url, boolean texto, int position){
        this.colaMensajes = colaMensajes;
        this.texto=texto;
        this.url = url;
        this.position = position;
    }

    public void run(){
        HttpManager con = new HttpManager();
        if(this.texto) {
            byte[] respueta = con.obtenerInformacion("https://corona.lmao.ninja/v2/countries/Argentina,Brazil,Italy,Peru,Lithuania,Bolivia,Japan,Afghanistan,Poland,Qatar,Serbia,Uruguay,Zimbabwe");
            String respuetaS = new String(respueta);
            Log.d("respueta",respuetaS);

            Message message = new Message();
            message.arg1 = MainActivity.MENSAJE_STRING;
            message.obj = respuetaS;
            this.colaMensajes.sendMessage(message);
        }else{

            byte[] respueta = con.obtenerInformacion(url);

            Message message = new Message();
            message.arg1 = 3;
            message.arg2 = this.position;
            message.obj = respueta;
            this.colaMensajes.sendMessage(message);

        }

    }
}

