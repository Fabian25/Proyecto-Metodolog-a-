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
 * @author Fabian
 */
public interface IEmpleadoDAO {
       public boolean registrar(Persona empleado);
	public List<Persona> obtener();
	public boolean actualizar(Persona empleado);
	public boolean eliminar(Persona empleado); 
}
