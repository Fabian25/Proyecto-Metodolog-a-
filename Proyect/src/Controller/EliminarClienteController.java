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
public class EliminarClienteController implements Initializable {

    ClienteDAOImplements h = new ClienteDAOImplements();
    @FXML
    private TableView<Clientes> tblRemoveClient;
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
    private TableColumn<Clientes, String> columRemove;
    @FXML
    private TableColumn<Clientes, String> columName;
    @FXML
    private TableColumn<Clientes, String> columLastName;
    @FXML
    private TableColumn<Clientes, String> columId;
    @FXML
    private TableColumn<Clientes, String> columPhoneNumber;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtBuscar;
    @FXML
    private TextField BusquedaCCod;
    @FXML
    private TextField BusquedaCNombre;
    @FXML
    private TextField BusquedaCAp;
    @FXML
    private TextField BusquedaCTel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columLastName.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columId.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Telefono"));

        columRemove.setCellValueFactory(new PropertyValueFactory<>("button"));
        CargarDatos("", 0);
        btnEliminar.setVisible(false);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblRemoveClient.getItems().clear();
        tblRemoveClient.setItems(h.Clientes(busqueda, Cond));
        btnEliminar.setVisible(false);
    }

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

    private void c_back(MouseEvent event) {
        ClientesMenu("ModificarCliente", "Clients");
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
    private void Eliminar(ActionEvent event) {
        Clientes cliente = tblRemoveClient.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            h.eliminar(cliente.getCedula());
            CargarDatos("", 0);
        }
        btnEliminar.setVisible(false);
    }

    @FXML
    private void Seleccionar(MouseEvent event) {
        Clientes cliente = tblRemoveClient.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            btnEliminar.setVisible(true);
        } else {
            btnEliminar.setVisible(false);
        }
    }

    @FXML
    private void Buscar(KeyEvent event) {
        CargarDatos(txtBuscar.getText(), 0);
    }

    @FXML
    private void BusquedaCodigo(KeyEvent event) {
        if (BusquedaCCod.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaCCod.getText(), 1);
        txtBuscar.setText("");
    }

    @FXML
    private void BusquedaNombre(KeyEvent event) {
        if (BusquedaCNombre.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaCNombre.getText(), 4);
        txtBuscar.setText("");
    }

    @FXML
    private void BusquedaApellido(KeyEvent event) {
        if (BusquedaCAp.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaCAp.getText(), 5);
        txtBuscar.setText("");
    }

    @FXML
    private void BusquedaTelefono(KeyEvent event) {
        if (BusquedaCTel.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaCTel.getText(), 6);
        txtBuscar.setText("");
    }
}
