/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;
import java.util.List;
import Model.Cliente;
/**
 *
 * @author jose
 */
public interface IClienteDAO {
   	public boolean registrar(Cliente cliente);
	public List<Cliente> obtener();
	public boolean actualizar(Cliente cliente);
	public boolean eliminar(Cliente cliente); 
}
