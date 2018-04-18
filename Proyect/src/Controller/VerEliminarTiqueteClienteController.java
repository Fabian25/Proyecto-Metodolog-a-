/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.TiquetesDAOImplements;
<<<<<<< HEAD
=======
import Model.Tiquetes;
>>>>>>> 1227ccb8b3f0a07021a31bf61f5f5bafe3604fcc
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class VerEliminarTiqueteClienteController implements Initializable {
<<<<<<< HEAD
 
=======

    PreparedStatement preparedStatement = null;
    Connection connection = BaseDatos.Conexion.getConnection();
    TiquetesDAOImplements h = new TiquetesDAOImplements();
    
    
    
>>>>>>> 1227ccb8b3f0a07021a31bf61f5f5bafe3604fcc
    @FXML
    private TableView<Tiquetes> tblRemoveTiq;
    @FXML
    private Button BarRegisTickets;
    @FXML
    private Button BarEditTickets;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private TableColumn<Tiquetes, String> columSerie;
    @FXML
    private TableColumn<Tiquetes, String> columPriority;
    @FXML
    private TableColumn<Tiquetes, String> columDescription;
    @FXML
    private TableColumn<Tiquetes, String> columStatee;
    @FXML
    private TextField txtBuscar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
<<<<<<< HEAD
        // TODO
    }  
  

=======
        columSerie.setCellValueFactory(new PropertyValueFactory<>("ID_Tiquete"));
        columDescription.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columStatee.setCellValueFactory(new PropertyValueFactory<>("estado"));
        columPriority.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
    
      
  
    }    
>>>>>>> 1227ccb8b3f0a07021a31bf61f5f5bafe3604fcc

    private void TiquetesMenu(String Vista, String Titulo) {

       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
             stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage)  BarRegisTickets.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
     private int Data() {

        String sql = "SELECT Correo FROM sql10218899.UsuarioActual";

        String datos = " ";
        int ce = 0;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    datos = rs.getString(2);
                }

                String query = "{UsuarioActualClientes ActualizarCliente(" + datos + ")}";
                Statement st2 = connection.createStatement();
                ResultSet rs2 = st.executeQuery(sql);
                if (rs != null) {
                    ce = Integer.parseInt(query);
                }

            } else {

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ce;
    }
    
    
    @FXML
    private void Tik_BarRegist(ActionEvent event) {
         TiquetesMenu("CrearTiquete", "Ticket");
    }

    @FXML
    private void Tik_BarEdit(ActionEvent event) {
         TiquetesMenu("ModificarTiqueteCliente", "Ticket");
    }

    @FXML
    private void Tik_BarView(ActionEvent event) {
         TiquetesMenu("VerEliminarTiqueteCliente", "Ticket");
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
          TiquetesMenu("MenuCliente", "Menu");
    }
    
}
