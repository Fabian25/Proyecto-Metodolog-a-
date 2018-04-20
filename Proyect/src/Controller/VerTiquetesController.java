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
 * @author erick
 */
public class VerTiquetesController implements Initializable {

    TiquetesDAOImplements h = new TiquetesDAOImplements();

    @FXML
    private TableView<Tiquetes> tblRemoveTiq;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarRemoveTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private TextField txt_search;
    @FXML
    private TableColumn<Tiquetes, String> colunmSerie;
    @FXML
    private TableColumn<Tiquetes, String> colunmPriority;
    @FXML
    private TableColumn<Tiquetes, String> colunmDescription;
    @FXML
    private TableColumn<Tiquetes, String> colunmState;
    @FXML
    private Button BarAssignTickets;
    @FXML
    private TextField BusquedaTSerie;
    @FXML
    private TextField BusquedaTPrio;
    @FXML
    private TextField BusquedaTDesc;
    @FXML
    private TextField BusquedaTEstado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunmSerie.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        colunmDescription.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colunmState.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colunmPriority.setCellValueFactory(new PropertyValueFactory<>("prioridad"));

        CargarDatos("", 0);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblRemoveTiq.getItems().clear();
        tblRemoveTiq.setItems(h.Tiquetes(busqueda, Cond));
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
        CargarDatos(txt_search.getText(), 0);
    }

    @FXML
    private void AsignarTickets(ActionEvent event) {
        TiquetesMenu("AsignarTiquetes", "Ticket");

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
        if (BusquedaTEstado.getText().equals("")) {
            txt_search.setDisable(false);
        } else {
            txt_search.setDisable(true);
        }
        CargarDatos(BusquedaTEstado.getText(), 4);
        txt_search.setText("");
    }

}
