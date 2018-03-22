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

    public Tiquetes(String ID_Tiquete, String prioridad, String estado) {
        this.ID_Tiquete = ID_Tiquete;
        this.prioridad = prioridad;
        this.estado = estado;

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
    
    private String ID_Tiquete;
    private String prioridad;
    private String estado;
    private String solucion;
    private String descripcion;
    
}

