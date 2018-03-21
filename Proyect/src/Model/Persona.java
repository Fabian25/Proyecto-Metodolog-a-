/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.scene.control.Button;

/**
 *
 * @author jose
 */
public abstract class Persona implements Cloneable {

    public Persona clone() throws CloneNotSupportedException {
        return (Persona) super.clone();
    }

    public abstract String verPersona();

    private int cedula;
    private String nombre;
    private String apellido;
    private int Telefono;
    private String Correo;
    private String Contrasena;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
    private Button button;
//    private String Codigo;

    public Persona() {
    }

    public Persona(int cedula, String nombre, String apellido, int Telefono, String Correo, String Contrasena, Button button) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Contrasena = Contrasena;
        this.button = button;
    }

 

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

//    public String getCodigo() {
//        return Codigo;
//    }
//
//    public void setCodigo(String Codigo) {
//        this.Codigo = Codigo;
//    }
    @Override
    public String toString() {
        return this.cedula + ", " + this.nombre + ", " + this.apellido + ", " + this.Correo + ", " + this.Telefono;
    }
}
