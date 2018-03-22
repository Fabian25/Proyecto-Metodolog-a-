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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class MenuEmpleadoController implements Initializable {

    @FXML
    private Button btn_Tiquete;
    @FXML
    private Button btn_Perfil;
    @FXML
    private Button btnExit;

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
    }
    
}
