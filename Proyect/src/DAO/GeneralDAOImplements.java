/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import IDAO.IGeneral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class GeneralDAOImplements implements IGeneral{

     Connection connection =  BaseDatos.Conexion.getConnection();

    @Override
    public void LogIn(TextField txtuser, PasswordField txtpass) {
        int Type = 0;
        if (txtuser.getText().length() == 0 || txtpass.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
         
            String pass = new String(txtpass.getText());
            String sql = "SELECT * FROM Persona p where p.Correo = " + txtuser.getText() + " and p.Contraseña = '" + pass + "';";
            String[] datos = new String[10];
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(4);//correo
                    datos[1] = rs.getString(6);//contraseña
                    datos[2] = rs.getString(10);//tipoPersona
                }
                if (datos[0] != null) {
                    if (datos[0].equals(txtuser.getText()) && datos[1].equals(pass)) {
                        Type = Integer.parseInt(datos[2]);
                        switch (Type) {
                            case 1: {
                                //View.MenuAdmin admin= new View.MenuAdmin();
                                // admin.setLocationRelativeTo(null);
                                // admin.setVisible(true);
                                //Login.dispose();
                                break;
                            }
                            case 2: {
                                //View.MenuClient  client= new View.MenuClient ();
                                //client.setLocationRelativeTo(null);
                                //client.setVisible(true);
                                //Login.dispose();
                                break;
                            }
                            case 3: {
                                //View.MenuEmployee employee= new View.MenuEmployee  ();
                                //employee.setLocationRelativeTo(null);
                                //employee.setVisible(true);
                                //Login.dispose();
                                break;
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong User or password");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    @Override
    public void RecuperarContrasena(TextField txtuser) {
        if (txtuser.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
            
            String sql = "SELECT * FROM Persona p where p.Correo = " + txtuser.getText() + "';";
            String[] datos = new String[10];
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    datos[0] = rs.getString(4);//correo
                    datos[2] = rs.getString(10);//tipoPersona
                }
                if (datos[0] != null) {
                    if (datos[0].equals(txtuser.getText())) {
                        ActualizarContrasena(txtuser.getText());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong Username");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
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
