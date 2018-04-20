/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpresaDAOImplements;
import Model.Empresa;
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
public class ModificarEmpresaController implements Initializable {

    @FXML
    private Button btnADD;
    @FXML
    private Button BarRegisEntp;
    @FXML
    private Button BarEditEntp;
    @FXML
    private Button BarRemoveEntp;
    @FXML
    private Button BarViewEntp;
    @FXML
    private Button BarHomeEnt;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_Acronym;
    @FXML
    private TableView<Empresa> tblEditEnterprices;
    @FXML
    private TableColumn<Empresa, String> tblCodeEnt;
    @FXML
    private TableColumn<Empresa, String> tblNameEnt;
    @FXML
    private TableColumn<Empresa, String> tblAcronymEnt;
    @FXML
    private TableColumn<Empresa, Integer> tblPhoneEnt;

    EmpresaDAOImplements h = new EmpresaDAOImplements();
    @FXML
    private TextField txtbusqueda;
    @FXML
    private TextField BusquedaEmCod;
    @FXML
    private TextField BusquedaNombre;
    @FXML
    private TextField BusquedaEmAcr;
    @FXML
    private TextField BusquedaEmTel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCodeEnt.setCellValueFactory(new PropertyValueFactory<>("idEmpresa"));
        tblNameEnt.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tblAcronymEnt.setCellValueFactory(new PropertyValueFactory<>("Acronimo"));
        tblPhoneEnt.setCellValueFactory(new PropertyValueFactory<>("Telefono"));

        CargarDatos("", 0);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblEditEnterprices.getItems().clear();
        tblEditEnterprices.setItems(h.Empresa(busqueda, Cond));
        txt_Name.setText("");
        txt_Acronym.setText("");
        txt_Phone.setText("");
    }

    private void EmpresasMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisEntp.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void c_add(ActionEvent event) {
        if (validaNombreEmpresa() | validarSiglas() | validaTelefono()) {

            //agrega a nivel de base de datos pero no a tabla
            txt_Name.setText("");
            txt_Phone.setText("");
            txt_Acronym.setText("");
            //  ClientesMenu("Menu", "Menu");
        }

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
    private void Ent_BarRegist(ActionEvent event) {
        EmpresasMenu("RegistroEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_BarEdit(ActionEvent event) {
        EmpresasMenu("ModificarEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_BarRemove(ActionEvent event) {
        EmpresasMenu("EliminarEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_BarView(ActionEvent event) {
        EmpresasMenu("VerEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_Home(ActionEvent event) {
        EmpresasMenu("Menu", "Menu");
    }

    private boolean validaNombreEmpresa() {
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

    private boolean validarSiglas() {
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher(txt_Acronym.getText());
        if (m.find() && m.group().equals(txt_Acronym.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar Nombre");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite las siglas valido");
            alert.showAndWait();

            return false;
        }
    }

   

    @FXML
    private void CargarEmpresa(MouseEvent event) {
        Empresa empresa = tblEditEnterprices.getSelectionModel().getSelectedItem();
        if (empresa != null) {
            txt_Name.setText(empresa.getNombre());
            txt_Acronym.setText(empresa.getAcronimo());
            txt_Phone.setText(Integer.toString(empresa.getTelefono()));
        }
    }

    @FXML
    private void btnActualizar(ActionEvent event) {
        Empresa empresa = tblEditEnterprices.getSelectionModel().getSelectedItem();
        if (empresa != null) {
            if(validaNombreEmpresa()&&validaTelefono()&&validarSiglas()){
            h.Modificar(txt_Name.getText(), txt_Acronym.getText(), txt_Phone.getText(), empresa.getIdEmpresa());
            CargarDatos("", 0);
            } else{
                       Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Ups some data is incorrect");
            alert.showAndWait(); 
            }
           
        }
    }

    @FXML
    private void Buscar(KeyEvent event) {
        CargarDatos(txtbusqueda.getText(), 0);
    }

    @FXML
    private void BusquedaCodigo(KeyEvent event) {
        if (BusquedaEmCod.getText().equals("")) {
            txtbusqueda.setDisable(false);
        } else {
            txtbusqueda.setDisable(true);
        }
        CargarDatos(BusquedaEmCod.getText(), 1);
        txtbusqueda.setText("");
    }

    @FXML
    private void BusquedaNombre(KeyEvent event) {
        if (BusquedaNombre.getText().equals("")) {
            txtbusqueda.setDisable(false);
        } else {
            txtbusqueda.setDisable(true);
        }
        CargarDatos(BusquedaNombre.getText(), 2);
        txtbusqueda.setText("");
    }

    @FXML
    private void BusquedaAcronimo(KeyEvent event) {
        if (BusquedaEmAcr.getText().equals("")) {
            txtbusqueda.setDisable(false);
        } else {
            txtbusqueda.setDisable(true);
        }
        CargarDatos(BusquedaEmAcr.getText(), 3);
        txtbusqueda.setText("");
    }

    @FXML
    private void BusquedaTelefono(KeyEvent event) {
        if (BusquedaEmTel.getText().equals("")) {
            txtbusqueda.setDisable(false);
        } else {
            txtbusqueda.setDisable(true);
        }
        CargarDatos(BusquedaEmTel.getText(), 4);
        txtbusqueda.setText("");
    }

}
