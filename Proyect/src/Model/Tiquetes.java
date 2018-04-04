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

<<<<<<< HEAD
    public Tiquetes(String ID_Tiquete, String prioridad, String estado, int Activo) {
        this.ID_Tiquete = ID_Tiquete;
        this.prioridad = prioridad;
        this.estado = estado;
        this.Activo = Activo;
=======
    public Tiquetes(String ID_Tiquete, String prioridad, String descripcion, int estado, String solucion, int IdCliente, int IdEmpleado) {
        this.ID_Tiquete = ID_Tiquete;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.solucion = solucion;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
>>>>>>> 98a467c5e6f52fc642448b8781c2643beeb98605
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
<<<<<<< HEAD
    
     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String estado) {
        this.descripcion = estado;
    }
    
=======

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

    

>>>>>>> 98a467c5e6f52fc642448b8781c2643beeb98605
    private String ID_Tiquete;
    private String prioridad;
    private String estado;
    private String solucion;
<<<<<<< HEAD
    private String descripcion;
=======
    private int IdCliente;
    private int IdEmpleado;
   
   
>>>>>>> 98a467c5e6f52fc642448b8781c2643beeb98605

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo = Activo;
    }
    private int Activo;
}

