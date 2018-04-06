/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpleadoDAOImplements;
import DAO.TiquetesDAOImplements;
import Model.Empleados;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class AsignarTiquetesController implements Initializable {

    TiquetesDAOImplements h = new TiquetesDAOImplements();
    EmpleadoDAOImplements hE = new EmpleadoDAOImplements();

    @FXML
    private TableView<Tiquetes> tbl_ticket;
    @FXML
    private TableView<Empleados> tbl_Employee;
    @FXML
    private TextField txt_SeriesTicket;
    @FXML
    private TextField txt_EmployeeCode;
    @FXML
    private Button btn_assign;
    @FXML
    private Button BarAssignTickets;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarRemoveTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private TableColumn<Tiquetes, String> columSerieT;
    @FXML
    private TableColumn<Tiquetes, String> colum_PriorityT;
    
    @FXML
    private TextField txt_searchT;
    @FXML
    private TableColumn<Empleados, Integer> colum_CodeE;
    @FXML
    private TableColumn<Empleados, String> colum_NameE;
    @FXML
    private TextField txtbuscarE;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columSerieT.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        colum_PriorityT.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
        colum_CodeE.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colum_NameE.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        CargarDatos("");
        
    }
     private void CargarDatos(String busqueda) {
        tbl_ticket.getItems().clear();
        tbl_ticket.setItems(h.Tiquetes(busqueda));
        
        tbl_Employee.getItems().clear();
        tbl_Employee.setItems(hE.Empleados(busqueda));
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
    private void c_add(ActionEvent event) {
    }

    @FXML
    private void AsignarTickets(ActionEvent event) {
        TiquetesMenu("AsignarTiquetes", "Ticket");
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

}
