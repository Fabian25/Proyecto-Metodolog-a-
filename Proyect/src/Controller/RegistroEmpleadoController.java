/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpleadoDAOImplements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
EmpleadoDAOImplements h = new EmpleadoDAOImplements();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

    @FXML
    private void c_add(MouseEvent event) {
       h.registrar(txt_Name, txt_Phone, txt_ID, txt_LastName, txt_Email);
       //agrega a nivel de base de datos no en el tabla
    }
    
}
