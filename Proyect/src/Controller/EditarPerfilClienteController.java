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
import javax.swing.JOptionPane;

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
    private TextField txtCEmail;
    @FXML
    private Button btnADD;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
         h.ActualizarInfClient(txtCName.getText(), txtCLastNmae.getText(), txtCPhoneNum.getText(), infClient.getCorreo(), infClient.getCedula());
         infClient.setNombre(txtCName.getText());
         infClient.setApellido(txtCLastNmae.getText());
         infClient.setTelefono(Integer.parseInt(txtCPhoneNum.getText()));
<<<<<<< HEAD
      
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Confirmation");
                            alert.setHeaderText(null);
                            alert.setContentText("The data has been updated");
                            alert.showAndWait();
          
=======
         infClient.setCorreo(txtCEmail.getText());


<<<<<<< HEAD



//        infClient = h.actualizar(txtCName.getText(), txtCLastNmae.getText(), Integer.parseInt(txtCPhoneNum.getText()));
//        CargarDatos("");


=======

>>>>>>> 64c8b7a20c23f279b50dcfc766f4f40a4981217d
>>>>>>> b404efb803ac33fc7f1bc46c547aaf603f6169b4
    }

}
