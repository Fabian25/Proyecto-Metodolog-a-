/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import java.util.List;
import Model.Persona;
import javafx.scene.control.TextField;

/**
 *
 * @author Fabian
 */
public interface IEmpleadoDAO {

    public void registrar(TextField txt_Name, TextField txt_Phone, TextField txt_ID, TextField txt_LastName, TextField txt_Email);

    public List<Persona> ver();

    public void actualizar(TextField txt_Name, TextField txt_Phone, TextField txt_LastName, TextField txt_Email, Persona p);

    public void eliminar(TextField txt_ID);
}
