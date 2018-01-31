/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;
import java.util.List;
import MODEL.CLIENTE;
/**
 *
 * @author jose
 */
public interface ICLIENTEDAO {
   	public boolean registrar(CLIENTE cliente);
	public List<CLIENTE> obtener();
	public boolean actualizar(CLIENTE cliente);
	public boolean eliminar(CLIENTE cliente); 
}
