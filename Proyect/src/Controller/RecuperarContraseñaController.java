/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RecuperarContraseñaController implements Initializable {

    @FXML
    private ChoiceBox<?> cbxPregunta;
    @FXML
    private TextField txtRespuesta;
    @FXML
    private Button btnConfirmP;
    @FXML
    private Button btnBack1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Cpregunta(MouseEvent event) {
    }

    @FXML
    private void c_back(MouseEvent event) {
    }
    
}
