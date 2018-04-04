/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TiquetesDAOImplements;
import Model.Clientes;
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
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_Descripcion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       columnSeries.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
//        columnStatus.setCellValueFactory(new PropertyValueFactory<>("estado"));
//        CargarDatos("");
       
    }

    private void CargarDatos(String busqueda) {
//        tbl_tiquetes.getItems().clear();
//        tbl_tiquetes.setItems(h.Tiquetes(busqueda));
//        txt_Name.setText(""); 
//        txt_Descripcion.setText("");
//        cbx_status.getItems().clear();
    }
//     private void CargarDatosEdit(String busqueda) {
//        tbl_tiquetes.getItems().clear();
//        tbl_tiquetes.setItems(h.TiquetesEdit(busqueda));
//        txt_Name.setText("");
//        txt_Descripcion.setText("");
//        cbx_status.getItems().clear();
//   
//    }

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
    private void busqueda(KeyEvent event) {
////        CargarDatosEdit(txtSearch.getText());
//        cbx_status.getItems().add(0, "Mild");
//        cbx_status.getItems().add(1, "Severe");
//        cbx_status.getItems().add(2, "Critic");
       
    }

    @FXML
    private void SeleccionarInfo(MouseEvent event) {
//         Tiquetes cliente = tbl_tiquetes.getSelectionModel().getSelectedItem();
//        if (cliente != null) {
//            txt_Name.setText(cliente.getID_Tiquete());
////            cbx_status.getItems().add(0, Integer.toString(cliente.getEstado()));
//            txt_Descripcion.setText(cliente.getDescripcion());
//        }
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
//          Tiquetes cliente = tbl_tiquetes.getSelectionModel().getSelectedItem(); 
//           if (cliente != null) {
////            h.actualizar(txt_Name.getText(),  Integer.parseInt(cbx_status.getValue()), txt_Descripcion.getText());
//            CargarDatos("");
//        }
    }

}
