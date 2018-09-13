package com.example.pablo.pymtrack.Modelo;

/**
 * Created by Pablo on 09/12/2017.
 */

public class Usuario {

    private String correo;
    private String contraseña;

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return  "Correo        : "+correo+"\n"+
                "Contraseña: "+contraseña+"";
    }
}
