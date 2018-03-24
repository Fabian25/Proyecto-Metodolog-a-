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
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableColumn<Empresa, String> tblRemoveEnt;
    @FXML
    private TableView<Empresa> tblEnterprices;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCodeEnt.setCellValueFactory(new PropertyValueFactory<>("idEmpresa"));
        tblNameEnt.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        tblAcronymEnt.setCellValueFactory(new PropertyValueFactory<>("Acronimo"));
        tblPhoneEnt.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        tblRemoveEnt.setCellValueFactory(new PropertyValueFactory<>("button"));

        CargarDatos();
    }

    private void CargarDatos() {
        tblEnterprices.getItems().clear();
        tblEnterprices.setItems(h.Empresa());
    }    
 private void EmpresasMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
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
    
}
