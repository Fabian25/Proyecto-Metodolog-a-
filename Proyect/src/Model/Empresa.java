/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author erick
 */
public class Empresa {
     private String idEmpresa;
    private String Nombre;
    private String Acronimo;
    private int Telefono;
    private int Activo;


    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getAcronimo() {
        return Acronimo;
    }

    public void setAcronimo(String Acronimo) {
        this.Acronimo = Acronimo;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }

    public Empresa() {
    }

    public Empresa(String idEmpresa, String Nombre, String Acronimo, int Telefono, int Activo) {
        this.idEmpresa = idEmpresa;
        this.Nombre = Nombre;
        this.Acronimo = Acronimo;
        this.Telefono = Telefono;
        this.Activo = Activo;
    }
   
}
