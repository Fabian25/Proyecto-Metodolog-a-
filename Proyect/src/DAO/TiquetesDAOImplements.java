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
import BaseDatos.Conexion;
import IDAO.*;
import Model.Tiquetes;
/**
 *
 * @author jose
 */
public class TiquetesDAOImplements implements ITiqueteDAO{

    @Override
    public boolean registrar(Tiquetes tiquete) {
       boolean registrar = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Tiquetes values (NULL,'"+tiquete.getID_Tiquete()+"','"+tiquete.getPrioridad()+"','"+tiquete.getEstado()+"')";
		
		try {			
			con=Conexion.conexion();
			stm= con.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase TiqueteDAO, método registrar");
			e.printStackTrace();
		}
		return registrar;
    }

    @Override
    public List<Tiquetes> obtener() {
      Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM Tiquetes ORDER BY idTiquete";
		
		List<Tiquetes> Tiquetes= new ArrayList<Tiquetes>();
		
		try {			
			co= Conexion.conexion();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Tiquetes c=new Tiquetes();
				
				c.setEstado(rs.getString(3));
				c.setID_Tiquete(rs.getString(1));
                                                          c.setPrioridad(rs.getString(2));
				Tiquetes.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase TiquetesDaoImple, método obtener");
			e.printStackTrace();
		}
		
		return Tiquetes;
    }

    @Override
    public boolean actualizar(Tiquetes tiquete) {
      Connection connect= null;
		Statement stm= null;
		
		boolean actualizar=false;
				
		String sql="UPDATE Tiquetes SET Estado='"+tiquete.getEstado()+"', Prioridad='"+tiquete.getPrioridad() +" WHERE idTiquete="+tiquete.getID_Tiquete();
		try {
			connect=Conexion.conexion();
			stm=connect.createStatement();
			stm.execute(sql);
			actualizar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase TiqueteDaoImple, método actualizar");
			e.printStackTrace();
		}		
		return actualizar;
    }

    @Override
    public boolean eliminar(Tiquetes tiquete) {
       Connection connect= null;
		Statement stm= null;
		
		boolean eliminar=false;
				
		String sql="DELETE FROM Tiquetes WHERE idTiquetes="+tiquete.getID_Tiquete();
		try {
			connect=Conexion.conexion();
			stm=connect.createStatement();
			stm.execute(sql);
			eliminar=true;
		} catch (SQLException e) {
			System.out.println("Error: Clase TiqueteDaoImple, método eliminar");
			e.printStackTrace();
		}		
		return eliminar;
    }
    
}
