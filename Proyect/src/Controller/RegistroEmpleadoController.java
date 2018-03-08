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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class RegistroEmpleadoController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnADD;
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_ID;
    @FXML
    private TextField txt_LastName;
    @FXML
    private TextField txt_Email;
    @FXML
    private TableView<?> table_Empleado;

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
