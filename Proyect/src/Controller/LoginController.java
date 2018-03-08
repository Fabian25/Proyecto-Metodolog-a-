/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.GeneralDAOImplements;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class LoginController implements Initializable {

    
    @FXML
    private TextField txt_Usuario;
    @FXML
    private PasswordField txt_Contra;
    @FXML
    private Label lbl_Recuperar;
    @FXML
    private Button btn_Ingresar;

    private void IngresarMenu(String name){
             try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + name + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(name);
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RecuperarContra(MouseEvent event) {
        GeneralDAOImplements h= new GeneralDAOImplements();
        h.RecuperarContrasena(txt_Usuario);
    }

    @FXML
    private void Ingresar(ActionEvent event) {
<<<<<<< HEAD
//       if(Validar == true){
//         switch(RevisarRol()){
//             case 1:
//               //menu administrador
//               IngresarMenu("Menu");
//               break;
//             case 2:
//               //menu cliente
//               IngresarMenu("MenuCliente");
//               break;
//             case 3:
//               //menu empleado
//               IngresarMenu("MenuEmpleado");
//               break;
//             default:   
//                 
//               break;
//            }   
//       }   

=======
GeneralDAOImplements h= new GeneralDAOImplements();
h.LogIn(txt_Usuario, txt_Contra);
>>>>>>> b37cd219dc574dd95854049b7e2b871fa62d9838
    }
    
}
