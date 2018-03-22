/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class MenuClienteController implements Initializable {

    @FXML
    private Button btn_Tiquete;
    @FXML
    private Button btn_Perfil;
    @FXML
    private Button btnExit;

    private void CargarVistas(String Vista, String Titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) btn_Tiquete.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Tiquetes(ActionEvent event) {

    }

    @FXML
    private void B_Salir(MouseEvent event) {
        CargarVistas("Login", "Log In");
    }

}
