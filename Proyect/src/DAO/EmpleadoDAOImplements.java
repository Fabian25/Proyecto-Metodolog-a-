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
import java.sql.PreparedStatement;
import java.util.Random;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 *
 * @author Fabian
 */
public class EmpleadoDAOImplements implements IEmpleadoDAO{
    Connection connection = BaseDatos.Conexion.getConnection();
    public boolean ExisteCedula(String ced, String cod) {
        
        String sql = "SELECT * FROM Persona p where p.IdPersona = " + ced + "and p.Codigo = " + cod + ";";
        String[] datos = new String[10];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(9);
            }
            if (datos[0] != null) {
                if (datos[0].equals(ced) || datos[1].equals(cod)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
 

    @Override
    public void registrar(TextField txt_Name, TextField txt_Phone, TextField txt_ID, TextField txt_LastName, TextField txt_Email) {
       String Cod = "";
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "EMP-" + randomNum;
        if (txt_Name.getText().length() == 0 ||txt_LastName.getText().length() == 0
                ||txt_ID.getText().length() == 0 || txt_Phone.getText().length() == 0
                ||  txt_Email.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
            if (ExisteCedula(txt_ID.getText(), Cod) == false) {
                
                String sql = "Insert into Persona values(" +txt_ID.getText() + "," + txt_Name.getText() + ","
                        + txt_Phone.getText() + "," +  txt_Email.getText() + "," + "Nuevo123*" + "," + Cod+ "," + txt_LastName.getText() + ");";
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
    public void eliminar(TextField txt_ID) {
    

        String Update = "UPDATE Personas\n"
                + "SET Activo = " + "0"
             
                + "WHERE IdPersona = " +txt_ID.getText() + ";";
        try {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(TextField txt_Name, TextField txt_Phone, TextField txt_LastName, TextField txt_Email, Persona p) {
           
        String Update = "UPDATE Personas\n"
                + "SET Nombre = "+txt_Name.getText()
                 + "SET Apellido = "+txt_LastName.getText()
                 + "SET Telefono = "+txt_Phone.getText()
                 + "SET Correo = "+txt_Email.getText()
                + "WHERE IdPersona = " + Integer.toString(p.getCedula() )+ ";";
        try {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Persona> ver() {
  Statement stm = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= "+"2"  +";";
        List<Persona> listaCliente = new ArrayList<Persona>();
        try {
            
            stm = connection.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Empleados();
                c.setCodigo(rs.getString(7));
                c.setCedula(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(8));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }
}
