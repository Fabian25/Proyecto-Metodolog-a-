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
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import javax.swing.JOptionPane;

import javafx.scene.layout.HBox;

public class ClienteDAOImplements implements IClienteDAO {

    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();
   

    private boolean ExisteCedula(String ced) {

        String sql = "SELECT * FROM Clientes p where p.Cedula = " + ced + ";";
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

        int[] datos = new int[10];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    datos[0] = rs.getInt(6);
                }
            }

            if (datos[0] == cod) {
                return true;
            }
            return false;

        } catch (SQLException ex) {

        }
        return false;
    }

    private int GenerarCodigo() {
        int Cod;

        Random rand = new Random();
        int randomNum = rand.nextInt((9999999 - 1000000) + 1) + 100;
        Cod = randomNum;
        return Cod;

    }

    @Override
    public void registrar(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail) {

        int Cod = GenerarCodigo();

        while (ExisteCodigo(Cod)) {
            Cod = GenerarCodigo();

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
                    preparedStatement.setString(9, "ENT-001");

                    int executeUpdate = preparedStatement.executeUpdate();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }

    }

//    @Override
//    public void eliminar(TextField txtCIDnum) {
////        Connection cn = cc.conexion();
////
////        String Update = "UPDATE Persona \n"
////                + "SET Activo = " + "0"
////             
////                + "WHERE IdPersona = " +txtCIDnum.getText() + ";";
////        try {
////            Statement stmt = cn.createStatement();
////            PreparedStatement pst = cn.prepareStatement(Update);
////            pst.executeUpdate();
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
//    }
//    @Override
//    public void actualizar(TextField txtCName, TextField txtCLastNmae, TextField txtCPhoneNum, TextField txtCEmail, Persona p) {
////        Connection cn = cc.conexion();
////        String Update = "UPDATE Persona \n"
////                + "SET Nombre = " + txtCName.getText()
////                + "SET Apellido = " + txtCLastNmae.getText()
////                + "SET Telefono = " + txtCPhoneNum.getText()
////                + "SET Correo = " + txtCEmail.getText()
////                + "WHERE IdPersona = " + Integer.toString(p.getCedula()) + ";";
////        try {
////            Statement stmt = cn.createStatement();
////            PreparedStatement pst = cn.prepareStatement(Update);
////            pst.executeUpdate();
////        } catch (SQLException e) {
////            System.out.println(e.getMessage());
////        }
//
//    }
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

    //
    //    public void registrar(Clientes h) {
    //        int Cod = 0;
    //        GenerarCodigo(Cod);
    //
    //        while (ExisteCodigo(Cod)) {
    //            GenerarCodigo(Cod);
    //        }
    //        if (ExisteCedula(Integer.toString(h.getCedula()))) {
    //            JOptionPane.showMessageDialog(null, "There is already a client with this id");
    //        } else {
    //
    //            if (h.getNombre().length() == 0 || h.getApellido().length() == 0
    //                    || Integer.toString(h.getCedula()).length() == 0 || Integer.toString(h.getTelefono()).length() == 0
    //                    || h.getCorreo().length() == 0) {
    //                JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
    //            } else {
    //                try {
    //                    String sql = "Insert into Clientes values(?,?,?,?,?,?,?,?,?);";
    //
    //                    preparedStatement = connection.prepareStatement(sql);
    //                    preparedStatement.setString(1, Integer.toString(h.getCedula()));
    //                    preparedStatement.setString(2, h.getNombre());
    //                    preparedStatement.setString(3, h.getApellido());
    //                    preparedStatement.setString(4, h.getCorreo());
    //                    preparedStatement.setString(5, "Nuevo123$");
    //                    preparedStatement.setInt(6, Cod);
    //                    preparedStatement.setString(7, Integer.toString(h.getTelefono()));
    //                    preparedStatement.setInt(8, 1);
    //
    //                    int executeUpdate = preparedStatement.executeUpdate();
    //
    //                } catch (SQLException ex) {
    //                    JOptionPane.showMessageDialog(null, ex);
    //                }
    //            }
    //        }
    public ObservableList<Clientes> Clientes(String busqueda) {
        ObservableList<Clientes> Clientes = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLClientes(busqueda));
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

    private String SQLClientes(String busqueda) {
        if (busqueda.equals("")) {
            return "Select Codigo, Empresa_idEmpresa, Cedula, Nombre, Apellido, Telefono, Correo from Clientes where Activo = 1";
        }
        return "Select Codigo, Empresa_idEmpresa, Cedula, Nombre, Apellido, Telefono, Correo from Clientes where Activo = 1 And (Codigo Like '%" + busqueda + "%' Or Empresa_idEmpresa Like '%"
                + busqueda + "%' Or Cedula Like '%" + busqueda + "%' Or Nombre Like '%" + busqueda + "%' Or Apellido Like '%" + busqueda + "%' Or Telefono Like '%" + busqueda + "%' Or Correo "
                + "Like '%" + busqueda + "%')";
    }

    @Override
    public Clientes obtenerCliente(Clientes h) {
        return h;

    }

    @Override
    public void actualizar(String txtCPhoneNum, String txtCName, int Cedula) {
        String query = "{CALL ActualizarCliente(?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, Integer.parseInt(txtCPhoneNum));
            stmt.setString(2, txtCName);
            stmt.setInt(3, Cedula);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "{CALL EliminarClientes(?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, id);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void registrarStorage(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail) {

        int Cod = GenerarCodigo();

        while (ExisteCodigo(Cod)) {
            Cod = GenerarCodigo();

        }
        if (ExisteCedula(txtCIDnum)) {
            JOptionPane.showMessageDialog(null, "There is already a client with this id");
        } else {

            String query = "{CALL RegistrarCliente(?,?,?,?,?,?,?,?,?)}";

            try (CallableStatement stmt = connection.prepareCall(query)) {

                stmt.setString(1, txtCIDnum);
                stmt.setString(2, txtCName);
                stmt.setString(3, txtCLastNmae);
                stmt.setString(4, txtCEmail);
                stmt.setString(5, "Nuevo123$");
                stmt.setInt(6, Cod);
                stmt.setString(7, txtCPhoneNum);
                stmt.setInt(8, 1);
                stmt.setString(9, "ENT-001");

                stmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    @Override
    public Clientes VerInfCliente(String txt_Usuario, String txt_Contrasena) {
        Clientes Cliente = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select Codigo, Empresa_idEmpresa, Cedula, Nombre, Apellido, "
                + "Telefono, Correo from Clientes where Correo = '" + txt_Usuario + "' And Contraseña = '"
                + txt_Contrasena + "'");
            while (rs.next()) {
             Cliente = new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), "", new Button("X"));
            }
        } catch (SQLException ex) {

        }
        return Cliente;
    }
}
