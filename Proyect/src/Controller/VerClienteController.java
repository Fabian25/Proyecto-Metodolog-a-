/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import Model.Clientes;
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
public class VerClienteController implements Initializable {

    ClienteDAOImplements h = new ClienteDAOImplements();
    @FXML
    private TableView<Clientes> tblViewClient;
    @FXML
    private Button BarRegisClient;
    @FXML
    private Button BarEditClient;
    @FXML
    private Button BarRemoveClient;
    @FXML
    private Button BarViewClient;
    @FXML
    private Button BarHomeC;
    @FXML
    private TableColumn<Clientes, String> columName;
    @FXML
    private TableColumn<Clientes, String> columLastName;
    @FXML
    private TableColumn<Clientes, String> columId;
    @FXML
    private TableColumn<Clientes, String> columPhoneNumber;
    @FXML
    private TableColumn<Clientes, String> columEmail;
    @FXML
    private TextField txtBusqueda;
    @FXML
    private TextField BusquedaCNombre;
    @FXML
    private TextField BusquedaCAp;
    @FXML
    private TextField BusquedaCID;
    @FXML
    private TextField BusquedaCCorreo;
    @FXML
    private TextField BusquedaCTel;

    /**
     * Initializes the controller class.
     */
    private void ClientesMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
             stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisClient.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        columName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columLastName.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columId.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        CargarDatos("", 0);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblViewClient.getItems().clear();
        tblViewClient.setItems(h.Clientes(busqueda, Cond));
    }

    private void c_back(MouseEvent event) {
        ClientesMenu("EliminarCliente", "Clients");
    }

    @FXML
    private void C_BarRegist(ActionEvent event) {
        ClientesMenu("RegistroCliente", "Clients");

    }

    @FXML
    private void C_BarEdit(ActionEvent event) {
        ClientesMenu("ModificarCliente", "Clients");
    }

    @FXML
    private void C_BarRemove(ActionEvent event) {
        ClientesMenu("EliminarCliente", "Clients");
    }

    @FXML
    private void C_BarView(ActionEvent event) {
        ClientesMenu("VerCliente", "Clients");
    }

    @FXML
    private void C_Home(ActionEvent event) {
        ClientesMenu("Menu", "Menu");
    }

    @FXML
    private void Busqueda(KeyEvent event) {
        CargarDatos(txtBusqueda.getText(),0);
    }

    @FXML
    private void BusquedaNombre(KeyEvent event) {
        if (BusquedaCNombre.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaCNombre.getText(), 4);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaApellido(KeyEvent event) {
        if (BusquedaCAp.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaCAp.getText(), 5);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaCCedula(KeyEvent event) {
        if (BusquedaCID.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaCID.getText(), 3);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaTelefono(KeyEvent event) {
        if (BusquedaCTel.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaCTel.getText(), 6);
        txtBusqueda.setText("");
    }

    @FXML
    private void BusquedaCorreo(KeyEvent event) {
        if (BusquedaCCorreo.getText().equals("")) {
            txtBusqueda.setDisable(false);
        } else {
            txtBusqueda.setDisable(true);
        }
        CargarDatos(BusquedaCCorreo.getText(), 7);
        txtBusqueda.setText("");
    }

}
