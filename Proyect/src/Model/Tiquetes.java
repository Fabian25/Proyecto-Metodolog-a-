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

    public Tiquetes(String ID_Tiquete, String prioridad, String descripcion, int estado, String solucion, int IdCliente, int IdEmpleado) {
        this.ID_Tiquete = ID_Tiquete;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.solucion = solucion;
        this.IdCliente = IdCliente;
        this.IdEmpleado = IdEmpleado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
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

    

    private String ID_Tiquete;
    private String prioridad;
    private String descripcion;
    private int estado;
    private String solucion;
    private int IdCliente;
    private int IdEmpleado;
   
   

    

}
