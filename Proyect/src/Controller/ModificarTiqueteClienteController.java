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
 * @author jose
 */
public class ModificarTiqueteClienteController implements Initializable {

    TiquetesDAOImplements h = new TiquetesDAOImplements();
    ObservableList<String> Priority = FXCollections.observableArrayList();
    @FXML
    private TextField txt_Serie;
    @FXML
    private TextField txt_DescripcionEditT;
    @FXML
    private ComboBox<String> cbx_Priority;
    @FXML
    private TableView<Tiquetes> tbl_tiquetes;
    @FXML
    private TableColumn<Tiquetes, String> columnSeries;
    @FXML
    private TableColumn<Tiquetes, String> columnPriority;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnADD;
    @FXML
    private Button BarAssignTickets;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnSeries.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        columnPriority.setCellValueFactory(new PropertyValueFactory<>("Prioridad"));
        CargarDatos("");
        Priority.add("Mild");
        Priority.add("Severe");
        Priority.add("Critic");
        cbx_Priority.setItems(Priority);
    }

    private void CargarDatos(String busqueda) {
        tbl_tiquetes.getItems().clear();
        tbl_tiquetes.setItems(h.Tiquetes(busqueda));
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
        TiquetesMenu("MenuCliente", "Menu");
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
    private void busqueda(KeyEvent event) {
        CargarDatos(txtSearch.getText());

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
            CargarDatos("");
        }
    }

    @FXML
    private void AsignarTickets(ActionEvent event) {
        TiquetesMenu("CrearTiquete", "Ticket");

    }

}
