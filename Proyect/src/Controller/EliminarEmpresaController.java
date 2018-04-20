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
public class EliminarEmpresaController implements Initializable {

    EmpresaDAOImplements h = new EmpresaDAOImplements();

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
    private TableColumn<Empresa, String> tblCodeEnt;
    @FXML
    private TableColumn<Empresa, String> tblNameEnt;
    @FXML
    private TableColumn<Empresa, String> tblAcronymEnt;
    @FXML
    private TableColumn<Empresa, Integer> tblPhoneEnt;
    @FXML
    private TableView<Empresa> tblEnterprices;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtBuscar;
    @FXML
    private TextField BusquedaEmCod;
    @FXML
    private TextField BusquedaEmNom;
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
        btnEliminar.setVisible(false);
    }

    private void CargarDatos(String busqueda, int Cond) {
        tblEnterprices.getItems().clear();
        tblEnterprices.setItems(h.Empresa(busqueda, Cond));
        btnEliminar.setVisible(false);
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

    private void c_back(MouseEvent event) {
        EmpresasMenu("EliminarEmpresa", "Enterprise");
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

    @FXML
    private void Seleccionar(MouseEvent event) {
        Empresa cliente = tblEnterprices.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            btnEliminar.setVisible(true);
        } else {
            btnEliminar.setVisible(false);
        }
    }

    @FXML
    private void Eliminar(ActionEvent event) {
        Empresa cliente = tblEnterprices.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            h.eliminar(cliente.getIdEmpresa());
            CargarDatos("", 0);
        }
        btnEliminar.setVisible(false);
    }

    @FXML
    private void busqueda(KeyEvent event) {
        CargarDatos(txtBuscar.getText(), 0);
    }

    @FXML
    private void BusquedaCodigo(KeyEvent event) {
        if (BusquedaEmCod.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaEmCod.getText(), 1);
        txtBuscar.setText("");
    }

    @FXML
    private void BusquedaNombre(KeyEvent event) {
        if (BusquedaEmNom.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaEmNom.getText(), 2);
        txtBuscar.setText("");
    }

    @FXML
    private void BusquedaAcronimo(KeyEvent event) {
        if (BusquedaEmAcr.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaEmAcr.getText(), 3);
        txtBuscar.setText("");
    }

    @FXML
    private void BusquedaTelefono(KeyEvent event) {
        if (BusquedaEmTel.getText().equals("")) {
            txtBuscar.setDisable(false);
        } else {
            txtBuscar.setDisable(true);
        }
        CargarDatos(BusquedaEmTel.getText(), 4);
        txtBuscar.setText("");
    }

}
