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
 * @author jose
 */
public interface IClienteDAO {
    
   	public void registrar(TextField txtCName,TextField txtCLastNmae,TextField txtCIDnum,TextField txtCPhoneNum,TextField txtCEmail);
	public List<Persona> ver();
	public void actualizar(TextField txtCName,TextField txtCLastNmae,TextField txtCPhoneNum,TextField txtCEmail,Persona p);
	public void eliminar(TextField txtCIDnum); 
        
}
