/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IDAO;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author jose
 */
public interface IGeneral {
    public void LogIn(TextField txtuser, PasswordField txtpass);
public void RecuperarContrasena(TextField txtuser) ;
    public void ActualizarContrasena(String correo) ;

}
