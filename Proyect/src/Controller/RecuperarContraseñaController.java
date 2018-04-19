/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.correo;
import DAO.GeneralDAOImplements;
import Model.Preguntas;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RecuperarContraseñaController implements Initializable {
Preguntas pregunta = new Preguntas();

    @FXML
    private ChoiceBox<String> cbxPregunta;
    @FXML
    private TextField txtRespuesta;
    @FXML
    private Button btnConfirmP;
    @FXML
    private Label txtCaptcha;
    @FXML
    private TextField lblCaptcha;
    @FXML
    private Button btn_Back;
    @FXML
    private TextField NewPassword;
    @FXML
    private TextField NewPasswordl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        txtCaptcha.setText(randomString(6));
//        cbxPregunta.getItems().add(1, "How old are you?");
//        cbxPregunta.getItems().add(2,"What is your favorite band?");
//        cbxPregunta.getItems().add(3, "Who is the best player in the world?");
//          switch(Integer.parseInt(pregunta.getPregunta())){
//            case 1:
//              cbxPregunta.setValue("How old are you?");
//                break;
//            case 2:
//                cbxPregunta.setValue("What is your favorite band?");
//                break;
//          default:
//                  cbxPregunta.setValue("Who is the best player in the world?");
//                break;
//        }
    }

    private String randomString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    @FXML
    private void Cpregunta(MouseEvent event) {

    }

    @FXML
    private void P_Captcha(ActionEvent event) {

    }

    @FXML
    private void P_Confirm(ActionEvent event) {
        GeneralDAOImplements h = new GeneralDAOImplements();
        if (txtCaptcha.getText().equals(lblCaptcha.getText())) {
            JOptionPane.showMessageDialog(null, "Correcto");
           h.RecuperarContrasena(correo);
        } else {
            lblCaptcha.setText(randomString(6));
            txtCaptcha.setText("");
        }
    }

    @FXML
    private void c_back(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + "Login" + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Login");
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) btn_Back.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

}
