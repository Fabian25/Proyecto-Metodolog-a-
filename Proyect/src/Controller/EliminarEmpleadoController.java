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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class EliminarEmpleadoController implements Initializable {

    @FXML
    private ChoiceBox<?> chbxRemoveEmploy;
    @FXML
    private ComboBox<?> cbxRemEmploy;
    @FXML
    private Button btnBack;
    @FXML
    private TableView<?> tblRemoveEmplo;

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
    
}
