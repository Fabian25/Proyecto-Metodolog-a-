/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import View.ViewEmpleado;
import Model.Persona;
import java.util.ArrayList;
import java.util.List;
 
import DAO.*;
import IDAO.*;
/**
 *
 * @author Fabian
 */
public class ControllerEmpleado {
      private ViewEmpleado vista= new ViewEmpleado();
	
	public ControllerEmpleado() {
	}
	
	//llama al DAO para guardar un cliente
	public void registrar(Persona empleado ) {
		IEmpleadoDAO dao= new  EmpleadoDAOImplements();
		dao.registrar(empleado);
	}
	
	//llama al DAO para actualizar un cliente
	public void actualizar(Persona empleado) {
		IEmpleadoDAO dao= new  EmpleadoDAOImplements();
		dao.actualizar(empleado);
	}
	
	//llama al DAO para eliminar un cliente
	public void eliminar(Persona empleado) {
		IEmpleadoDAO dao= new  EmpleadoDAOImplements();
		dao.eliminar(empleado);
	}
	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verClientes(){
		List<Persona> empleados = new ArrayList<Persona>();
		IEmpleadoDAO dao= new  EmpleadoDAOImplements();
		empleados=dao.obtener();
		vista.verEmpleados(empleados);
	}
}
