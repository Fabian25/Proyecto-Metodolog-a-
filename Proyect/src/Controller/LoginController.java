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

import java.net.URL;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class LoginController implements Initializable {

    public static Clientes infClient = null;
    public static Empleados infEmpleado = null;
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
        GeneralDAOImplements h = new GeneralDAOImplements();
        h.RecuperarContrasena(txt_Usuario);
        IngresarMenu("RecuperarContraseña", "LogIn");
    }

    @FXML
    private void Ingresar(ActionEvent event) {
        //Falta Validar el patron de la contraseña
//        if (validaEmail()) {
//
//            if (!tipoUsuario()) {
//                PreparedStatement preparedStatement;
//                String email = txt_Usuario.getText();
//                String password = txt_Contra.getText();
//
//                String sql = "SELECT * FROM Employees WHERE correo = ? and contraseña = ?";
//
//                try {
//                    preparedStatement = connection.prepareStatement(sql);
//                    preparedStatement.setString(1, email);
//                    preparedStatement.setString(2, password);
//                    ResultSet resultSet = preparedStatement.executeQuery();
//                    if (!resultSet.next()) {
//
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Error");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Usuario no existe");
//                        alert.showAndWait();
//                    } else {
//                        if (resultSet.getInt(8) == 1) {
//                            if (resultSet.getInt(9) == 1) {
//                                IngresarMenu("Menu", "Menu");
//                            } else {
//                                IngresarMenu("MenuEmpleado", "Menu");
//                            }
//
//                        } else {
//                            Alert alert = new Alert(Alert.AlertType.WARNING);
//                            alert.setTitle("Error");
//                            alert.setHeaderText(null);
//                            alert.setContentText("User Inactivo");
//                            alert.showAndWait();
//                        }
//                    }
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }
//            } else {
////                if (VerInfCliente() != null) {
////                    
////                }
//                PreparedStatement preparedStatement;
//                String email = txt_Usuario.getText();
//                String password = txt_Contra.getText();
//
//                String sql = "SELECT * FROM Clientes WHERE correo = ? and Contraseña = ?";
//
//                try {
//                    preparedStatement = connection.prepareStatement(sql);
//                    preparedStatement.setString(1, email);
//                    preparedStatement.setString(2, password);
//                    ResultSet resultSet = preparedStatement.executeQuery();
//                    if (!resultSet.next()) {
//
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setTitle("Error");
//                        alert.setHeaderText(null);
//                        alert.setContentText("Usuario no existe");
//                        alert.showAndWait();
//                    } else {
//                        if (resultSet.getInt(8) == 1) {
//                            String sql2 = "Insert into UsuarioActual values(?,?);";
//                            preparedStatement = connection.prepareStatement(sql2);
//                            preparedStatement.setInt(1, 1);
//                            preparedStatement.setString(2, email);
//                            int resultSet2 = preparedStatement.executeUpdate();
//                            IngresarMenu("MenuCliente", "Menu Cliente");
//                        } else {
//                            Alert alert = new Alert(Alert.AlertType.WARNING);
//                            alert.setTitle("Error");
//                            alert.setHeaderText(null);
//                            alert.setContentText("Invalid User ");
//                            alert.showAndWait();
//                        }
//                    }
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }
//            }
//
//        }
        if (validaEmail() && validaPassword()) {
            infClient = h.VerInfCliente(txt_Usuario.getText(), txt_Contra.getText());
            if (infClient != null) {
                IngresarMenu("MenuCliente", "Menu Cliente");
            } else {
                infEmpleado = h1.VerInfEmpleado(txt_Usuario.getText(), txt_Contra.getText());
                if (infEmpleado != null) {
                    IngresarMenu("MenuEmpleado", "Menu");
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

       String password_pattern= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
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

    public String Encriptar(String pass) {
        String Encripted = " ";
        for (int i = 0; i < pass.length(); i++) {
            char p = pass.charAt(i);
            if (p == 'a' || p == 'A') {
                Encripted += ":v";
            }
            if (p == 'b' || p == 'B') {
                Encripted += ".0";
            }
            if (p == 'c' || p == 'C') {
                Encripted += "/*";
            }
            if (p == 'd' || p == 'D') {
                Encripted += "!^";
            }
            if (p == 'e' || p == 'E') {
                Encripted += "%$";
            }
            if (p == 'f' || p == 'F') {
                Encripted += "2s";
            }
            if (p == 'g' || p == 'G') {
                Encripted += "76";
            }
            if (p == 'h' || p == 'H') {
                Encripted += "6w";
            }
            if (p == 'i' || p == 'I') {
                Encripted += "2e";
            }
            if (p == 'j' || p == 'J') {
                Encripted += "1d";
            }
            if (p == 'k' || p == 'K') {
                Encripted += "+*";
            }
            if (p == 'l' || p == 'L') {
                Encripted += "d3";
            }
            if (p == 'm' || p == 'M') {
                Encripted += "g7";
            }
            if (p == 'n' || p == 'N') {
                Encripted += "q5";
            }
            if (p == 'ñ' || p == 'Ñ') {
                Encripted += ";g";
            }
            if (p == 'o' || p == 'O') {
                Encripted += "6W";
            }
            if (p == 'p' || p == 'P') {
                Encripted += "{f";
            }
            if (p == 'q' || p == 'Q') {
                Encripted += "2g";
            }
            if (p == 'r' || p == 'R') {
                Encripted += "fQ";
            }
            if (p == 's' || p == 'S') {
                Encripted += "*";
            }
            if (p == 't' || p == 'T') {
                Encripted += "/";
            }
            if (p == 'u' || p == 'U') {
                Encripted += "1";
            }
            if (p == 'v' || p == 'V') {
                Encripted += "$";
            }
            if (p == 'w' || p == 'W') {
                Encripted += "5";
            }
            if (p == 'x' || p == 'X') {
                Encripted += "w1";
            }
            if (p == 'y' || p == 'Y') {
                Encripted += "g1";
            }
            if (p == 'z' || p == 'Z') {
                Encripted += "1*";
            }
            Encripted += "@";
        }
        return Encripted;
    }

    @FXML
    private void Exit(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

}
