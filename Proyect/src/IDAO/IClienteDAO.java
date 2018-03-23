/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;
import Model.Clientes;
import java.util.List;
import Model.*;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
/**
 *
 * @author jose
 */
public interface IClienteDAO {
              public Clientes obtenerCliente(Clientes h);
   	public void registrar(Clientes h);
	public List<Persona> ver();
	public void actualizar(Clientes h);
	public void eliminar(Clientes h); 
        public ObservableList<Clientes> Clientes();
}
