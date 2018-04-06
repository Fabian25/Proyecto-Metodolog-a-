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
import javafx.stage.StageStyle;

/**
 *
 * @author ALONSITO
 */
public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
<<<<<<< HEAD
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/AsignarTiquetes.fxml"));
=======

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/Login.fxml"));


>>>>>>> d0216c2b86fad799a9f80e60dd2183e939696e71
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
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
