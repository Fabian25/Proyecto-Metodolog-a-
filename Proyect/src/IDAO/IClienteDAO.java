/*d
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

    public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail);

    public Clientes VerInfCliente(String txt_Usuario, String txt_Contrasena);

    public List<Persona> ver();

    public void eliminar(int id);

    public void actualizar(String txtCPhoneNum, String txtCName, int Cedula);

    public void ActualizarInfClient(String txtCName, String txtCLastNmae, String txtCPhoneNum, String txtCEmail, int Cedula);

    public ObservableList<Clientes> Clientes(String busqueda);

    public void registrarStorage(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail);

}
