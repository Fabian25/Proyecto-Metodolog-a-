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
import static Controller.LoginController.infClient;
import IDAO.*;
import Model.Clientes;
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

    private String GenerarCodigoTiquete() {
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        return "T-" + randomNum;
    }

    private boolean ExisteCodigoTiquete(String cod) {
        String sql = "SELECT * FROM Tiquetes t where t.idTiquetes = '" + cod + "'";
        String datos = "";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos = rs.getString(9);
            }
            if (!datos.equals("")) {
                if (datos.equals(cod)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    @Override
    public String registrarTiquetes(int cbx_Priority, String txt_description) {
        String Cod = GenerarCodigoTiquete();
        while (ExisteCodigoTiquete(Cod)) {
            Cod = GenerarCodigoTiquete();
        }
        String query = "{CALL RegistrarTiquete(?,?,?,?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, Cod);
            stmt.setInt(2, 1);
            stmt.setString(3, txt_description);
            stmt.setInt(4, cbx_Priority);

            stmt.executeQuery();
            return Cod;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public ObservableList<Tiquetes> Tiquetes(String busqueda) {
        ObservableList<Tiquetes> Tiquetes = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLTiquetes(busqueda));
            while (rs.next()) {

//                Tiquetes.add(new Tiquetes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
                Tiquetes.add(new Tiquetes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 0, 0, 0));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Tiquetes \n" + ex);
        }
        return Tiquetes;
    }
    
    
      @Override
    public ObservableList<Tiquetes> TiquetesClientes(String busqueda) {
        ObservableList<Tiquetes> Tiquetes = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLTiquetesCliente(busqueda,infClient));
            while (rs.next()) {

//                Tiquetes.add(new Tiquetes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
                Tiquetes.add(new Tiquetes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), 0, 0, 0));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Tiquetes \n" + ex);
        }
        return Tiquetes;
    }
    
    private String SQLTiquetesCliente(String busqueda,Clientes info) {
        if (busqueda.equals("")) {
//            return "Select * where Activo = 1";
            return "Select idTiquetes, Prioridad_idPrioridad, Descripcion, Estado, Solucion from Tiquetes where Clientes_Cedula = "+info.getCedula()+" And Activo = 1;";
        }
        return "Select idTiquetes, Prioridad_idPrioridad, Descripcion, Estado, Solucion from Tiquetes where Activo = 1 And (idTiquetes Like '%" + busqueda + "%' Or Prioridad_idPrioridad Like '%"
                + busqueda + "%' Or Descripcion Like '%" + busqueda + "%' Or Estado Like '%" + busqueda + "%' Or Solucion Like '%" + busqueda + "%') And Clientes_Cedula = "+info.getCedula()+";";

    }
    
    
    
    
    

    private String SQLTiquetes(String busqueda) {
        if (busqueda.equals("")) {
//            return "Select * where Activo = 1";
            return "Select idTiquetes, Prioridad_idPrioridad, Descripcion, Estado, Solucion from Tiquetes where Activo = 1;";
        }
        return "Select idTiquetes, Prioridad_idPrioridad, Descripcion, Estado, Solucion from Tiquetes where Activo = 1 And (idTiquetes Like '%" + busqueda + "%' Or Prioridad_idPrioridad Like '%"
                + busqueda + "%' Or Descripcion Like '%" + busqueda + "%' Or Estado Like '%" + busqueda + "%' Or Solucion Like '%" + busqueda + "%')";

    }

    @Override
    public void EditarTiquetes(ComboBox<?> txt_Status, TextArea txt_description, Tiquetes t) {
        String query = "{CALL ActualizarTiqueteAdmin(?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, t.getID_Tiquete());
              stmt.setString(2, txt_description.getText());
            stmt.setString(3, (String) txt_Status.getValue());
          
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
        String query = "{CALL TiqueteAsginar(?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, empleado.getCedula());
            stmt.setString(2, tiquete.getID_Tiquete());
            stmt.setInt(3, 0);
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
                c.setEstado(rs.getString(3));
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
    public void eliminar(String id) {
        String query = "{CALL EliminarTiqutes(?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, id);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void actualizar(String txtSerie, int txtstatus, String txtdescripcion, Tiquetes tiquete) {
        String query = "{CALL ActualizarTiqueteAdmin(?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, txtSerie);
            stmt.setInt(3, txtstatus);
            stmt.setString(2, txtdescripcion);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Tiquetes VerTiquetesCliente(String txt_Usuario) {
     Tiquetes Cliente = null;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select Codigo from Clientes where Correo = '" + txt_Usuario);
            while (rs.next()) {
               Cliente = new Tiquetes(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),  rs.getInt(7),  rs.getInt(8));
            // Cliente = new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), "", new Button("X"));
            }
        } catch (SQLException ex) {

        }

//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery("Select Codigo from Clientes where Correo = '" + txt_Usuario);
//            while (rs.next()) {
//               Cliente = new Tiquetes
//            // Cliente = new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), "", new Button("X"));
//            }

        return Cliente;

    }

}
