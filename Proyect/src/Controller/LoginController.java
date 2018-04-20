/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ClienteDAOImplements;
import DAO.EmpleadoDAOImplements;
import DAO.GeneralDAOImplements;
import Model.Clientes;
import Model.Empleados;
import java.security.Key;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class LoginController implements Initializable {

    public static Clientes infClient = null;
    public static Empleados infEmpleado = null;
    public static String correo =" ";
    ClienteDAOImplements h = new ClienteDAOImplements();
    EmpleadoDAOImplements h1 = new EmpleadoDAOImplements();

    @FXML
    private TextField txt_Usuario;
    @FXML
    private PasswordField txt_Contra;
    @FXML
    private Label lbl_Recuperar;
    @FXML
    private Button btn_Ingresar;

    Connection connection = BaseDatos.Conexion.getConnection();
    @FXML
    private Button btnExit;

    private void IngresarMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
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

        correo=txt_Usuario.getText();
      
        IngresarMenu("RecuperarContraseña", "LogIn");
    }

    @FXML
<<<<<<< HEAD
    private void Ingresar(ActionEvent event) throws Exception {
    String s=txt_Contra.getText();
        if (validaEmail() && validaPassword()) {
            infClient = h.VerInfCliente(txt_Usuario.getText(), Encriptar(s));

            if (infClient != null) {
                IngresarMenu("MenuCliente", "Menu Cliente");
            } else {
              
                infEmpleado = h1.VerInfEmpleado(txt_Usuario.getText(), Encriptar(s));
                if (infEmpleado != null) {
                    PreparedStatement preparedStatement;
                    String sql = "SELECT TipoEmpleado_idTipoEmpleado FROM Employees WHERE Cedula =" + infEmpleado.getCedula()+ ";";
                    try {
                        preparedStatement = connection.prepareStatement(sql);
                        ResultSet resultSet = preparedStatement.executeQuery();

                        while (resultSet.next()) {                            
                             if (resultSet.getInt(1) ==1) {
                                IngresarMenu("Menu", "Menu");
                            } else {
                                IngresarMenu("MenuEmpleado", "Menu");
                            }
                        }

                    } catch (SQLException e) {
                        System.out.println(e);
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Usuario no existe");
                    alert.showAndWait();
                }
            }
        }
    }

    private boolean tipoUsuario() {
        PreparedStatement preparedStatement;
        String email = txt_Usuario.getText();
        String password = txt_Contra.getText();

        String sql = "SELECT * FROM Clientes WHERE correo = ? and contraseña = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            }

        } catch (SQLException e) {
        }
        return true;

    }

    private boolean validaEmail() {
        Pattern p = Pattern.compile("[a-zA-z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher m = p.matcher(txt_Usuario.getText());
        if (m.find() && m.group().equals(txt_Usuario.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Number");
            alert.setHeaderText(null);
            alert.setContentText("Digite los valores basico");
            alert.showAndWait();
            return false;
        }
    }

    private boolean validaPassword() {

        String password_pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%*]).{6,15})";
        Pattern p = Pattern.compile(password_pattern);
        Matcher m = p.matcher(txt_Contra.getText());
        if (m.matches()) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Password");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña debe tener(Digitos, minusculas, mayusculas y caracteres) y  debe tener de 6- 15 digitos");
            alert.showAndWait();
            return false;
        }
    }

    public String Encriptar(String pass)throws Exception{
      KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
      keyGenerator.init(128);
      Key key = keyGenerator.generateKey();

      key = new SecretKeySpec("una clave de 16 bytes".getBytes(),  0, 16, "AES");

      String texto = pass;

      Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");

      aes.init(Cipher.ENCRYPT_MODE, key);
      byte[] encriptado = aes.doFinal(texto.getBytes());
String w =" ";
      for (byte b : encriptado) {
          w+=Integer.toHexString(0xFF & b);
 
      }
        return w;
    }

    @FXML
    private void Exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}
