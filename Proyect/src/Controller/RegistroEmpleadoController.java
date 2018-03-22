/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpleadoDAOImplements;
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
public class RegistroEmpleadoController implements Initializable {

    @FXML
    private Button btnADD;
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_ID;
    @FXML
    private TextField txt_LastName;
    @FXML
    private TextField txt_Email;
    @FXML
    private TableView<?> table_Empleado;
EmpleadoDAOImplements h = new EmpleadoDAOImplements();
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    private void EmpleadosMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisEmp.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void c_back(MouseEvent event) {
        EmpleadosMenu("Menu", "Menu");        
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
            h.registrar(txt_Name.getText(), txt_LastName.getText(), txt_ID.getText(), txt_Phone.getText(), txt_Email.getText());
            //agrega a nivel de base de datos pero no a tabla
            txt_Name.setText("");
            txt_LastName.setText("");
            txt_ID.setText("");
            txt_Phone.setText("");
            txt_Email.setText("");
          //  ClientesMenu("Menu", "Menu");
        }

    }
    
    @FXML
    private void c_add(MouseEvent event) {
       //agrega a nivel de base de datos no en el tabla
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
        Matcher m = p.matcher(txt_LastName.getText());
        if (m.find() && m.group().equals(txt_LastName.getText())) {
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
        Pattern p = Pattern.compile("[0-9]{9}");
        Matcher m = p.matcher(txt_ID.getText());
        if (m.find() && m.group().equals(txt_ID.getText())) {
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


    
    
}
