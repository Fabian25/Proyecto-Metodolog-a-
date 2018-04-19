/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.IGeneral;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class GeneralDAOImplements implements IGeneral {

    Connection connection = BaseDatos.Conexion.getConnection();

    @Override
    public void RecuperarContrasena(String txtuser) {
        PreparedStatement preparedStatement;
        boolean x = false;
        String sql = "SELECT Employees.Cedula FROM Employees WHERE Employees.Correo =? ;" ;
        try {
            preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1,txtuser);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                x = true;
                String query = "{CALL RecuperarContraseñaEmp(?)}";
                try {
                    CallableStatement stmt = connection.prepareCall(query);
                    stmt.setInt(1, resultSet.getInt(1));

                    stmt.executeQuery();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        if (x == false) {
            sql = "SELECT Cedula FROM Clientes WHERE Correo =?;";
            try {
                preparedStatement = connection.prepareStatement(sql);
                  preparedStatement.setString(1,txtuser);
                ResultSet resultSet = preparedStatement.executeQuery();
                  while (resultSet.next()) {
                x = true;
                String query = "{CALL RecuperarContraseñaClientes(?)}";
                try {
                    CallableStatement stmt = connection.prepareCall(query);
                    stmt.setInt(1,  resultSet.getInt(1));

                    stmt.executeQuery();

                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            } catch (SQLException ex) {

            }
            if (x==false) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("EMAIL NOT EXIST");
                            alert.showAndWait();
            }else{
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("New Password");
                            alert.setHeaderText(null);
                            alert.setContentText("Your new password is: Nuevo123*");
                            alert.showAndWait();
            }
        }

    }

    @Override
    public void ActualizarContrasena(String correo) {

        String Update = "UPDATE Personas\n"
                + "SET Contraseña = nuevo123*\n"
                + "WHERE Correo = " + correo + ";";
        try {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
