/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.infEmpleado;
import DAO.ClienteDAOImplements;
import Model.Clientes;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RegistroClienteController implements Initializable {

    Connection connection = BaseDatos.Conexion.getConnection();
    Clientes cliente = new Clientes();
    ClienteDAOImplements h = new ClienteDAOImplements();
    ObservableList<Clientes> Clientes = FXCollections.observableArrayList();

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
    private TableView<Clientes> tbClientes;
    @FXML
    private TableColumn<Clientes, String> columName;
    @FXML
    private TableColumn<Clientes, String> columLastname;
    @FXML
    private TableColumn<Clientes, String> columID;
    @FXML
    private TableColumn<Clientes, String> columPhone;
    @FXML
    private TableColumn<Clientes, String> columEmail;
    @FXML
    private Button btnADD;
    @FXML
    private TextField txtBuscar;
    @FXML
    private ComboBox<String> SelectEmp;
    @FXML
    private TextField BusquedaCNombre;
    @FXML
    private TextField BusquedaCApe;
    @FXML
    private TextField BusquedaCedula;
    @FXML
    private TextField BusquedaCTel;
    @FXML
    private TextField BusquedaCCorreo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columLastname.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columID.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columPhone.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        CargarDatosCombo();

//        CargarDatos();
    }

    private void CargarDatos() {

        Clientes.add(new Clientes(0, SelectEmp.getSelectionModel().getSelectedItem(), Integer.parseInt(txtCIDnum.getText()), txtCName.getText(), txtCLastNmae.getText(),
                Integer.parseInt(txtCPhoneNum.getText()), txtCEmail.getText(), "", btnADD));
        tbClientes.setItems(Clientes);

    }

    private void CargarDatosCombo() {
        SelectEmp.getItems().clear();
        SelectEmp.setItems(h.AsigEmpresas());
    }

    private void ClientesMenu(String Vista, String Titulo) {
        try {
            tbClientes.getItems().clear();
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
        if (ExisteID()==true) {
            return false;
        }
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
        if (ExisteCorreo()==true) {
            return false;
        }
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
        Pattern p = Pattern.compile("(0|91)?[2-9][0-9]{7}");
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
    private void C_addCl(ActionEvent event) {
        boolean todoBien = false;
        if (validaNombre() == true && validaApellido() == true && validateEmaill() == true && validaTelefono() == true && validaID() == true) {
            todoBien = true;
        }
        if (todoBien) {
            h.registrarStorage(txtCName.getText(), txtCLastNmae.getText(), txtCIDnum.getText(), txtCPhoneNum.getText(), txtCEmail.getText(), SelectEmp.getSelectionModel().getSelectedItem());
            CargarDatos();
            txtCName.setText("");
            txtCLastNmae.setText("");
            txtCIDnum.setText("");
            txtCPhoneNum.setText("");
            txtCEmail.setText("");
            SelectEmp.getSelectionModel().select(null);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("Completed!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ups some data is incorrect");
            alert.showAndWait();

            txtCName.setText("");
            txtCLastNmae.setText("");
            txtCIDnum.setText("");
            txtCPhoneNum.setText("");
            txtCEmail.setText("");
            SelectEmp.getSelectionModel().select(null);
        }

    }

    public boolean ExisteID() {
        PreparedStatement preparedStatement;
        boolean yeah=false;
        String sql = "SELECT Cedula FROM Clientes WHERE Cedula =" + txtCIDnum.getText() + ";";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                   yeah= true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return yeah;
    }
   public boolean ExisteCorreo() {
        PreparedStatement preparedStatement;
        boolean yeah=false;
        String sql = "SELECT Correo FROM Clientes WHERE Correo =" + txtCEmail.getText() + ";";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt(1) == 1) {
                   yeah= true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return yeah;
    }
    @FXML
    private void Buscar(KeyEvent event) {
    }

    @FXML
    private void BusquedaNombre(KeyEvent event) {
    }

    @FXML
    private void BusquedaApellido(KeyEvent event) {
    }

    @FXML
    private void BusquedaCedula(KeyEvent event) {
    }

    @FXML
    private void BusquedaTelefono(KeyEvent event) {
    }

    @FXML
    private void BusquedaCorreo(KeyEvent event) {
    }

}
