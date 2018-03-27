/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpleadoDAOImplements;
import Model.Empleados;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class VerEmpleadoController implements Initializable {

    
    EmpleadoDAOImplements h = new EmpleadoDAOImplements();
    @FXML
    private Button BarRegisEmp;
    @FXML
    private Button BarEditEmp;
    @FXML
    private Button BarRemoveEmp;
    @FXML
    private Button BarViewEmp;
    @FXML
    private Button BarHomeE;
    @FXML
    private TextField txtBusuqeda;
    @FXML
    private TableView<Empleados> tblEmpleado;
    @FXML
    private TableColumn<Empleados, String> colunmCode;
    @FXML
    private TableColumn<Empleados, String> ColunmName;
    @FXML
    private TableColumn<Empleados, String> ColunmLastName;
    @FXML
    private TableColumn<Empleados, Integer> ColunmIDNumber;
    @FXML
    private TableColumn<Empleados, Integer> ColunmPhoneNumber;
    @FXML
    private TableColumn<Empleados, String> ColunmEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunmCode.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        ColunmName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        ColunmLastName.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        ColunmIDNumber.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        ColunmPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        ColunmEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        CargarDatos("");
    }  
      private void CargarDatos(String busqueda) {
        tblEmpleado.getItems().clear();
        tblEmpleado.setItems(h.Empleados(busqueda));
    }

    
    private void EmpleadosMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisEmp.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void c_back(MouseEvent event) {
        EmpleadosMenu("EliminarEmpleado", "Employee");
    }

    @FXML
    private void E_BarRegist(ActionEvent event) {
        EmpleadosMenu("RegistroEmpleado", "Employee");
    }

    @FXML
    private void E_BarEdit(ActionEvent event) {
        EmpleadosMenu("ModificarEmpleado", "Employee");
    }

    @FXML
    private void E_BarRemove(ActionEvent event) {
        EmpleadosMenu("EliminarEmpleado", "Employee");
    }

    @FXML
    private void E_BarView(ActionEvent event) {
        EmpleadosMenu("VerEmpleado", "Employee");
    }

    @FXML
    private void E_Home(ActionEvent event) {
        EmpleadosMenu("Menu", "Menu");
    }

    @FXML
    private void Busqueda(KeyEvent event) {
        CargarDatos(txtBusuqeda.getText());
    }
    
}
