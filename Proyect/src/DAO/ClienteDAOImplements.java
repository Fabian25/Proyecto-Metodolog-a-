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
import java.sql.PreparedStatement;
import java.util.Random;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ClienteDAOImplements implements IClienteDAO {

    BaseDatos.Conexion cc = new BaseDatos.Conexion();
PreparedStatement preparedStatement = null;
Connection connection=null;


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
    public void registrar(TextField txtCName, TextField txtCLastNmae, TextField txtCIDnum, TextField txtCPhoneNum, TextField txtCEmail) {
          connection=BaseDatos.Conexion.conexion();
        String Cod = "";
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "CL-" + randomNum;
        if (txtCName.getText().length() == 0 || txtCLastNmae.getText().length() == 0
                || txtCIDnum.getText().length() == 0 || txtCPhoneNum.getText().length() == 0
                || txtCEmail.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
                try {
                        String sql = "Insert into Persona values(" + txtCIDnum.getText() + "," + txtCName.getText() + ","+txtCLastNmae.getText() +","
                        + txtCPhoneNum.getText() + "," + txtCEmail.getText() + "," + "Nuevo123*" + "," + Cod + "," +2+","+1  +");";
                  
                    preparedStatement=connection.prepareStatement(sql);
                    
            int upd = preparedStatement.executeUpdate();
             if (upd>0){
                   JOptionPane.showMessageDialog(null, "Error");
                }
                else {
                    
                     JOptionPane.showMessageDialog(null, "Updated Registry");
                }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
        }
        txtCName.setText("");
      txtCLastNmae.setText("");txtCIDnum.setText("");txtCPhoneNum.setText("");  txtCEmail.setText("");
 
    }

    @Override
    public void eliminar(TextField txtCIDnum) {
        Connection cn = cc.conexion();

        String Update = "UPDATE Persona \n"
                + "SET Activo = " + "0"
             
                + "WHERE IdPersona = " +txtCIDnum.getText() + ";";
        try {
            Statement stmt = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(TextField txtCName, TextField txtCLastNmae, TextField txtCPhoneNum, TextField txtCEmail, Persona p) {
        Connection cn = cc.conexion();
        String Update = "UPDATE Persona \n"
                + "SET Nombre = " + txtCName.getText()
                + "SET Apellido = " + txtCLastNmae.getText()
                + "SET Telefono = " + txtCPhoneNum.getText()
                + "SET Correo = " + txtCEmail.getText()
                + "WHERE IdPersona = " + Integer.toString(p.getCedula()) + ";";
        try {
            Statement stmt = cn.createStatement();
            PreparedStatement pst = cn.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Persona> ver() {
        Statement stm = null;
        ResultSet rs = null;
        Connection cn = cc.conexion();
        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= "+"2"  +";";
        List<Persona> listaCliente = new ArrayList<Persona>();
        try {
            cn = cc.conexion();
            stm = cn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Persona c = new Clientes();
                c.setCodigo(rs.getString(7));
                c.setCedula(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(8));
                listaCliente.add(c);
            }
            stm.close();
            rs.close();
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método obtener");
            e.printStackTrace();
        }

        return listaCliente;
    }

}
