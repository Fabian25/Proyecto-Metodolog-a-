/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Persona;
import java.util.List;
import Model.Empleados;
/**
 *
 * @author Fabian
 */
public class ViewEmpleado {
     public void verEmpleado(Persona empleado) {
		System.out.println("Datos del Empleado: "+empleado);
	}
	
	public void verEmpleados(List<Persona> empleados) {
		for (Persona empleado : empleados) {
			System.out.println("Datos del Empleado: "+empleado);
		}		
	}
}
