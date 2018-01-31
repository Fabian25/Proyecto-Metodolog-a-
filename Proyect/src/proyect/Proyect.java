/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import Controller.*;
 
import MODEL.*;


public class Proyect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                            CLIENTE cliente = new CLIENTE("1717213183", "Elivar", "Largo");			
		
		// controlador
		ControllerClient controller = new ControllerClient();
 
		// guarda un cliente a través del controlador
		controller.registrar(cliente);
 
		// ver clientes
		controller.verClientes();
 
		// editar un cliente por medio del id
		cliente.setId(1);
		cliente.setNombre("Santiago");
		controller.actualizar(cliente);
 
		// eliminar un cliente por medio del id
		cliente.setId(1);
		controller.eliminar(cliente);
    }
    
}
