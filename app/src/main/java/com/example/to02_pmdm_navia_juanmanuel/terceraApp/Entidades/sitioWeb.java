package com.example.to02_pmdm_navia_juanmanuel.terceraApp.Entidades;

import java.io.Serializable;

public class sitioWeb implements Serializable {
    private String nombre;
    private int imagenId;
    private String link;
    private String descripcion;
    private String emailAdministrador;

    public sitioWeb(String nombre, int imagenId, String link, String descripcion, String emailAdministrador) {
        this.nombre = nombre;
        this.imagenId = imagenId;
        this.link = link;
        this.descripcion = descripcion;
        this.emailAdministrador = emailAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmailAdministrador() {
        return emailAdministrador;
    }

    public void setEmailAdministrador(String emailAdministrador) {
        this.emailAdministrador = emailAdministrador;
    }
}
