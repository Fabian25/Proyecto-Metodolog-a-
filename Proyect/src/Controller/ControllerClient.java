/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.util.ArrayList;
import java.util.List;
 
import DAO.*;
import IDAO.*;
import MODEL.*;
import VIEW.*;
public class ControllerClient {
    private VIEWCLIENTE vista= new VIEWCLIENTE();
	
	public ControllerClient() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(CLIENTE cliente ) {
		ICLIENTEDAO dao= new  CLIENTDAOLPML();
		dao.registrar(cliente);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(CLIENTE cliente) {
		ICLIENTEDAO dao= new CLIENTDAOLPML();
		dao.actualizar(cliente);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(CLIENTE cliente) {
		ICLIENTEDAO dao= new  CLIENTDAOLPML();
		dao.eliminar(cliente);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verClientes(){
		List<CLIENTE> clientes = new ArrayList<CLIENTE>();
		ICLIENTEDAO dao= new  CLIENTDAOLPML();
		clientes=dao.obtener();
		vista.verClientes(clientes);
	}
}
