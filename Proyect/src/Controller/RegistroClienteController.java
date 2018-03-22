/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import Model.Clientes;

import Model.Persona;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RegistroClienteController implements Initializable {

    ClienteDAOImplements h = new ClienteDAOImplements();
    @FXML
    private TextField txtCName;
    @FXML
    private TextField txtCLastNmae;
    @FXML
    private TextField txtCIDnum;
    @FXML
    private TextField txtCPhoneNum;
    @FXML
    private TextField txtCEmail;
    @FXML
    private Button btnADD;
    @FXML
    private Button btnBack;
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

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Clientes> tbClientes;
    @FXML
    private TableColumn<Clientes, String> columName;
    @FXML
    private TableColumn<Clientes, String> columLastname;
    @FXML
    private TableColumn<Clientes, Integer> columID;
    @FXML
    private TableColumn<Clientes, String> columPhone;
    @FXML
    private TableColumn<Clientes, String> columEmail;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columLastname.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columID.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columPhone.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
       
        CargarDatos();

    }

    private void CargarDatos() {
        tbClientes.getItems().clear();
        tbClientes.setItems(h.Clientes());

    }

    private void ClientesMenu(String Vista, String Titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisClient.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void c_back(MouseEvent event) {
        ClientesMenu("Menu", "Menu");
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
    private void c_add(ActionEvent event) {

        boolean flag = true;
        if (!validaNombre()) {
            flag = false;
        }
        if (!validaApellido()) {
            flag = false;
        }
        if (!validaID()) {
            flag = false;
        }
        if (!validaTelefono()) {
            flag = false;
        }
        if (!validateEmaill()) {
            flag = false;
        }

        if (flag) {
            h.registrar(txtCName.getText(), txtCLastNmae.getText(), txtCIDnum.getText(), txtCPhoneNum.getText(), txtCEmail.getText());
            //agrega a nivel de base de datos pero no a tabla
            txtCName.setText("");
            txtCLastNmae.setText("");
            txtCIDnum.setText("");
            txtCPhoneNum.setText("");
            txtCEmail.setText("");
            CargarDatos();
//        ClientesMenu("Menu", "Menu");
        }
    }

    private boolean validaNombre() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(txtCName.getText());
        if (m.find() && m.group().equals(txtCName.getText())) {
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
        Matcher m = p.matcher(txtCLastNmae.getText());
        if (m.find() && m.group().equals(txtCLastNmae.getText())) {
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

    private boolean validaID() {

        Pattern p = Pattern.compile("[0-9]{7}");
        Matcher m = p.matcher(txtCIDnum.getText());
        if (m.find() && m.group().equals(txtCIDnum.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar ID");
            alert.setHeaderText(null);
            alert.setContentText("Porfavor Digite un ID valido");
            alert.showAndWait();

            return false;
        }
    }

    private boolean validateEmaill() {
        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(txtCEmail.getText());
        if (m.find() && m.group().equals(txtCEmail.getText())) {
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
        Matcher m = p.matcher(txtCPhoneNum.getText());
        if (m.find() && m.group().equals(txtCPhoneNum.getText())) {
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
    private void c_add(MouseEvent event) {
    }

}
