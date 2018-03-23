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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class ModificarTiqueteClienteController implements Initializable {

    @FXML
    private TableView<?> tbl_tiquetes;
    @FXML
    private TextField txtCName11;
    @FXML
    private ComboBox<String> cbx_status;
    @FXML
    private TextField txtCName111;
    @FXML
    private Button btnADD;
    @FXML
    private Button BarRegisTickets;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         cbx_status.getItems().add(0, "Mild");
     cbx_status.getItems().add(1, "Severe");
     cbx_status.getItems().add(2, "Critic");
    }    

    
      private void TiquetesMenu(String Vista, String Titulo) {

       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage)  BarRegisTickets.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
      
    @FXML
    private void c_add(MouseEvent event) {
    }

    @FXML
    private void Tik_BarRegist(ActionEvent event) {
         TiquetesMenu("CrearTiquete", "Ticket");
    }

    @FXML
    private void Tik_BarEdit(ActionEvent event) {
         TiquetesMenu("ModificarTiqueteCliente", "Ticket");
    }


    @FXML
    private void Tik_BarView(ActionEvent event) {
           TiquetesMenu("VerEliminarTiqueteCliente", "Ticket");
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
          TiquetesMenu("MenuCliente", "Menu");
    }
    
}