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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
 * @author Fabian
 */
public class ModificarEmpleadoController implements Initializable {

    EmpleadoDAOImplements h = new EmpleadoDAOImplements();

    @FXML
    private Button btnADD;
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
    private TextField txt_Lastname;
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_Phone;
    private TextField txt_Email;
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
    @FXML
    private TextField txtBusqueda;
    @FXML
    private TextField BusquedaECod;
    @FXML
    private TextField BusquedaEName;
    @FXML
    private TextField BusquedaEApellido;
    @FXML
    private TextField BusquedaEID;
    @FXML
    private TextField BusquedaETel;
    @FXML
    private TextField BusquedaECorreo;

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
        CargarDatos("", 0);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblEmpleado.getItems().clear();
        tblEmpleado.setItems(h.Empleados(busqueda, Cond));
        txt_Name.setText("");
        txt_Lastname.setText("");
        txt_Phone.setText("");
    }

    private void EmpleadosMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisEmp.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
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

    private void E_Back(ActionEvent event) {
        EmpleadosMenu("RegistroEmpleado", "Employee");
    }

    private boolean validaNombre() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(txt_Name.getText());
        if (m.find() && m.group().equals(txt_Name.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar Nombre");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite un nombre valido");
            alert.showAndWait();

            return false;
        }
    }

    private boolean validaApellido() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(txt_Lastname.getText());
        if (m.find() && m.group().equals(txt_Lastname.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar Apellido");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite un apelledio valido");
            alert.showAndWait();

            return false;
        }
    }

    private boolean validateEmaill() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(txt_Email.getText());
        if (m.find() && m.group().equals(txt_Email.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Email");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digire un email valido");
            alert.showAndWait();

            return false;
        }
    }

    private boolean validaTelefono() {
        Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{7}");
        Matcher m = p.matcher(txt_Phone.getText());
        if (m.find() && m.group().equals(txt_Phone.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Mobile Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Mobile Number");
            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void Busqueda(KeyEvent event) {
        CargarDatos(txtBusqueda.getText(), 0);
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
        Empleados emp = tblEmpleado.getSelectionModel().getSelectedItem();
        if (emp != null) {
            h.actualizar(txt_Name.getText(), txt_Lastname.getText(), Integer.parseInt(txt_Phone.getText()), emp.getCedula());
            CargarDatos("", 0);
        }
    }

    @FXML
    private void CargarEmpleados(MouseEvent event) {
        Empleados emp = tblEmpleado.getSelectionModel().getSelectedItem();
        if (emp != null) {
            txt_Name.setText(emp.getNombre());
            txt_Lastname.setText(emp.getApellido());
            txt_Phone.setText(Integer.toString(emp.getTelefono()));
        }
    }

    @FXML
    private void BusquedaCode(KeyEvent event) {
        if (BusquedaECod.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaECod.getText(), 1);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaName(KeyEvent event) {
        if (BusquedaEName.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaEName.getText(), 3);
        txtBusqueda.setText("");

    }

    @FXML
    private void BusquedaApellido(KeyEvent event) {
        if (BusquedaEApellido.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaEApellido.getText(), 4);
        txtBusqueda.setText("");

    }

    @FXML
    private void BusquedaID(KeyEvent event) {
        if (BusquedaEID.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaEID.getText(), 2);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaTelefono(KeyEvent event) {
        if (BusquedaETel.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaETel.getText(), 5);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaCorreo(KeyEvent event) {
        if (BusquedaECorreo.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaECorreo.getText(), 6);
        txtBusqueda.setText("");
    }
}
