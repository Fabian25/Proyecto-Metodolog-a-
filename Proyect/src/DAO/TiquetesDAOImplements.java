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
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    private String GenerarCodigoTiquete(String Cod) {
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "T-" + randomNum;
        return Cod;
    }

    private boolean ExisteCodigoTiquete(String cod) {
        String sql = "SELECT * FROM Tiquetes t where t.idTiquete = " + cod + ";";
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
        GenerarCodigoTiquete(Cod);
        while (ExisteCodigoTiquete(Cod)) {
            Cod = GenerarCodigoTiquete(Cod);
        }
        String query = "{CALL RegistrarTiquete(?,?,?,?,?)}";
        try (Connection conn = BaseDatos.Conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, Cod);
            stmt.setString(2, txt_Series.getText());
            stmt.setString(3, (String) txt_Status.getValue());
            stmt.setString(4, txt_description.getText());
            stmt.setInt(5, 1);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Tiquetes> Tiquetes(String busqueda) {
        ObservableList<Tiquetes> Tiquetes = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLTiquetes(busqueda));
            while (rs.next()) {
                Tiquetes.add(new Tiquetes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), ""));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Tiquetes \n" + ex);
        }
        return Tiquetes;
    }

    private String SQLTiquetes(String busqueda) {
        if (busqueda.equals("")) {
            return "Select idTiquetes, Prioridad_idPrioridad, Descripcion, Estado from Tiquetes where Activo = 1;";
        }
        return "Select idTiquetes, Prioridad_idPrioridad, Descripcion, Estado from Tiquetes where Activo = 1 And (idTiquetes Like '%" + busqueda + "%' Or Prioridad_idPrioridad Like '%"
                + busqueda + "%' Or Descripcion Like '%" + busqueda + "%' Or Estado Like '%" + busqueda + "%')";

    }

    @Override
    public void EditarTiquetes(ComboBox<?> txt_Status, TextArea txt_description, Tiquetes t) {
        String query = "{CALL EditarTiquete(?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, t.getID_Tiquete());
            stmt.setString(2, (String) txt_Status.getValue());
            stmt.setString(3, txt_description.getText());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void procesarTiquete(ComboBox<?> txt_Status, TextArea txt_description, TextArea txt_solution, Tiquetes tiquete) {
        String query = "{CALL ProcesoTiquete(?, ?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, tiquete.getID_Tiquete());
            stmt.setString(2, (String) txt_Status.getValue());
            stmt.setString(3, (String) txt_description.getText());
            stmt.setString(4, txt_solution.getText());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void asignarTiquete(Tiquetes tiquete, Empleados empleado) {
        String query = "{CALL TiqueteAsginar(?, ?, 0)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, empleado.getCedula());
            stmt.setString(2, tiquete.getID_Tiquete());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminarTiquetes(Tiquetes tiquete) {
        String query = "{CALL EliminarTiquetes(?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, tiquete.getID_Tiquete());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Tiquetes> obtenerporEmpleado(Empleados emp) {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Tiquetes WHERE Empleado_LaborandoID =" + emp.getCodigo() + ";";
        List<Tiquetes> listaTiquete = new ArrayList<Tiquetes>();
        try {
            stm = connection.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tiquetes c = new Tiquetes();
                c.setEstado(rs.getInt(3));
                c.setID_Tiquete(rs.getString(1));
                c.setPrioridad(rs.getString(6));
                listaTiquete.add(c);
            }
            stm.close();
            rs.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: Class TiqueteDaoImple, method: obtenerporEmpleado");
            e.printStackTrace();
        }
        return listaTiquete;
    }

    @Override
    public List<Tiquetes> ver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Tiquetes> TiquetesEdit(String busqueda) {
        ObservableList<Tiquetes> Tiquetes = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLTiquetesEdit(busqueda));
            while (rs.next()) {
                Tiquetes.add(new Tiquetes(rs.getString(1), "","", rs.getInt(2), ""));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Tiquetes \n" + ex);
        }
        return Tiquetes;
    }
 private String SQLTiquetesEdit(String busqueda) {
        if (busqueda.equals("")) {
            return "Select idTiquetes, Estado from Tiquetes where Activo = 1;";
        }
        return "Select idTiquetes, Estado from Tiquetes where Activo = 1 And (idTiquetes Like '%" + busqueda + "%' Or  Estado Like '%" + busqueda + "%')";

    }
}
