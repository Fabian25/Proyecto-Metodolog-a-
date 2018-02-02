/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.Tiquetes;
import java.util.List;
/**
 *
 * @author jose
 */
public class ViewTiquetes {
    
public void verCliente(Tiquetes tiquete) {
		System.out.println("Datos del tiquete: "+tiquete);
	}
	
	public void verClientes(List<Tiquetes> tiquetes) {
		for (Tiquetes tiquet : tiquetes) {
			System.out.println("Datos del tiquete: "+tiquet);
		}		
	} 
}
