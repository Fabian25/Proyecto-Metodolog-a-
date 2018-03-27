/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import IDAO.IEmpresaDAO;
import Model.Clientes;
import Model.Empresa;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;

/**
 *
 * @author erick
 */
public class EmpresaDAOImplements implements IEmpresaDAO {

    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();

    private String CrearCodigo() {
        String codigo = "ENT-" + Integer.toString((int) (Math.random() * 9) + 1) + Integer.toString((int) (Math.random() * 9) + 1)
                + Integer.toString((int) (Math.random() * 9) + 1);
        return codigo;
    }

    @Override
    public void registrarEmp(String txt_EntrepriceName, String txt_Acronym, String txt_Phone) {

        String query = "{CALL RegistrarEmpresa(?,?,?,?,?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);

            stmt.setString(1, CrearCodigo());
            stmt.setString(2, txt_EntrepriceName);
            stmt.setString(3, txt_Acronym);
            stmt.setString(4, txt_Phone);
            stmt.setInt(5, 1);

            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Empresa> Empresa() {
        ObservableList<Empresa> Empresa = FXCollections.observableArrayList();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select idEmpresa, Nombre, Acronimo, Telefono, Activo from Empresa");
            while (rs.next()) {
                Empresa.add(new Empresa(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Empresa \n" + ex);
        }
        return Empresa;
    }
    
    @Override
    public void Modificar(String txt_EntrepriceName, String txt_Acronym, String txt_Phone, String idEmpresa) {
        String query = "{CALL ActualizarEmpresa(?, ?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, txt_EntrepriceName);
            stmt.setString(2, txt_Acronym);
            stmt.setString(3, txt_Phone);
            stmt.setString(4, idEmpresa);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
