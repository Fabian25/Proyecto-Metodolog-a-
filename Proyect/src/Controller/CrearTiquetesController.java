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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class CrearTiquetesController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private TextField txt_Series;
    @FXML
    private ComboBox<?> txt_Status;
    @FXML
    private TextArea txt_description;
    @FXML
    private Button btnADD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void c_back(MouseEvent event) {
    }

    @FXML
    private void c_add(MouseEvent event) {
    }
    
}
