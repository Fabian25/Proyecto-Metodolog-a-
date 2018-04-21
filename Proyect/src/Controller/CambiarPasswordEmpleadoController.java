/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpleadoDAOImplements;
import java.net.URL;
import java.security.Key;
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
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author Fabian
 */
public class CambiarPasswordEmpleadoController implements Initializable {

    @FXML
    private TextField txt_ConfirmPassword;
    @FXML
    private TextField txt_NewPassword;
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

    public String Encriptar(String pass) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        Key key = keyGenerator.generateKey();

        key = new SecretKeySpec("una clave de 16 bytes".getBytes(), 0, 16, "AES");

        String texto = pass;

        Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

        aes.init(Cipher.ENCRYPT_MODE, key);
        byte[] encriptado = aes.doFinal(texto.getBytes());
        String w = " ";
        for (byte b : encriptado) {
            w += Integer.toHexString(0xFF & b);

        }
        return w;
    }

    @FXML
    private void Ingresar(ActionEvent event) throws Exception {
        if (!"".equals(txt_NewPassword.getText()) && !"".equals(txt_ConfirmPassword.getText()) && txt_ConfirmPassword.getText().equals(txt_NewPassword.getText()) && !txt_ConfirmPassword.getText().isEmpty() && !txt_NewPassword.getText().isEmpty()) {

            EmpleadoDAOImplements h = new EmpleadoDAOImplements();

            h.ActualizarContraEmpleado(LoginController.infEmpleado.getCedula(),Encriptar(txt_ConfirmPassword.getText()));

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

    @FXML
    private void C_BarEditPassword(ActionEvent event) {
        CargarVistas("CambiarPasswordEmpleado", "Home");
    }

}
