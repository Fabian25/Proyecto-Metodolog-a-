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
import Model.Empleados;
import IDAO.IEmpleadoDAO;
import Model.Tiquetes;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
public class EmpleadoDAOImplements implements IEmpleadoDAO {

    Connection connection = BaseDatos.Conexion.getConnection();

    private boolean ExisteCedula(String ced) {

        String sql = "SELECT * FROM Employees p where p.Cedula = " + ced + ";";
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

    public boolean ExisteCedula(String ced, String cod) {
        String sql = "SELECT * FROM Persona p where p.IdPersona = " + ced + "and p.Codigo = " + cod + ";";
        String[] datos = new String[10];
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(9);
            }
            if (datos[0] != null) {
                if (datos[0].equals(ced) || datos[1].equals(cod)) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void registrar(String txt_Name, String txt_Phone, String txt_ID, String txt_LastName, String txt_Email) {
        String Cod = "";
        Random rand = new Random();
        int randomNum = rand.nextInt((999 - 100) + 1) + 100;
        Cod = "EMP-" + randomNum;
        if (txt_Name.length() == 0 || txt_LastName.length() == 0
                || txt_ID.length() == 0 || txt_Phone.length() == 0
                || txt_Email.length() == 0) {
            JOptionPane.showMessageDialog(null, "Please do not left empty textfields");
        } else {
            if (ExisteCedula(txt_ID, Cod) == false) {

                String sql = "Insert into Persona values(" + txt_ID + "," + txt_Name + ","
                        + txt_Phone + "," + txt_Email + "," + "Nuevo123*" + "," + Cod + "," + txt_LastName + ");";
                String[] datos = new String[10];
                try {
                    Statement stmt = connection.createStatement();
                    PreparedStatement pst = connection.prepareStatement(sql);
                    pst.executeUpdate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "The user alredy exists");
            }
        }
    }

    @Override
    public void eliminar(TextField txt_ID) {
        String Update = "UPDATE Personas\n"
                + "SET Activo = " + "0"
                + "WHERE IdPersona = " + txt_ID.getText() + ";";
        try {
            Statement stmt = connection.createStatement();
            PreparedStatement pst = connection.prepareStatement(Update);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(TextField txt_Name, TextField txt_Phone, TextField txt_LastName, TextField txt_Email, Persona p) {

        String query = "{CALL ActualizarEmpleado(?, ?, ?, ?, ?)}";
        try (Connection conn = BaseDatos.Conexion.getConnection();
                CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, txt_Name.getText());
            stmt.setString(2, txt_LastName.getText());
            stmt.setInt(3, Integer.parseInt(txt_Phone.getText()));
            stmt.setString(4, txt_Email.getText());
            stmt.setInt(4, p.getCedula());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Persona> ver() {

//  Statement stm = null;
//        ResultSet rs = null;
//        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= "+"2"  +";";
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Persona where TipoPersona_ID_TipoPersona= " + "2" + ";";

        List<Persona> listaCliente = new ArrayList<Persona>();
//        try {
//            stm = connection.createStatement();
//            rs = stm.executeQuery(sql);
//            while (rs.next()) {
//                Persona c = new Empleados();
//                c.setCodigo(rs.getString(7));
//                c.setCedula(rs.getInt(1));
//                c.setNombre(rs.getString(2));
//                c.setApellido(rs.getString(8));
//                listaCliente.add(c);
//            }
//            stm.close();
//            rs.close();
//            connection.close();
//        } catch (SQLException e) {
//            System.out.println("Error: Clase ClienteDaoImple, método obtener");
//            e.printStackTrace();
//        }

        return listaCliente;
    }

    @Override
    public void actualizar(String txtName, String txtLastName, int txtPhone, int Cedula) {
        String query = "{CALL ActualizarEmpleado(?, ?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, txtName);
            stmt.setString(2, txtLastName);
            stmt.setInt(3, txtPhone);
            stmt.setInt(4, Cedula);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(int id) {
        String query = "{CALL EliminarEmpleado(?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, id);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Empleados> Empleados(String busqueda, int Cond) {
        ObservableList<Empleados> emp = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLEmpleado(busqueda, Cond));
            while (rs.next()) {
                emp.add(new Empleados(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), " ", new Button("X")) {
                    @Override
                    public String verPersona() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Cargar Empleados \n" + ex);
        }
        return emp;
    }

    private String SQLEmpleado(String busqueda, int Cond) {
        if (busqueda.equals("")) {
            return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 and TipoEmpleado_idTipoEmpleado = 2";
        } else {
            switch (Cond) {
                case 1:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Codigo Like '%" + busqueda + "%')";
                case 2:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Cedula Like '%" + busqueda + "%')";
                case 3:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Nombre Like '%" + busqueda + "%')";
                case 4:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Apellido Like '%" + busqueda + "%')";
                case 5:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Telefono Like '%" + busqueda + "%')";
                case 6:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Correo Like '%" + busqueda + "%')";
                default:
                    return "Select Codigo, Cedula, Nombre, Apellido, Telefono, Correo  from Employees where Activo = 1 And (Codigo Like '%" + busqueda + "%' Or Cedula Like '%"
                            + busqueda + "%' Or Nombre Like '%" + busqueda + "%' Or Apellido Like '%" + busqueda + "%' Or Telefono Like '%" + busqueda + "%' Or Correo "
                            + "Like '%" + busqueda + "%')";
            }
        }
    }

    @Override
    public void registrarStorage(String txtCName, String txtCLastNmae, String txtCIDnum, String txtCPhoneNum, String txtCEmail) {
        int Cod = GenerarCodigo();

        while (ExisteCodigo(Cod)) {
            Cod = GenerarCodigo();

        }
        if (ExisteCedula(txtCIDnum)) {
            JOptionPane.showMessageDialog(null, "There is already a employee with this id");
        } else {

            String query = "{CALL RegistrarEmpleado(?,?,?,?,?,?,?,?,?)}";

            try (CallableStatement stmt = connection.prepareCall(query)) {

                stmt.setString(1, txtCIDnum);
                stmt.setString(2, txtCName);
                stmt.setString(3, txtCLastNmae);
                stmt.setString(4, txtCEmail);
                stmt.setInt(5, Cod);
                stmt.setString(6, txtCPhoneNum);

                stmt.setString(7, "Nuevo123$");
                stmt.setInt(8, 1);
                stmt.setInt(9, 2);
                stmt.executeQuery();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    @Override
    public ObservableList<Tiquetes> Tiquetes(String busqueda) {
        ObservableList<Tiquetes> tiquetes = FXCollections.observableArrayList();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQLTiquetes(busqueda));
            while (rs.next()) {
                tiquetes.add(new Tiquetes(rs.getString(1), rs.getString(5), rs.getString(3),
                        rs.getString(2), rs.getString(4), rs.getInt(6), 0, rs.getInt(7)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return tiquetes;
    }

    private String SQLTiquetes(String busqueda) {
        if (busqueda.equals("")) {
            return "select * from Tiquetes";
        }
        return "";
    }

    @Override
    public void procesarTiquete(int cb_status, String txt_Solution, Tiquetes tiquete) {
        String query = "{CALL ProcesarTiquete(?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setInt(1, cb_status);
            stmt.setString(2, txt_Solution);
            stmt.setString(3, tiquete.getID_Tiquete());
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Empleados VerInfEmpleado(String txt_Usuario, String txt_Contrasena) {
        Empleados Empleado = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select Cedula, Nombre, Apellido, Correo, Codigo, Telefono, Contraseña, Activo, TipoEmpleado_idTipoEmpleado from Employees where "
                    + "Correo = '" + txt_Usuario + "' And Contraseña = '" + txt_Contrasena + "'");
            while (rs.next()) {
                Empleado = new Empleados(rs.getString(5), rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(6), rs.getString(4), rs.getString(7), new Button("X"));
            }
        } catch (SQLException ex) {

        }
        return Empleado;
    }

    @Override
    public void ActualizarInfEmp(String txt_Name, String txt_LastName, int txt_Phone, int Cedula) {
        String query = "{CALL ActualizarEmpleado(?, ?, ?, ?)}";
        try {
            CallableStatement stmt = connection.prepareCall(query);
            stmt.setString(1, txt_Name);
            stmt.setString(2, txt_LastName);
            stmt.setInt(3, txt_Phone);
            stmt.setInt(4, Cedula);
            stmt.executeQuery();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
