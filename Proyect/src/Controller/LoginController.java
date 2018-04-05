/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.GeneralDAOImplements;

import java.net.URL;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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

    Connection connection = BaseDatos.Conexion.getConnection();

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
        GeneralDAOImplements h = new GeneralDAOImplements();
        h.RecuperarContrasena(txt_Usuario);
        IngresarMenu("RecuperarContraseña", "LogIn");
    }

    @FXML
    private void Ingresar(ActionEvent event) {
        //Falta Validar el patron de la contraseña
        if (validaEmail()) {

            if (!tipoUsuario()) {
                PreparedStatement preparedStatement;
                String email = txt_Usuario.getText();
                String password = txt_Contra.getText();

                String sql = "SELECT * FROM Employees WHERE correo = ? and contraseña = ?";

                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Usuario no existe");
                        alert.showAndWait();
                    } else {
                        if (resultSet.getInt(8) == 1) {
                            if (resultSet.getInt(9) == 1) {
                                IngresarMenu("Menu", "Menu");
                            } else {
                                IngresarMenu("MenuEmpleado", "Menu");
                            }

                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("User Inactivo");
                            alert.showAndWait();
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            } else {
                PreparedStatement preparedStatement;
                String email = txt_Usuario.getText();
                String password = txt_Contra.getText();

                String sql = "SELECT * FROM Clientes WHERE correo = ? and Contraseña = ?";

                try {
                    preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (!resultSet.next()) {

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error");
                        alert.setHeaderText(null);
                        alert.setContentText("Usuario no existe");
                        alert.showAndWait();
                    } else {
                        if (resultSet.getInt(8) == 1) {
                            IngresarMenu("MenuCliente", "Menu Cliente");
                        } else {
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("User Inactivo");
                            alert.showAndWait();
                        }
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
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

        Pattern p = Pattern.compile("((?=.\\d)(?=.[a-z])(?=.*[A-Z]).{6,15})");
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

//    public String encriptarMD5(String palabra) {
//        String pe = "";
//        try {
//            pe = hash(palabra);
//        } catch (Exception e) {
//            throw new Error("Error: Al encriptar el password");
//        }
//        return pe;
//    }
//
//    /**
//     * Encripta un String con el algoritmo MD5. Reemplazar la palabara MENOR por
//     * el simbolo de menor
//     *
//     * @return String
//     * @throws Exception
//     */
//    private String hash(String clear) throws Exception {
//        MessageDigest md = MessageDigest.getInstance("MD5");
//        byte[] b = md.digest(clear.getBytes());
//        int size = b.length;
//        StringBuffer h = new StringBuffer(size);
//        for (int i = 0; i < size; i++) {
//            int u = b[i] & 255;
//            if (u < 16) {
//                h.append("0" + Integer.toHexString(u));
//
//            } else {
//                h.append(Integer.toHexString(u));
//            }
//        }
//
//        return h.toString();
//    }

    

}
