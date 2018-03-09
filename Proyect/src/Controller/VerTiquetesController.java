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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class VerTiquetesController implements Initializable {

    @FXML
    private TableView<?> tblRemoveTiq;
    @FXML
    private ChoiceBox<?> chbxRemoveTiquete;
    @FXML
    private Button BarRegisTickets;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarRemoveTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Tik_BarRegist(ActionEvent event) {
    }

    @FXML
    private void Tik_BarEdit(ActionEvent event) {
    }

    @FXML
    private void Tik_BarRemove(ActionEvent event) {
    }

    @FXML
    private void Tik_BarView(ActionEvent event) {
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
    }

    @FXML
    private void c_back(MouseEvent event) {
    }
    
}
