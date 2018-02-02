/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;
import java.util.List;
import Model.Persona;
/**
 *
 * @author jose
 */
public interface IClienteDAO {
   	public boolean registrar(Persona cliente);
	public List<Persona> obtener();
	public boolean actualizar(Persona cliente);
	public boolean eliminar(Persona cliente); 
}
