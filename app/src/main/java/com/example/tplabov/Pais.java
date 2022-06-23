package com.example.tplabov;

import org.json.JSONObject;

public class Pais {

    private String nombre;
    private Integer casosTotales;
    private Integer casosActuales;
    private Integer muertesTotales;
    private Integer muertesActuales;
    private Integer indice;
    private byte[] bandera;
    private String imageURl;


    public Pais(String nombre, Integer casosTotales, Integer casosActuales, Integer muertesTotales, Integer muertesActuales, String imageURl){
        this.nombre = nombre;
        this.casosTotales = casosTotales;
        this.casosActuales = casosActuales;
        this.muertesTotales = muertesTotales;
        this.muertesActuales = muertesActuales;
        this.imageURl = imageURl;
    }

    public Pais(String nombre, Integer casosTotales, Integer casosActuales, Integer muertesTotales, Integer muertesActuales,String imageURl, Integer indice){
        this.nombre = nombre;
        this.casosTotales = casosTotales;
        this.casosActuales = casosActuales;
        this.muertesTotales = muertesTotales;
        this.muertesActuales = muertesActuales;
        this.imageURl = imageURl;
        this.indice = indice;
    }

    public Pais(String nombre, Integer casosTotales, Integer casosActuales, Integer muertesTotales, Integer muertesActuales,byte[] imageURl, Integer indice){
        this.nombre = nombre;
        this.casosTotales = casosTotales;
        this.casosActuales = casosActuales;
        this.muertesTotales = muertesTotales;
        this.muertesActuales = muertesActuales;
        this.bandera = imageURl;
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCasosTotales() {
        return casosTotales;
    }

    public void setCasosTotales(Integer casosTotales) {
        this.casosTotales = casosTotales;
    }

    public Integer getCasosActuales() {
        return casosActuales;
    }

    public void setCasosActuales(Integer casosActuales) {
        this.casosActuales = casosActuales;
    }

    public Integer getMuertesTotales() {
        return muertesTotales;
    }

    public void setMuertesTotales(Integer muertesTotales) {
        this.muertesTotales = muertesTotales;
    }

    public Integer getMuertesActuales() {
        return muertesActuales;
    }

    public void setMuertesActuales(Integer muertesActuales) {
        this.muertesActuales = muertesActuales;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public String getImageURl() {
        return imageURl;
    }

    public void setImageURl(String imageURl) {
        this.imageURl = imageURl;
    }

    public byte[] getBandera() {
        return bandera;
    }

    public void setBandera(byte[] bandera) {
        this.bandera = bandera;
    }
}
