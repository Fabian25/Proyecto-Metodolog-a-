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
import IDAO.*;
import Model.Clientes;
 
public class ClienteDAOImplements implements IClienteDAO {	
	
	@Override
	public boolean registrar(Persona cliente) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Clientes values (NULL,'"+"CL0001"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"')";
		
		try {			
			con=Conexion.conexion();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método registrar");
			e.printStackTrace();
		}
		return registrar;
	}
 
	@Override
	public List<Persona> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM CLIENTE ORDER BY ID";
		
		List<Persona> listaCliente= new ArrayList<Persona>();
		
		try {			
			co= Conexion.conexion();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Persona c=new Clientes();
				c.setCodigo(rs.getString(7));
				c.setCedula(rs.getInt(1));
				c.setNombre(rs.getString(2));
				c.setApellido(rs.getString(8));
				listaCliente.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return listaCliente;
	}
 
	@Override
	public boolean actualizar(Persona cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE CLIENTE SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()+"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getCodigo();
		try {
			connect=Conexion.conexion();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
	}
 
	@Override
	public boolean eliminar(Persona cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getCodigo();
		try {
			connect=Conexion.conexion();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase ClienteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
	}
 
}