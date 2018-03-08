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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Clientes(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + "RegistroCliente" + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Clients");
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage act = (Stage) btn_Cliente.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void Tiquetes(ActionEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + "CrearTiquetes" + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Tickets");
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage act = (Stage) btn_Tiquete.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void Empresas(ActionEvent event) {
          try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + "RegristroEmpresa" + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Enterprises");
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage act = (Stage) btn_Empresa.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    @FXML
    private void Empleados(ActionEvent event) {
         try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + "RegistroEmpleado" + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Employees");
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            Stage act = (Stage) btn_Empleado.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
}
