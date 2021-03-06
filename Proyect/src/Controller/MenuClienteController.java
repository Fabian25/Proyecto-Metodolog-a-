/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author jose
 */
public class MenuClienteController implements Initializable {

    @FXML
    private Button btnExit;
    @FXML
    private Button btn_Perfil;
    @FXML
    private Button btn_Tiquete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            Stage act = (Stage) btn_Tiquete.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void B_Salir(MouseEvent event) throws SQLException {
                  Connection connection = BaseDatos.Conexion.getConnection();
           PreparedStatement preparedStatement;
         String sql2 = "Delete from  UsuarioActual where CantidadUsuarios = 1;";
                              preparedStatement = connection.prepareStatement(sql2);
                              int resultSet2 = preparedStatement.executeUpdate();
        CargarVistas("Login", "Log In");
    }

    @FXML
    private void Profile(ActionEvent event) {
        CargarVistas("VerPerfilCliente", "Profile");
    }

    @FXML
    private void Tiquetes(ActionEvent event) {
        CargarVistas("CrearTiquete", "Tickets");
    }

}
