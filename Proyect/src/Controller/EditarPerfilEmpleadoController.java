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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class EditarPerfilEmpleadoController implements Initializable {

    @FXML
    private Button btnADD;
    @FXML
    private TextField txtCPhoneNum;
    @FXML
    private TextField txtCLastNmae;
    @FXML
    private TextField txtCName;
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
            Stage act = (Stage) BarMyProfile.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void c_add(MouseEvent event) {
    }

    @FXML
    private void C_BarMyProfile(ActionEvent event) {
         CargarVistas("VerPerfilEmpleado", "Profile");
    }

    @FXML
    private void C_BarEditProfile(ActionEvent event) {
          CargarVistas("EditarPerfilEmpleado", "Profile");
    }

    @FXML
    private void C_Home(ActionEvent event) {
         CargarVistas("MenuEmpleado", "Home");
    }
    
    
}
