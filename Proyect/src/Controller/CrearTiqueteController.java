/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TiquetesDAOImplements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class CrearTiqueteController implements Initializable {

    TiquetesDAOImplements h = new TiquetesDAOImplements();
    ObservableList<String> Priority = FXCollections.observableArrayList();

    @FXML
    private Button btn_ADDTiquet;
    @FXML
    private TextArea txt_description;

    @FXML
    private TextField txt_series;
    @FXML
    private Button BarRegisTickets;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private ComboBox<String> cbx_Priority;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // ObservableList<String> items = FXCollections.observableArrayList();
        //items.addAll("item-1", "item-2", "item-3", "item-4", "item-5");
//        //cbx_Status = new ComboBox<>(items);
//        cbx_Priority.getItems().add(0, "Mild");
//        cbx_Priority.getItems().add(1, "Severe");
//        cbx_Priority.getItems().add(2, "Critic");

        Priority.add("Mild");
        Priority.add("Severe");
        Priority.add("Critic");
        cbx_Priority.setItems(Priority);
    }

    private void TiquetesMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisTickets.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void c_back(MouseEvent event) {
        TiquetesMenu("Menu", "Menu");
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

    @FXML
    private void AddTiquete(ActionEvent event) {
        txt_description.setText(" ");
        
        int priority = 0;
        switch (cbx_Priority.getSelectionModel().getSelectedItem()) {
            case "Mild":
                priority = 1;
                break;
            case "Severe":
                priority = 2;
                break;
            default:
                priority = 3;
                break;
        }
        txt_series.setText(h.registrarTiquetes(priority, txt_description.getText()));
    }
}
