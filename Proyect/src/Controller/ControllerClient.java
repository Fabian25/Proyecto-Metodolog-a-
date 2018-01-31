/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.ViewCliente;
import Model.Cliente;
import java.util.ArrayList;
import java.util.List;
 
import DAO.*;
import IDAO.*;
public class ControllerClient {
    private ViewCliente vista= new ViewCliente();
	
	public ControllerClient() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(Cliente cliente ) {
		IClienteDAO dao= new  ClienteDAOImplements();
		dao.registrar(cliente);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Cliente cliente) {
		IClienteDAO dao= new ClienteDAOImplements();
		dao.actualizar(cliente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Cliente cliente) {
		IClienteDAO dao= new  ClienteDAOImplements();
		dao.eliminar(cliente);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verClientes(){
		List<Cliente> clientes = new ArrayList<Cliente>();
		IClienteDAO dao= new  ClienteDAOImplements();
		clientes=dao.obtener();
		vista.verClientes(clientes);
	}
}
