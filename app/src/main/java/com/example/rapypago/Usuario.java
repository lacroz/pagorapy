package com.example.rapypago;

public class Usuario {
    private String nombres;
    private String apellidos;
    private int rut;
    private String correo;
    private String contraseña;
    private String ValidarContraseña;
    private String juegos;


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
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

    public String getJuegos() {
        return juegos;
    }

    public void setJuegos(String juegos) {
        this.juegos = juegos;
    }

    public String getValidarContraseña() {
        return ValidarContraseña;
    }

    public void setValidarContraseña(String validarContraseña) {
        ValidarContraseña = validarContraseña;
    }
}
