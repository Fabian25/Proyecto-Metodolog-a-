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
public class Clientes extends Persona {

    public Clientes(int Codigo, String EmpresaAsociar, int cedula, String nombre, String apellido, int Telefono, String Correo, String Contrasena) {
        super(cedula, nombre, apellido, Telefono, Correo, Contrasena);
        this.Codigo = Codigo;
        this.EmpresaAsociar = EmpresaAsociar;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public void setEmpresaAsociar(String EmpresaAsociar) {
        this.EmpresaAsociar = EmpresaAsociar;
    }

    public int getCodigo() {
        return Codigo;
    }

    public String getEmpresaAsociar() {
        return EmpresaAsociar;
    }
private int Codigo;
private String EmpresaAsociar;

    @Override
    public String verPersona() {
      return "CLIENTE: " + this.getCodigo() + " NUMERO DE CEDULA:" + this.getCedula()+" NOMBRE:" +this.getNombre();
    }
    
}
