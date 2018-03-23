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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class VerTiqueteEmpleadoController implements Initializable {

    @FXML
    private TableView<?> tblRemoveTiq;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarProcessTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private TextField txt_search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void TiquetesMenu(String Vista, String Titulo) {

       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage)  BarHomeTik.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void Tik_BarView(ActionEvent event) {
        TiquetesMenu("VerTiqueteEmpleado", "Tickets");
    }

    @FXML
    private void Tik_BarProcess(ActionEvent event) {
          TiquetesMenu("procesarTiquetes", "Tickets");
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
         TiquetesMenu("MenuEmpleado", "Home");
    }
    
}