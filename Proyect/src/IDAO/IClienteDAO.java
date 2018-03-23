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
<<<<<<< HEAD
             public Clientes obtenerCliente(Clientes h);
   	public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail);
=======
<<<<<<< HEAD

    public Clientes obtenerCliente(Clientes h);

    public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail);

    public List<Persona> ver();

    public void actualizar(Clientes h);

    public void eliminar(Clientes h);

    public ObservableList<Clientes> Clientes();
=======
              public Clientes obtenerCliente(Clientes h);
   	public void registrar(Clientes h);
>>>>>>> 5b13f6042d2cd32fd2e4f46a4e151577ce3934a6
	public List<Persona> ver();
	public void actualizar(Clientes h);
	public void eliminar(Clientes h); 
        public ObservableList<Clientes> Clientes();
>>>>>>> 455e1e7c8dc39aa8a00d20fe25aa26eb36de234a
}
