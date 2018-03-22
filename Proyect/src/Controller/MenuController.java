/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jose
 */
public class MenuController implements Initializable {

    @FXML
    private Button btn_Cliente;
    @FXML
    private Button btn_Tiquete;
    @FXML
    private Button btn_Empresa;
    @FXML
    private Button btn_Empleado;
    @FXML
    private Button btnExit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private void CargarVistas(String Vista, String Titulo) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) btn_Cliente.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void Clientes(ActionEvent event) {
        CargarVistas("RegistroCliente", "Clients");
    }

    @FXML
    private void Tiquetes(ActionEvent event) {
        CargarVistas("CrearTiquete", "Tickets");
    }

    @FXML
    private void Empresas(ActionEvent event) {
        CargarVistas("RegistroEmpresa", "Enterprises");
    }

    @FXML
    private void Empleados(ActionEvent event) {
        CargarVistas("RegistroEmpleado", "Employees");
    }
    
    @FXML
    private void B_Salir(MouseEvent event) {
     CargarVistas("Login", "Log In");
    }

}
