/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.IEmpresaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class EmpresaDAOImplements implements IEmpresaDAO {

    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();

    private String CrearCodigo() {
        String codigo = "EMP-" + Integer.toString((int) (Math.random() * 9) + 1) + Integer.toString((int) (Math.random() * 9) + 1)
                + Integer.toString((int) (Math.random() * 9) + 1);
        return codigo;
    }

   

    @Override
    public void registrarEmp(String txt_EntrepriceName, String txt_Acronym, String txt_Phone) {

        if (txt_EntrepriceName.length() == 0 || txt_Acronym.length() == 0
                || txt_Phone.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
            try {
                String sql = "Insert into Empresas values(?,?,?,?,?,?,?);";

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, CrearCodigo());
                preparedStatement.setString(2, txt_EntrepriceName);
                preparedStatement.setString(3, txt_Acronym);
                preparedStatement.setString(4, txt_Phone);
                preparedStatement.setString(5, "1");
                preparedStatement.setString(6, "12354");
                preparedStatement.setString(7, "3");

                int executeUpdate = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

}
