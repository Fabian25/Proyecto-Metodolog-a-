/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BaseDatos.Conexion;
import Model.Empleados;
import IDAO.IEmpleadoDAO;
/**
 *
 * @author Fabian
 */
public class EmpleadoDAOImplements implements IEmpleadoDAO{
      @Override
    public boolean registrar(Persona empleado) {
        boolean registrar=false;
        
        Statement stm=null;
        Connection con=null;
        
        String sql="INSERT INTO empleados values (NULL,'"+empleado.getCedula()+"','"+empleado.getNombre()+"','"+empleado.getApellido()+"')";
        try {
            con =Conexion.conexion();
            stm=con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase EmpleadoDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<Persona> obtener() {
     Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM EMPLEADOS ORDER BY ID";
		
		List<Persona> listaEmpleados= new ArrayList<Persona>();
		
		try {			
			co= Conexion.conexion();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Persona c=new Empleados();
				c.setCodigo(rs.getString(7));
				c.setCedula(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(8));
				listaEmpleados.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase EmpleadoDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaEmpleados; 
    }

    @Override
    public boolean actualizar(Persona empleado) {
       	Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE EMPLEADO SET cedula='"+empleado.getCedula()+"', nombres='"+empleado.getNombre()+"', apellidos='"+empleado.getApellido()+"'" +" WHERE ID="+empleado.getCodigo();
		try {
			connect=Conexion.conexion();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase EmpleadoDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
    }

    @Override
    public boolean eliminar(Persona empleado) {
       Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM EMPLEADO WHERE ID="+empleado.getCodigo();
		try {
			connect=Conexion.conexion();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase EmpleadoDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
}
