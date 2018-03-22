/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyect;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ALONSITO
 */
public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) {
<<<<<<< HEAD
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Menu.fxml"));
=======
      try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));
>>>>>>> cd6f7588a1393d7ca996c09bf921589626b5cd83

            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
