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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txt_Usuario;
    @FXML
    private PasswordField txt_Contra;
    @FXML
    private Label lbl_Recuperar;
    @FXML
    private Button btn_Ingresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RecuperarContra(MouseEvent event) {
    }

    @FXML
    private void Ingresar(ActionEvent event) {
    }
    
}
