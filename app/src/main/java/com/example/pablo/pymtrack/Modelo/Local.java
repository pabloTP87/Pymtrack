package com.example.pablo.pymtrack.Modelo;

/**
 * Created by Pablo on 09/12/2017.
 */

public class Local {

    private String nombre;
    private String direccion;
    private String horario;
    private String descripcion;
    private String categoria;
    private int imagen;

    public Local(String nombre, String direccion, String horario, String descripcion, String categoria, int imagen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
