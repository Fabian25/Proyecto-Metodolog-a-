/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.HashMap;
public class PersonaPrototype{
private HashMap<String,Persona>clones=new HashMap<String,Persona>();

public PersonaPrototype(){

Clientes client = new Clientes(00000000,"XXX",000000000,"Cliente","Cliente",8888888,"AAAA@GMAIL.COM","Nuevo123");
Empleados employee=new Empleados("EMP000",000000000,"Empleado","Empleado",88888888,"EEEM@GMAIL.COM","Nuevo123");
clones.put("Employees",employee);
clones.put("Clients",client);
}

public Object prototipo(String tipo)throws CloneNotSupportedException{
return clones.get(tipo).clone();
}

}
