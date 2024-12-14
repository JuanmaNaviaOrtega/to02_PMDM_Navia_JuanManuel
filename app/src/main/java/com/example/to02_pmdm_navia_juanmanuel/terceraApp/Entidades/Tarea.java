package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades;

import java.io.Serializable;

public class Tarea implements Serializable {
    private String nombre;
    private String descripcion;
    private int imagenId;
    private String emailAdministrador;
    private String url;

    public Tarea(String nombre, int imagenId,String url,String descripcion, String emailAdministrador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.emailAdministrador = emailAdministrador;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public String getUrl() {
        return url;
    }
}
