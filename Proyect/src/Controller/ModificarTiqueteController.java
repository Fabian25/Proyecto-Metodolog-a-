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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    ObservableList<String> Priority = FXCollections.observableArrayList();

    @FXML
    private Button btnADD;

    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarRemoveTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    private ComboBox<String> cbx_status;
    @FXML
    private TableView<Tiquetes> tbl_tiquetes;
    @FXML
    private TableColumn<Tiquetes, String> columnSeries;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txt_Serie;
    @FXML
    private TextField txt_DescripcionEditT;
    @FXML
    private ComboBox<String> cbx_Priority;
    @FXML
    private TableColumn<Tiquetes, String> columnPriority;
    @FXML
    private Button BarAssignTickets;
    @FXML
    private TextField BusquedaTSerie;
    @FXML
    private TextField BusquedaTPrio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnSeries.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        columnPriority.setCellValueFactory(new PropertyValueFactory<>("Prioridad"));
        CargarDatos("", 0);
        Priority.add("Mild");
        Priority.add("Severe");
        Priority.add("Critic");
        cbx_Priority.setItems(Priority);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tbl_tiquetes.getItems().clear();
        tbl_tiquetes.setItems(h.Tiquetes(busqueda, Cond));
        txt_Serie.setText("");
        txt_DescripcionEditT.setText("");
//        cbx_Priority.getItems().clear();
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
    private void busqueda(KeyEvent event) {
        CargarDatos(txtSearch.getText(), 0);

    }

    @FXML
    private void SeleccionarInfo(MouseEvent event) {
        Tiquetes cliente = tbl_tiquetes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            txt_Serie.setText(cliente.getID_Tiquete());
//            cbx_status.getItems().add(0, Integer.toString(cliente.getEstado()));
            txt_DescripcionEditT.setText(cliente.getDescripcion());
            switch (Integer.parseInt(cliente.getPrioridad())) {
                case 1:
                    cbx_Priority.setValue("Mild");
                    break;
                case 2:
                    cbx_Priority.setValue("Severe");
                    break;
                default:
                    cbx_Priority.setValue("Critic");
                    break;
            }
        }
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
       Tiquetes cliente = tbl_tiquetes.getSelectionModel().getSelectedItem();
        if (txt_DescripcionEditT.getText().trim().length() > 0 && cbx_Priority.getSelectionModel().getSelectedItem() != null) {
            if (cliente != null) {
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
                h.actualizar(txt_Serie.getText(), priority, txt_DescripcionEditT.getText(), cliente);
                CargarDatos("", 0);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Completed!");
            alert.showAndWait();
        } else {
            txt_DescripcionEditT.setText(" ");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ups some data is incorrect");
            alert.showAndWait();
        }
    }

    @FXML
    private void AsignarTickets(ActionEvent event) {
        TiquetesMenu("AsignarTiquetes", "Ticket");

    }

    @FXML
    private void BusquedaSerie(KeyEvent event) {
        if (BusquedaTSerie.getText().equals("")) {
            txtSearch.setDisable(false);
        } else {
            txtSearch.setDisable(true);
        }
        CargarDatos(BusquedaTSerie.getText(), 1);
        txtSearch.setText("");
    }

    @FXML
    private void BusquedaPrioridad(KeyEvent event) {
        if (BusquedaTPrio.getText().equals("")) {
            txtSearch.setDisable(false);
        } else {
            txtSearch.setDisable(true);
        }
        CargarDatos(BusquedaTPrio.getText(), 2);
        txtSearch.setText("");
    }

}
