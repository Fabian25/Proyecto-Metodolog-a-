/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import Model.Clientes;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class VerPerfilClienteController implements Initializable {
    public static Clientes cliente = new Clientes();
    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();
    ClienteDAOImplements h = new ClienteDAOImplements();
    @FXML
    private TextField txtCName;
    @FXML
    private TextField txtCLastNmae;
    @FXML
    private TextField txtCIDnum;
    @FXML
    private TextField txtCPhoneNum;
    @FXML
    private TextField txtCEmail;
    @FXML
    private Button BarMyProfile;
    @FXML
    private Button BarEditProfile;
    @FXML
    private Button BarHomeC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          txtCName.setText(cliente.getNombre());
          txtCLastNmae.setText(cliente.getApellido());
          txtCIDnum.setText(Integer.toString(cliente.getCedula()));
          txtCPhoneNum.setText(Integer.toString(cliente.getTelefono()));
          txtCEmail.setText(cliente.getCorreo());
    }
       
    private void CargarVistas(String Vista, String Titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarHomeC.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private int Data() {
<<<<<<< HEAD

        String sql = "SELECT Correo FROM sql10218899.UsuarioActual";
=======
        String sql = "SELECT Correo FROM sql10218899.UsuarioActual;";
>>>>>>> 8eb9b9d20913802fc903ff874c5cb5b7fd12290c
        String datos = " ";
        int ce = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    datos = rs.getString(2);
                }
<<<<<<< HEAD

                String query = "{UsuarioActualClientes ActualizarCliente(" + datos + ")}";
                Statement st2 = connection.createStatement();
                ResultSet rs2 = st.executeQuery(sql);
                if (rs != null) {
                    ce = Integer.parseInt(query);
                }

            } else {

=======
 String query = "{UsuarioActualClientes ActualizarCliente("+datos+")}";
     Statement st2 = connection.createStatement();
            ResultSet rs2 = st.executeQuery(sql);
           if (rs != null) {
             ce=Integer.parseInt(query);
            }   
            
            }else{
            
>>>>>>> 8eb9b9d20913802fc903ff874c5cb5b7fd12290c
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ce;
    }

    @FXML
    private void C_BarMyProfile(ActionEvent event) {
        CargarVistas("VerPerfilCliente", "Profile");
    }

    @FXML
    private void C_BarEditProfile(ActionEvent event) {
        CargarVistas("EditarPerfilCliente", "Profile");
    }

    @FXML
    private void C_Home(ActionEvent event) {
        CargarVistas("MenuCliente", "Profile");
    }

}
