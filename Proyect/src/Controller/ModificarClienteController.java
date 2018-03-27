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
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Fabian
 */
public class ModificarClienteController implements Initializable {

    ClienteDAOImplements h = new ClienteDAOImplements();
    @FXML
    private Button btnADD;
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
    private TextField txt_Phone;

    @FXML
    private TableColumn<Clientes, String> columCode;
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
    private TableColumn<Clientes, String> columEdit;
    @FXML
    private TableView<Clientes> tblEditClient;
    @FXML
    private TextField txtCName;

    /**
     * Initializes the controller class.
     */
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columCode.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        columName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columLastName.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columId.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        columEmail.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        columEdit.setCellValueFactory(new PropertyValueFactory<>("button"));
        CargarDatos();
    }

    private void CargarDatos() {
        tblEditClient.getItems().clear();
        tblEditClient.setItems(h.Clientes(""));
        txtCName.setText("");
        txt_Phone.setText("");
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

//    private boolean validateEmaill() {
//        Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
//        Matcher m = p.matcher(txt_Email.getText());
//        if (m.find() && m.group().equals(txt_Email.getText())) {
//            return true;
//        } else {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Validate Email");
//            alert.setHeaderText(null);
//            alert.setContentText("Por favor digire un email valido");
//            alert.showAndWait();
//
//            return false;
//        }
//    }
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
    private void CargarCliente(MouseEvent event) {
        Clientes cliente = tblEditClient.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            txtCName.setText(cliente.getNombre());
            txt_Phone.setText(Integer.toString(cliente.getTelefono()));
        }
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
        Clientes cliente = tblEditClient.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            h.actualizar(txt_Phone.getText(), txtCName.getText(), cliente.getCedula());
            CargarDatos();
        }
    }
}
