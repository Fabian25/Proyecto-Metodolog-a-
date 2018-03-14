/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Persona;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import IDAO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ClienteDAOImplements implements IClienteDAO {

    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();

//    public boolean ExisteCedula(String ced, String cod) {
//        Connection cn = cc.conexion();
//        String sql = "SELECT * FROM Persona p where p.IdPersona = " + ced + "and p.Codigo = " + cod + ";";
//        String[] datos = new String[10];
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString(1);
//                datos[1] = rs.getString(9);
//            }
//            if (datos[0] != null) {
//                if (datos[0].equals(ced) || datos[1].equals(cod)) {
//                    return true;
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
    @Override
    public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail) {
       
        String Cod;
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "CL-" + randomNum;
        if (txtCName.length() == 0 || txtCLastNmae.length() == 0
                || txtCIDnum.length() == 0 || txtCPhoneNum.length() == 0
                || txtCEmail.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
            try {
                String sql = "Insert into Persona values(?,?,?,?,?,?,?,?,?);";

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, txtCIDnum);
                preparedStatement.setString(2, txtCName);
                preparedStatement.setString(3, txtCLastNmae);
                preparedStatement.setString(4, txtCPhoneNum);
                preparedStatement.setString(5, txtCEmail);
                preparedStatement.setString(6, "nuevo123");
                preparedStatement.setString(7, Cod);
                preparedStatement.setString(8, "3");
                preparedStatement.setString(9, "1");

                int executeUpdate = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        

      
    }

    @Override
    public void eliminar(TextField txtCIDnum) {
//        Connection cn = cc.conexion();
//
//        String Update = "UPDATE Persona \n"
//                + "SET Activo = " + "0"
//             
//                + "WHERE IdPersona = " +txtCIDnum.getText() + ";";
//        try {
//            Statement stmt = cn.createStatement();
//            PreparedStatement pst = cn.prepareStatement(Update);
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
    }

    @Override
    public void actualizar(TextField txtCName, TextField txtCLastNmae, TextField txtCPhoneNum, TextField txtCEmail, Persona p) {
//        Connection cn = cc.conexion();
//        String Update = "UPDATE Persona \n"
//                + "SET Nombre = " + txtCName.getText()
//                + "SET Apellido = " + txtCLastNmae.getText()
//                + "SET Telefono = " + txtCPhoneNum.getText()
//                + "SET Correo = " + txtCEmail.getText()
//                + "WHERE IdPersona = " + Integer.toString(p.getCedula()) + ";";
//        try {
//            Statement stmt = cn.createStatement();
//            PreparedStatement pst = cn.prepareStatement(Update);
//            pst.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

    }

    @Override
    public List<Persona> ver() {
//        Statement stm = null;
//        ResultSet rs = null;
//        Connection cn = cc.conexion();
//        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= "+"2"  +";";
//        List<Persona> listaCliente = new ArrayList<Persona>();
//        try {
//            cn = cc.conexion();
//            stm = cn.createStatement();
//            rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                Persona c = new Clientes();
//                c.setCodigo(rs.getString(7));
//                c.setCedula(rs.getInt(1));
//                c.setNombre(rs.getString(2));
//                c.setApellido(rs.getString(8));
//                listaCliente.add(c);
//            }
//            stm.close();
//            rs.close();
//            cn.close();
//        } catch (SQLException e) {
//            System.out.println("Error: Clase ClienteDaoImple, método obtener");
//            e.printStackTrace();
//        }
//
//        return listaCliente;
        return null;
    }

    @Override
    public ObservableList<Persona> Personas() {
        ObservableList<Persona> personas = FXCollections.observableArrayList();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select IdPersona, Nombre, Apellido, Telefono, Correo from Persona where TipoPersona = 3");
            while (rs.next()) {
                personas.add(new Persona(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), "", "") {
                    @Override
                    public String verPersona() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Cliente \n" + ex);
        }
        return personas;
    }

}
