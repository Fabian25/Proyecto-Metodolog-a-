/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TiquetesDAOImplements;
import Model.Tiquetes;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Fabian
 */
public class ModificarTiqueteController implements Initializable {

    TiquetesDAOImplements h = new TiquetesDAOImplements();
    @FXML
    private Button btnADD;
    @FXML
    private TextField txtCName11;
    @FXML
    private TextField txtCName111;

    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarRemoveTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private ComboBox<String> cbx_status;
    @FXML
    private TableView<Tiquetes> tbl_tiquetes;
    @FXML
    private TableColumn<Tiquetes, String> columnSeries;
    @FXML
    private TableColumn<Tiquetes, String> columnStatus;
    @FXML
    private TextField txtSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbx_status.getItems().add(0, "Mild");
        cbx_status.getItems().add(1, "Severe");
        cbx_status.getItems().add(2, "Critic");
        columnSeries.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("estado"));
        CargarDatos("");
    }

    private void CargarDatos(String busqueda) {
        tbl_tiquetes.getItems().clear();
        tbl_tiquetes.setItems(h.Tiquetes(busqueda));
    }
     private void CargarDatosEdit(String busqueda) {
        tbl_tiquetes.getItems().clear();
        tbl_tiquetes.setItems(h.TiquetesEdit(busqueda));
    }

    private void TiquetesMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarHomeTik.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void c_back(MouseEvent event) {
        TiquetesMenu("Menu", "Menu");
    }

    @FXML
    private void Tik_BarEdit(ActionEvent event) {
        TiquetesMenu("ModificarTiquete", "Ticket");
    }

    @FXML
    private void Tik_BarRemove(ActionEvent event) {
        TiquetesMenu("EliminarTiquete", "Ticket");
    }

    @FXML
    private void Tik_BarView(ActionEvent event) {
        TiquetesMenu("VerTiquetes", "Ticket");
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
        TiquetesMenu("Menu", "Menu");
    }

    @FXML
    private void c_add(MouseEvent event) {
    }

    @FXML
    private void busqueda(KeyEvent event) {
        CargarDatosEdit(txtSearch.getText());
    }

}
