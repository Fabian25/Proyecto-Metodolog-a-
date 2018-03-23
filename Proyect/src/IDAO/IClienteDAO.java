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

=======
>>>>>>> 2cc8d195608fa83d1a0e7240e475f5eac6127b31

    public Clientes obtenerCliente(Clientes h);

    public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail);

    public List<Persona> ver();

    public void actualizar(Clientes h);

    public void eliminar(Clientes h);

    public ObservableList<Clientes> Clientes();
<<<<<<< HEAD
=======

    public void registrar(Clientes h);

>>>>>>> 2cc8d195608fa83d1a0e7240e475f5eac6127b31
}
