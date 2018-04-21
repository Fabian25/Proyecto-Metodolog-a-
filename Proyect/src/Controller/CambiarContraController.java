/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Fabian
 */
public class CambiarContraController implements Initializable {

    @FXML
    private TextField txt_NewPassword;
    @FXML
    private TextField txt_ConfirmPassword;
    @FXML
    private Button btn_Ingresar;
    @FXML
    private Button BarMyProfile;
    @FXML
    private Button BarEditProfile;
    @FXML
    private Button BarEditPassword;
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
            Stage act = (Stage) BarHomeC.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void Ingresar(ActionEvent event) {
        if (!"".equals(txt_NewPassword.getText()) && !"".equals(txt_ConfirmPassword.getText()) && txt_ConfirmPassword.getText().equals(txt_NewPassword.getText()) && !txt_ConfirmPassword.getText().isEmpty() && !txt_NewPassword.getText().isEmpty()) {

            ClienteDAOImplements h = new ClienteDAOImplements();
            h.ActualizarContraClientes(LoginController.infClient.getCedula(), txt_ConfirmPassword.getText());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("The password has been updated");
            alert.showAndWait();

            txt_ConfirmPassword.setText("");
            txt_NewPassword.setText("");

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Contraseña incorrecta");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite la contraseña correctamente en los campos solicitados");
            alert.showAndWait();
        }
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

    @FXML
    private void C_BarEditPassword(ActionEvent event) {
        CargarVistas("CambiarContra", "Profile");
    }

}
