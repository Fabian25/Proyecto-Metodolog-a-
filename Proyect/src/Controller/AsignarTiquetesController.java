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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class AsignarTiquetesController implements Initializable {

    @FXML
    private TableView<?> tbl_ticket;
    @FXML
    private TextField txt_search;
    @FXML
    private TableView<?> tbl_Employee;
    @FXML
    private TextField txt_SeriesTicket;
    @FXML
    private TextField txt_EmployeeCode;
    @FXML
    private Button btn_assign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void c_add(ActionEvent event) {
    }
    
}
