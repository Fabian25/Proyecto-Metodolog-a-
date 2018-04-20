/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.LoginController.infClient;
import DAO.ClienteDAOImplements;
import Model.Clientes;
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
public class EditarPerfilClienteController implements Initializable {

    ClienteDAOImplements h = new ClienteDAOImplements();

    @FXML
    private Button BarMyProfile;
    @FXML
    private Button BarEditProfile;
    @FXML
    private Button BarHomeC;
    @FXML
    private TextField txtCName;
    @FXML
    private TextField txtCLastNmae;
    @FXML
    private TextField txtCPhoneNum;
    @FXML
    private TextField txtCEmail;
    @FXML
    private Button btnADD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtCName.setText(LoginController.infClient.getNombre());
        txtCLastNmae.setText(LoginController.infClient.getApellido());
        txtCPhoneNum.setText(Integer.toString(LoginController.infClient.getTelefono()));
     
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
            Stage act = (Stage) BarHomeC.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
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
            alert.setTitle("Validar Nombre");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite un apellido valido");
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
    private void C_BarMyProfile(ActionEvent event) {
        CargarVistas("VerPerfilCliente", "Profile");
    }

    @FXML
    private void C_BarEditProfile(ActionEvent event) {
        CargarVistas("EditarPerfilCliente", "Profile");
    }

    @FXML
    private void C_Home(ActionEvent event) {
        CargarVistas("MenuCliente", "Profile");
    }

    @FXML
    private void Editar(ActionEvent event) {
        if(validaNombre() && validaApellido() && validaTelefono()){
              h.ActualizarInfClient(txtCName.getText(), txtCLastNmae.getText(), txtCPhoneNum.getText(), infClient.getCorreo(), infClient.getCedula());
         infClient.setNombre(txtCName.getText());
         infClient.setApellido(txtCLastNmae.getText());
         infClient.setTelefono(Integer.parseInt(txtCPhoneNum.getText()));
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

}
