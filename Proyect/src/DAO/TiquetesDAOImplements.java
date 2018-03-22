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
import Model.Empleados;
import Model.Tiquetes;
import java.sql.PreparedStatement;
import java.util.Random;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class TiquetesDAOImplements implements ITiqueteDAO {
 Connection connection = BaseDatos.Conexion.getConnection();
 
    private String GenerarCodigoTiquete(String Cod){
       Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "T-" + randomNum;
        return Cod;
    }
 
    private boolean ExisteCodigoTiquete(String cod) {

        String sql = "SELECT * FROM Tiquete t where t.idTiquete = " + cod + ";";
        String[] datos = new String[10];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(9);
            }
            if (datos[0] != null) {
                if (datos[0].equals(cod)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    
    @Override
    public void registrarTiquetes(TextField txt_Series, ComboBox<?> txt_Status, TextArea txt_description) {
         String Cod = " "; 
         Cod = this.GenerarCodigoTiquete(Cod);
        if (txt_Series.getText().length() == 0 ||txt_Status.getValue().toString().length() == 0
                ||txt_description.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {  
             if (ExisteCodigoTiquete(Cod) == false) {
                String sql = "Insert into Tiquete values(" +txt_Series + "," + txt_Status + ","
                        + txt_description + ");";
                String[] datos = new String[10];
                try {
                    Statement stmt = connection.createStatement();
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
              } else {
                JOptionPane.showMessageDialog(null, "The user alredy exists");
              }
        }
        
    }

    @Override
    public List<Tiquetes> VerTiquetes() {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Tiquete where idTiquete = "+ "*" +";";
        List<Tiquetes> listaTiquete = new ArrayList<Tiquetes>();
        try {
            
            stm = connection.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tiquetes c = new Tiquetes();
                c.setEstado(rs.getString(3));
                c.setID_Tiquete(rs.getString(1));
                c.setPrioridad(rs.getString(6));
                listaTiquete.add(c);
            }
            stm.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }
        return listaTiquete;
    }

    @Override
    public void EditarTiquetes(ComboBox<?> txt_Status, TextArea txt_description, Tiquetes t) {
               String Update = "UPDATE Tiquete\n"
                + "SET Estado = "+txt_Status.getValue()
                 + "SET Descripcion = "+txt_description.getText()
                + "WHERE idTiquete = " + t.getID_Tiquete() + ";";
        try {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        

    }

    @Override
    public void procesarTiquete(ComboBox<?> txt_Status, TextArea txt_description, TextArea txt_solution,Tiquetes tiquete) {
         String Update = "UPDATE Tiquete\n"
                + "SET Estado = "+txt_Status.getValue()
                + "SET Descripcion = "+txt_description.getText()
                + "SET Solucion =" + txt_solution.getText()
                + "WHERE idTiquete = " + tiquete.getID_Tiquete() + ";";
        try {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void asignarTiquete(Tiquetes tiquete, Empleados empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarTiquetes(Tiquetes tiquete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tiquetes> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Tiquetes> obtenerporEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    BaseDatos.Conexion cc = new BaseDatos.Conexion();
//
//    public boolean registrar(Tiquetes tiquete) {
//        boolean registrar = false;
//
//        Statement stm = null;
//        Connection con = null;
//
//        String sql = "INSERT INTO Tiquetes values (NULL,'" + tiquete.getID_Tiquete() + "','" + tiquete.getPrioridad() + "','" + tiquete.getEstado() + "');";
//
//        try {
//            con = Conexion.conexion();
//            stm = con.createStatement();
//            stm.execute(sql);
//            registrar = true;
//            stm.close();
//            con.close();
//        } catch (SQLException e) {
//            System.out.println("Error: Clase TiqueteDAO, método registrar");
//            e.printStackTrace();
//        }
//        return registrar;
//    }
//
//    public List<Tiquetes> obtener() {
//        Connection co = null;
//        Statement stm = null;
//        ResultSet rs = null;
//
//        String sql = "SELECT * FROM Tiquetes ORDER BY idTiquete";
//
//        List<Tiquetes> Tiquetes = new ArrayList<Tiquetes>();
//
//        try {
//            co = Conexion.conexion();
//            stm = co.createStatement();
//            rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                Tiquetes c = new Tiquetes();
//
//                c.setEstado(rs.getString(3));
//                c.setID_Tiquete(rs.getString(1));
//                c.setPrioridad(rs.getString(2));
//                Tiquetes.add(c);
//            }
//            stm.close();
//            rs.close();
//            co.close();
//        } catch (SQLException e) {
//            System.out.println("Error: Clase TiquetesDaoImple, método obtener");
//            e.printStackTrace();
//        }
//
//        return Tiquetes;
//    }
//
//    public boolean actualizar(Tiquetes tiquete) {
//        Connection cn = cc.conexion();
//        Statement stm = null;
//        boolean actualizar = false;
//        String sql = "UPDATE Tiquetes SET Estado='" + tiquete.getEstado() + "', Prioridad='" + tiquete.getPrioridad() + " WHERE idTiquete=" + tiquete.getID_Tiquete()+";";
//        try {
//            Statement stmt = cn.createStatement();
//            PreparedStatement pst = cn.prepareStatement(sql);
//            pst.executeUpdate();
//            actualizar = true;
//        } catch (SQLException e) {
//            System.out.println("Error: Clase TiqueteDaoImple, método actualizar");
//            e.printStackTrace();
//        }
//        return actualizar;
//    }
//
//    public boolean eliminar(Tiquetes tiquete) {
//        Statement stm = null;
//
//        boolean eliminar = false;
//      
//        return eliminar;
//    }
//
//    @Override
//    public void procesarTiquete(Tiquetes tiquete) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void asignarTiquete(Tiquetes tiquete, Empleados empleado) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Tiquetes> obtenerTodos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Tiquetes> obtenerporEmpleado() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean registrarTiquetes(TextField txt_Series, ComboBox<?> txt_Status, TextArea txt_description) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Tiquetes> VerTiquetes() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean EditarTiquetes(ComboBox<?> txt_Status, TextArea txt_description) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public boolean eliminarTiquetes(Tiquetes tiquete) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}
