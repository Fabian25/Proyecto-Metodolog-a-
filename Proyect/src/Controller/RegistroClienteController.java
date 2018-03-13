/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class RegistroClienteController implements Initializable {

    ClienteDAOImplements h = new ClienteDAOImplements();
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
    private Button btnADD;
    @FXML
    private Button btnBack;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
    }

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


    @FXML
    private void c_back(MouseEvent event) {
        ClientesMenu("Menu", "Menu");
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

    @FXML
    private void c_add(ActionEvent event) {
        h.registrar(txtCName.getText(), txtCLastNmae.getText(), txtCIDnum.getText(), txtCPhoneNum.getText(), txtCEmail.getText());
        //agrega a nivel de base de datos pero no a tabla
        txtCName.setText("");
        txtCLastNmae.setText("");
        txtCIDnum.setText("");
        txtCPhoneNum.setText("");
        txtCEmail.setText("");
        ClientesMenu("Menu", "Menu");
    }
}
