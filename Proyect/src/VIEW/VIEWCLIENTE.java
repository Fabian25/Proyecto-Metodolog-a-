/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;
import java.util.List;
import MODEL.*;
/**
 *
 * @author jose
 */
public class VIEWCLIENTE {
    public void verCliente(CLIENTE cliente) {
		System.out.println("Datos del Cliente: "+cliente);
	}
	
	public void verClientes(List<CLIENTE> clientes) {
		for (CLIENTE cliente : clientes) {
			System.out.println("Datos del Cliente: "+cliente);
		}		
	}
}
