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
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class EmpleadoDAOImplements implements IEmpleadoDAO {

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
    public void registrar(String txt_Name, String txt_Phone, String txt_ID, String txt_LastName, String txt_Email) {
        String Cod = "";
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "EMP-" + randomNum;
        if (txt_Name.length() == 0 || txt_LastName.length() == 0
                || txt_ID.length() == 0 || txt_Phone.length() == 0
                || txt_Email.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
            if (ExisteCedula(txt_ID, Cod) == false) {

                String sql = "Insert into Persona values(" + txt_ID + "," + txt_Name + ","
                        + txt_Phone + "," + txt_Email + "," + "Nuevo123*" + "," + Cod + "," + txt_LastName + ");";
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
                + "WHERE IdPersona = " + txt_ID.getText() + ";";
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

        String query = "{CALL ActualizarEmpleado(?, ?, ?, ?, ?)}";
        try (Connection conn = BaseDatos.Conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, txt_Name.getText());
            stmt.setString(2, txt_LastName.getText());
            stmt.setInt(3, Integer.parseInt(txt_Phone.getText()));
            stmt.setString(4, txt_Email.getText());
            stmt.setInt(4, p.getCedula());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Persona> ver() {

//  Statement stm = null;
//        ResultSet rs = null;
//        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= "+"2"  +";";
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= " + "2" + ";";

        List<Persona> listaCliente = new ArrayList<Persona>();
//        try {
//            stm = connection.createStatement();
//            rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                Persona c = new Empleados();
//                c.setCodigo(rs.getString(7));
//                c.setCedula(rs.getInt(1));
//                c.setNombre(rs.getString(2));
//                c.setApellido(rs.getString(8));
//                listaCliente.add(c);
//            }
//            stm.close();
//            rs.close();
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Error: Clase ClienteDaoImple, método obtener");
//            e.printStackTrace();
//        }

        return listaCliente;
    }

    @Override
    public void actualizar(String txtName, String txtLastName, int txtPhone, int Cedula) {
         String query = "{CALL ActualizarEmpleado(?, ?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, txtName);
            stmt.setString(2, txtLastName);
            stmt.setInt(3, txtPhone);
            stmt.setInt(4, Cedula);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Empleados> Empleados(String busqueda) {
       ObservableList<Empleados> emp = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLEmpleado(busqueda));
            while (rs.next()) {
                emp.add(new Empleados(rs.getString(1),rs.getInt(2) , rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), new Button("X")){
                    @Override
                    public String verPersona() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Empleados \n" + ex);
        }
        return emp;
    }
    
     private String SQLEmpleado(String busqueda) {
        if (busqueda.equals("")) {
            return "Select Cedula, Nombre, Apellido, Correo, Codigo, Telefono, TipoEmpleado_idTipoEmpleado from Employees where Activo = 1";
        }
        return "Select Cedula, Nombre, Apellido, Correo, Codigo, Telefono, TipoEmpleado_idTipoEmpleado  from Employees where Activo = 1 And (Cedula Like '%" + busqueda + "%' Or Nombre Like '%"
                + busqueda + "%' Or Apellido Like '%" + busqueda + "%' Or Correo Like '%" + busqueda + "%' Or Codigo Like '%" + busqueda + "%' Or Telefono Like '%" + busqueda + "%' Or TipoEmpleado_idTipoEmpleado "
                + "Like '%" + busqueda + "%')";
    }
}
