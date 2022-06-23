package com.example.tplabov;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager {

    public byte[] obtenerInformacion(String urlEndpoint)
    {
        try {

            URL url = new URL(urlEndpoint);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(5000);

            connection.connect();

            int responseCode = connection.getResponseCode();

            if(responseCode == 200) {

                InputStream is = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();

                byte[] buffer = new byte[1024];

                is.read(buffer);

                baos.write(buffer);

                int cantidadLeida=0;
                while ( (cantidadLeida = is.read(buffer)) != -1 )
                {
                    baos.write(buffer, 0, cantidadLeida);
                }

                is.close();


                return baos.toByteArray();

            }else{
                Log.d("ERROR", "Salio mal la consulta " + responseCode);
            }




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




}
