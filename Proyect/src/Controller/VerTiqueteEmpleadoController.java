/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpleadoDAOImplements;
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
 * @author ALONSITO
 */
public class VerTiqueteEmpleadoController implements Initializable {

    TiquetesDAOImplements h = new TiquetesDAOImplements();

    @FXML
    private TableView<Tiquetes> tblRemoveTiq;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private TextField txt_search;
    @FXML
    private TableColumn<Tiquetes, String> ColSerie;
    @FXML
    private TableColumn<Tiquetes, String> ColPrioridad;
    @FXML
    private TableColumn<Tiquetes, String> ColDescripcion;
    @FXML
    private TableColumn<Tiquetes, String> ColEstado;
    @FXML
    private TextField BusquedaTSerie;
    @FXML
    private TextField BusquedaTPrio;
    @FXML
    private TextField BusquedaTDesc;
    @FXML
    private TextField BusquedaEstado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColSerie.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        ColDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        ColEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        ColPrioridad.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
        CargarDatos("", 0);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblRemoveTiq.getItems().clear();
        tblRemoveTiq.setItems(h.TiquetesEmpleado(busqueda, Cond));
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

    @FXML
    private void Tik_BarView(ActionEvent event) {
        TiquetesMenu("VerTiqueteEmpleado", "Tickets");
    }

    private void Tik_BarProcess(ActionEvent event) {
        TiquetesMenu("procesarTiquetes", "Tickets");
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
        TiquetesMenu("MenuEmpleado", "Home");
    }

    @FXML
    private void tblVerTiqEmp(MouseEvent event) {
        Tiquetes tiquete = tblRemoveTiq.getSelectionModel().getSelectedItem();
        if (tiquete != null) {
            ProcesarTiquetesController.tiquete = tiquete;
            TiquetesMenu("procesarTiquetes", "Tickets");
        }
    }

    @FXML
    private void Search(KeyEvent event) {
        CargarDatos(txt_search.getText(), 0);
    }

    @FXML
    private void BusquedaSerie(KeyEvent event) {
        if (BusquedaTSerie.getText().equals("")) {
            txt_search.setDisable(false);
        } else {
            txt_search.setDisable(true);
        }
        CargarDatos(BusquedaTSerie.getText(), 1);
        txt_search.setText("");

    }

    @FXML
    private void BusquedaPrioridad(KeyEvent event) {
        if (BusquedaTPrio.getText().equals("")) {
            txt_search.setDisable(false);
        } else {
            txt_search.setDisable(true);
        }
        CargarDatos(BusquedaTPrio.getText(), 2);
        txt_search.setText("");
    }

    @FXML
    private void BusquedaDescripcion(KeyEvent event) {
        if (BusquedaTDesc.getText().equals("")) {
            txt_search.setDisable(false);
        } else {
            txt_search.setDisable(true);
        }
        CargarDatos(BusquedaTDesc.getText(), 3);
        txt_search.setText("");
    }

    @FXML
    private void BusquedaEstado(KeyEvent event) {
        if (BusquedaEstado.getText().equals("")) {
            txt_search.setDisable(false);
        } else {
            txt_search.setDisable(true);
        }
        CargarDatos(BusquedaEstado.getText(), 4);
        txt_search.setText("");
    }

}
