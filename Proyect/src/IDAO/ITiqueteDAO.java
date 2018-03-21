/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import Model.Empleados;
import Model.Tiquetes;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author jose
 */
public interface ITiqueteDAO {

    public void registrarTiquetes(TextField txt_Series,ComboBox<?> txt_Status,TextArea txt_description);

    public List<Tiquetes> VerTiquetes();
    

    public void EditarTiquetes(ComboBox<?> txt_Status,TextArea txt_description, Tiquetes t);

    public void procesarTiquete(Tiquetes tiquete);

    public void asignarTiquete(Tiquetes tiquete, Empleados empleado);

    public boolean eliminarTiquetes(Tiquetes tiquete);

    public List<Tiquetes> obtenerTodos();

    public List<Tiquetes> obtenerporEmpleado();
    
}
