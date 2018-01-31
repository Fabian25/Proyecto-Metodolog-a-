/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 

import Connection.Connexion;
import IDAO.*;
import MODEL.*;
 
public class CLIENTDAOLPML implements ICLIENTEDAO {	
	
	@Override
	public boolean registrar(CLIENTE cliente) {
		boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Clientes values (NULL,'"+"CL0001"+cliente.getCedula()+"','"+cliente.getNombre()+"','"+cliente.getApellido()+"')";
		
		try {			
			con=Connexion.conexion();
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
	public List<CLIENTE> obtener() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM CLIENTE ORDER BY ID";
		
		List<CLIENTE> listaCliente= new ArrayList<CLIENTE>();
		
		try {			
			co= Connexion.conexion();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				CLIENTE c=new CLIENTE();
				c.setId(rs.getInt(1));
				c.setCedula(rs.getString(2));
				c.setNombre(rs.getString(3));
				c.setApellido(rs.getString(4));
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
	public boolean actualizar(CLIENTE cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE CLIENTE SET cedula='"+cliente.getCedula()+"', nombres='"+cliente.getNombre()+"', apellidos='"+cliente.getApellido()+"'" +" WHERE ID="+cliente.getId();
		try {
			connect=Connexion.conexion();
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
	public boolean eliminar(CLIENTE cliente) {
		Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM CLIENTE WHERE ID="+cliente.getId();
		try {
			connect=Connexion.conexion();
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
