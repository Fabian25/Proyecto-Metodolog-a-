/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Empleados;
import java.util.List;
import Model.Persona;
import Model.Tiquetes;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

/**
 *
 * @author Fabian
 */
public interface IEmpleadoDAO {

    public void registrar(String txt_Name,String txt_Phone, String txt_ID, String txt_LastName, String txt_Email);
    public List<Persona> ver();
    public Empleados VerInfEmpleado(String txt_Usuario, String txt_Contrasena);
    
    public void eliminar(int id);
    public void actualizar(String txtName, String txtLastName, int txtPhone, int Cedula);
    public void ActualizarInfEmp(String txt_Name, String txt_LastName, int txt_Phone, int Cedula);
    public ObservableList<Empleados> Empleados(String busqueda, int Cond);
    public void registrarStorage(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail);
    public void procesarTiquete(int cb_status,String txt_Solution, Tiquetes tiquete);
    
    public void actualizar(TextField txt_Name, TextField txt_Phone, TextField txt_LastName, TextField txt_Email, Persona p);
    
    public void eliminar(TextField txt_ID);
    public ObservableList<Tiquetes> Tiquetes(String busqueda);
}
