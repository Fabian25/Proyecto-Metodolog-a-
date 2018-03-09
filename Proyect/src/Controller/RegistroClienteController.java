/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RegistroClienteController implements Initializable {
 ClienteDAOImplements h = new  ClienteDAOImplements();
    @FXML
    private TextField txtCName;
    @FXML
    private TextField txtCLastNmae;
    @FXML
    private TextField txtCIDnum;
    @FXML
    private TextField txtCPhoneNum;
    @FXML
    private TextField txtCEmail;
    @FXML
    private Button btnADD;
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
    private void c_add(MouseEvent event) {
        h.registrar(txtCName, txtCLastNmae, txtCIDnum, txtCPhoneNum, txtCEmail);
        //agrega a nivel de base de datos pero no a tabla
    }

    @FXML
    private void c_back(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + "Menu" + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu");
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage act = (Stage) btnBack.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }

}
