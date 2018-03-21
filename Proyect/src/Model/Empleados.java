/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jose
 */
public class Empleados extends Persona{

    public Empleados(String codigo, int cedula, String nombre, String apellido, int Telefono, String Correo, String Contrasena) {
        super(cedula, nombre, apellido, Telefono, Correo, Contrasena);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
private String codigo;
    @Override
    public String verPersona() {
        return "EMPLEADO: " + this.getCodigo() + " NUMERO DE CEDULA:" + this.getCedula()+" NOMBRE:" +this.getNombre();
    }
    
}
