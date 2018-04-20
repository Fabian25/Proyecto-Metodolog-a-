/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.infEmpleado;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class EditarPerfilEmpleadoController implements Initializable {

    EmpleadoDAOImplements h1 = new EmpleadoDAOImplements();

    @FXML
    private Button BarMyProfile;
    @FXML
    private Button BarEditProfile;
    @FXML
    private Button BarHomeC;
    @FXML
    private Button BtnSave;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_Name;
    @FXML
    private TextField txt_LastName;
    @FXML
    private Button BarEditPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txt_Name.setText(LoginController.infEmpleado.getNombre());
        txt_LastName.setText(LoginController.infEmpleado.getApellido());
        txt_Phone.setText(Integer.toString(LoginController.infEmpleado.getTelefono()));
      
    }

    private void CargarVistas(String Vista, String Titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarMyProfile.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
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
    
      private boolean validaApellido() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(txt_LastName.getText());
        if (m.find() && m.group().equals(txt_LastName.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar Nombre");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite un apellido valido");
            alert.showAndWait();

            return false;
        }
    }


    private boolean validaTelefono() {
        Pattern p = Pattern.compile("(0|91)?[2-9][0-9]{7}");
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
    private void C_BarMyProfile(ActionEvent event) {
        CargarVistas("VerPerfilEmpleado", "Profile");
    }

    @FXML
    private void C_BarEditProfile(ActionEvent event) {
        CargarVistas("EditarPerfilEmpleado", "Profile");
    }

    @FXML
    private void C_Home(ActionEvent event) {
        CargarVistas("MenuEmpleado", "Home");
    }

    @FXML
    private void Save(ActionEvent event) {
        if(validaNombre() && validaApellido() && validaTelefono()){
        h1.ActualizarInfEmp(txt_Name.getText(), txt_LastName.getText(), Integer.parseInt(txt_Phone.getText()), infEmpleado.getCedula());
        infEmpleado.setNombre(txt_Name.getText());
        infEmpleado.setApellido(txt_LastName.getText());
        infEmpleado.setTelefono(Integer.parseInt(txt_Phone.getText()));
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Confirmation");
                            alert.setHeaderText(null);
                            alert.setContentText("The data has been updated");
                            alert.showAndWait();
         }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Confirmation");
                            alert.setHeaderText(null);
                            alert.setContentText("The data is unvalid");
                            alert.showAndWait();
        }
    
      
    }

    @FXML
    private void C_BarEditPassword(ActionEvent event) {
        CargarVistas("CambiarPasswordEmpleado", "Home");
    }

}
