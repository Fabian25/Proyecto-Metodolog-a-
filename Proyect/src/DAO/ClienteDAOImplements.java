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
import Model.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.layout.HBox;

public class ClienteDAOImplements implements IClienteDAO {

    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();

    private boolean ExisteCedula(String ced) {

        String sql = "SELECT * FROM Clientes p where p.IdPersona = " + ced + ";";
        String[] datos = new String[10];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    datos[0] = rs.getString(1);
                }
                if (datos[0] != null) {
                    if (datos[0].equals(ced)) {
                        return true;
                    }
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean ExisteCodigo(int cod) {

        String sql = "SELECT * FROM Clientes p where p.Codigo = " + cod + ";";
        String[] datos = new String[10];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    datos[0] = rs.getString(5);
                }
                return datos[0].equals(cod);

            }

        } catch (SQLException ex) {
        }
        return false;
    }

    private int GenerarCodigo(int Cod) {

        Random rand = new Random();
        int randomNum = rand.nextInt((9999999 - 1000000) + 1) + 100;
        Cod = randomNum;
        return Cod;

    }

    @Override
    public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail) {

        int Cod = 0;
        GenerarCodigo(Cod);

        while (ExisteCodigo(Cod)) {
            GenerarCodigo(Cod);
        }
        if (ExisteCedula(txtCIDnum)) {
            JOptionPane.showMessageDialog(null, "There is already a client with this id");
        } else {

            if (txtCName.length() == 0 || txtCLastNmae.length() == 0
                    || txtCIDnum.length() == 0 || txtCPhoneNum.length() == 0
                    || txtCEmail.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
            } else {
                try {
                    String sql = "Insert into Clientes values(?,?,?,?,?,?,?,?,?);";

                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, txtCIDnum);
                    preparedStatement.setString(2, txtCName);
                    preparedStatement.setString(3, txtCLastNmae);
                    preparedStatement.setString(4, txtCEmail);
                    preparedStatement.setString(5, "Nuevo123$");
                    preparedStatement.setInt(6, Cod);
                    preparedStatement.setString(7, txtCPhoneNum);
                    preparedStatement.setInt(8, 1);

                    int executeUpdate = preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
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
    public ObservableList<Clientes> Clientes() {
        ObservableList<Clientes> Clientes = FXCollections.observableArrayList();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select Codigo, Empresa_idEmpresa, Cedula, Nombre, Apellido, Telefono, Correo from Clientes where Activo = 1");
            while (rs.next()) {
                Clientes.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), "", new Button("X")) {
                    @Override
                    public String verPersona() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Cliente \n" + ex);
        }
        return Clientes;
    }

}
