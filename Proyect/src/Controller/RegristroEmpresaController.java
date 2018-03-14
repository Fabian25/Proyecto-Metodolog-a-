/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class RegristroEmpresaController implements Initializable {

    @FXML
    private TextField txt_EntrepriceName;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_Acronym;
    @FXML
    private Button btnADDEnterprice;
    @FXML
    private Button btn_Import;
    @FXML
    private TableView<?> table_Enterprice;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

     @FXML
    private void c_add(ActionEvent event) {
        if (validaNombreEmpresa()| validarSiglas()| validaTelefono()) {
            
            //agrega a nivel de base de datos pero no a tabla
            txt_EntrepriceName.setText("");
            txt_Phone.setText("");
            txt_Acronym.setText("");
          //  ClientesMenu("Menu", "Menu");
        }

    }
    
    
    @FXML
    private void c_add(MouseEvent event) {
    }

    private void c_back(MouseEvent event) {
        EmpresasMenu("Menu", "Menu");
    }

    @FXML
    private void Ent_BarRegist(ActionEvent event) {
        EmpresasMenu("RegistroEmpleado", "Enterprise");
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
        Matcher m = p.matcher(txt_EntrepriceName.getText());
        if (m.find() && m.group().equals(txt_EntrepriceName.getText())) {
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
    
    
}
