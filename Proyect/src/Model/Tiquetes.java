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
public class Tiquetes {

    public Tiquetes() {
    }



    public String getID_Tiquete() {
        return ID_Tiquete;
    }

    public void setID_Tiquete(String ID_Tiquete) {
        this.ID_Tiquete = ID_Tiquete;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
     public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String estado) {
        this.solucion = estado;
    }

    
     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String estado) {
        this.descripcion = estado;
    }
    

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(int IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public Tiquetes(String ID_Tiquete, String prioridad, String descripcion, String estado, String solucion, int IdCliente, int IdEmpleado, int Activo) {
        this.ID_Tiquete = ID_Tiquete;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.solucion = solucion;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
        this.Activo = Activo;
    }

    


    private String ID_Tiquete;
    private String prioridad;
    private String descripcion;
    private String estado;
    private String solucion;
    private int IdCliente;
    private int IdEmpleado;
    private int Activo;

    
   
   

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }
    
}

