/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GeneralDAOImplements;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

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

    private void IngresarMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) btn_Ingresar.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void addTextLimiter(final int maxLength) {
        txt_Usuario.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (txt_Usuario.getText().length() > maxLength) {
                    String s = txt_Usuario.getText().substring(0, maxLength);
                    txt_Usuario.setText(s);
                }
            }
        });
    }

    @FXML
    private void RecuperarContra(MouseEvent event) {
        GeneralDAOImplements h = new GeneralDAOImplements();
        h.RecuperarContrasena(txt_Usuario);
        IngresarMenu("RecuperarContraseña", "LogIn");
    }

    @FXML
    private void Ingresar(ActionEvent event) {

//        if (validaEmail()) {
            IngresarMenu("Menu", "Menu");
//        }
    }

//    private boolean validaEmail() {
//        Pattern p = Pattern.compile("[a-zA-z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
//        Matcher m = p.matcher(txt_Usuario.getText());
//        if (m.find() && m.group().equals(txt_Usuario.getText())) {
//            return true;
//        } else {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Validate Number");
//            alert.setHeaderText(null);
//            alert.setContentText("Digite los valores basico");
//            alert.showAndWait();
//            return false;
//        }
//    }
    

    @FXML
    private void L_User(KeyEvent ke) {
    
    }

}
