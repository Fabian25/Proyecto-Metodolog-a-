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
public class Clones {
    
    public static void clonar(String Nombre,String Apellido,int Cedula,String Correo,String Contrasena,int Telefono,String Codigo) throws CloneNotSupportedException {
        Persona Base = new Clientes();
        Base.setNombre("SSSSSSSSSSSSS");
        Base.setApellido("SSSSSSSSSSSSS");
        Base.setCedula(000000000);
        Base.setCorreo("SSSSSSSSS@SSSSSS.SSSS");
        Base.setContrasena("SSSSSSSSSSSSSSS0000");
        Base.setTelefono(88888888);
        Base.setCodigo("SSSSSSSSS000");
        
        Persona clon = Base.clone();
        
        clon.setNombre(Nombre);
        clon.setApellido(Apellido);
        clon.setCedula(Cedula);
        clon.setCorreo(Correo);
         clon.setContrasena(Contrasena);
         clon.setTelefono(Telefono);
        clon.setCodigo(Codigo);
        
        
    }
}
