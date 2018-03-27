/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Empleados;
import Model.Tiquetes;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author jose
 */
public interface ITiqueteDAO {

    public void registrarTiquetes(TextField txt_Series,ComboBox<?> txt_Status,TextArea txt_description);

  
    public ObservableList<Tiquetes> Tiquetes(String busqueda);
    public List<Tiquetes> ver();

    public void EditarTiquetes(ComboBox<?> txt_Status,TextArea txt_description, Tiquetes t);

    public void procesarTiquete(ComboBox<?> txt_Status, TextArea txt_description, TextArea txt_Solution,Tiquetes tiquete);

    public void asignarTiquete(Tiquetes tiquete, Empleados empleado);

    public void eliminarTiquetes(Tiquetes tiquete);

   
    public List<Tiquetes> obtenerporEmpleado(Empleados empleado);
    
}
