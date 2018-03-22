/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.EmpresaDAOImplements;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author ALONSITO
 */
public class RegristroEmpresaController implements Initializable {

    PreparedStatement pst = null;
    EmpresaDAOImplements h = new EmpresaDAOImplements();
    ResultSet rs = null;

    Connection connection = BaseDatos.Conexion.getConnection();
    @FXML
    private TextField txt_EntrepriceName;
    @FXML
    private TextField txt_Phone;
    @FXML
    private TextField txt_Acronym;
    @FXML
    private Button btnADDEnterprice;
    @FXML
    private Button btn_Import;
    @FXML
    private TableView<?> table_Enterprice;
    @FXML
    private Button BarRegisEntp;
    @FXML
    private Button BarEditEntp;
    @FXML
    private Button BarRemoveEntp;
    @FXML
    private Button BarViewEntp;
    @FXML
    private Button BarHomeEnt;

    private Button importXLToDB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }

    private void EmpresasMenu(String Vista, String Titulo) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage) BarRegisEntp.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void CargarDatos() {
        table_Enterprice.getItems().clear();
        table_Enterprice.getItems().addAll();
    }
<<<<<<< HEAD
=======

    
    @FXML
    private void c_Import(ActionEvent event) throws IOException, SQLException {

        try {
            String query = "Insert into Empresas(ID_EMPRESA,Nombre,Siglas,Telefono,Activo) values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            FileInputStream fileIn = new FileInputStream(new File("Empresas.xlsx"));
            XSSFWorkbook wb = new XSSFWorkbook(fileIn);
            XSSFSheet sheet = wb.getSheetAt(0);
            Row row;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);
                preparedStatement.setString(1, row.getCell(0).getStringCellValue());
                preparedStatement.setString(2, row.getCell(1).getStringCellValue());
                preparedStatement.setString(3, row.getCell(2).getStringCellValue());
                preparedStatement.setString(4, row.getCell(3).getStringCellValue());
                preparedStatement.setInt(5,(int)row.getCell(4).getNumericCellValue());
                preparedStatement.execute();
            }
//            wb.close();
            fileIn.close();
            preparedStatement.close();
        } catch (SQLException | FileNotFoundException ex) {
        }
        HBox hbox = new HBox(5);
        hbox.getChildren().addAll();

//        try {
//            String query = "Insert into Empresas(ID_EMPRESA,Nombre,Siglas,Telefono,Activo) values (?,?,?,?,?)";
//            PreparedStatement pst = connection.prepareStatement(query);
//            FileInputStream fileIn = new FileInputStream(new File("Empresas.xlsx"));
////       Workbook wb =  Workbook.getWorkbook(fileIn);
////           Sheet sheet = wb.getSheetAt(0);
//            Row row;
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                row = sheet.getRow(i);
//                pst.setString(1, row.getCell(0).getStringCellValue());
//                pst.setString(2, row.getCell(1).getStringCellValue());
//                pst.setString(3, row.getCell(2).getStringCellValue());
//                pst.setString(4, row.getCell(3).getStringCellValue());
//                pst.setInt(5,(int)row.getCell(4).getNumericCellValue());
//                pst.execute();
//            }
//            //wb.close();
//            fileIn.close();
//            pst.close();
//        } catch (SQLException | FileNotFoundException ex) {
//        }
//     CargarDatos();
    }
    
>>>>>>> c275ae045215b6c8d9949f571dca1a02f523b76a
    

//    private void c_Import(ActionEvent event) throws IOException, SQLException {
//     
//           
//        
////        try {
////            String query = "Insert into Empresas(ID_EMPRESA,Nombre,Siglas,Telefono,Activo) values (?,?,?,?,?)";
////            PreparedStatement pst = connection.prepareStatement(query);
////            FileInputStream fileIn = new FileInputStream(new File("Empresas.xlsx"));
//////       Workbook wb =  Workbook.getWorkbook(fileIn);
//////           Sheet sheet = wb.getSheetAt(0);
////            Row row;
////            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
////                row = sheet.getRow(i);
////                pst.setString(1, row.getCell(0).getStringCellValue());
////                pst.setString(2, row.getCell(1).getStringCellValue());
////                pst.setString(3, row.getCell(2).getStringCellValue());
////                pst.setString(4, row.getCell(3).getStringCellValue());
////                pst.setInt(5,(int)row.getCell(4).getNumericCellValue());
////                pst.execute();
////            }
////            //wb.close();
////            fileIn.close();
////            pst.close();
////        } catch (SQLException | FileNotFoundException ex) {
////        }
////     CargarDatos();
//    }

    @FXML
    private void Ent_BarRegist(ActionEvent event
    ) {
        EmpresasMenu("RegistroEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_BarEdit(ActionEvent event
    ) {
        EmpresasMenu("ModificarEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_BarRemove(ActionEvent event
    ) {
        EmpresasMenu("EliminarEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_BarView(ActionEvent event
    ) {
        EmpresasMenu("VerEmpresa", "Enterprise");
    }

    @FXML
    private void Ent_Home(ActionEvent event
    ) {
        EmpresasMenu("Menu", "Menu");
    }

    private boolean validaNombreEmpresa() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(txt_EntrepriceName.getText());
        if (m.find() && m.group().equals(txt_EntrepriceName.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar Nombre");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite un nombre valido");
            alert.showAndWait();

            return false;
        }
    }

    private boolean validarSiglas() {
        Pattern p = Pattern.compile("[A-Z]+");
        Matcher m = p.matcher(txt_Acronym.getText());
        if (m.find() && m.group().equals(txt_Acronym.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validar Nombre");
            alert.setHeaderText(null);
            alert.setContentText("Por favor digite un nombre valido");
            alert.showAndWait();

            return false;
        }
    }

    private boolean validaTelefono() {
        Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{7}");
        Matcher m = p.matcher(txt_Phone.getText());
        if (m.find() && m.group().equals(txt_Phone.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validate Mobile Number");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter Valid Mobile Number");
            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void E_Enterprice(ActionEvent event) {
<<<<<<< HEAD
        if (validaNombreEmpresa() | validarSiglas() | validaTelefono()) {
=======
        boolean flag = true;
        if(!validaNombreEmpresa()){
            flag = false;
        }
        if(!validaTelefono()){
            flag = false;
        } 
        if(!validarSiglas()){
            flag = false;
        }
        if (flag) {
>>>>>>> c275ae045215b6c8d9949f571dca1a02f523b76a
            h.registrarEmp(txt_EntrepriceName.getText(), txt_Phone.getText(), txt_Acronym.getText());
            //agrega a nivel de base de datos pero no a tabla
            txt_EntrepriceName.setText("");
            txt_Phone.setText("");
            txt_Acronym.setText("");
            //  ClientesMenu("Menu", "Menu");
        }
    }

    @FXML
    private void ImportClients(ActionEvent event)  throws IOException, SQLException{
        
         try {
                String query = "Insert into Empresa(idEmpresa, Nombre, Acronimo, Telefono, Activo) values (?,?,?,?,?)";
                pst = connection.prepareStatement(query);

                InputStream fileIn = new FileInputStream(new File("Empresas.xlsx"));

                XSSFWorkbook wb = new XSSFWorkbook(fileIn);
                
                XSSFSheet sheet = wb.getSheetAt(0);
                Row row;
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    row = sheet.getRow(i);
                    pst.setString(1, row.getCell(0).getStringCellValue());
                    pst.setString(2, row.getCell(1).getStringCellValue());
                    pst.setString(3, row.getCell(2).getStringCellValue());
                    pst.setInt(4, (int)row.getCell(3).getNumericCellValue());
                    pst.setInt(5, (int) row.getCell(4).getNumericCellValue());
                    pst.execute();
                }
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("User Details Imported From Excel Sheet To Database.");
                alert.showAndWait();

//                wb.close();
                fileIn.close();
                pst.close();
                rs.close();
            } catch (SQLException | FileNotFoundException | RuntimeException ex) {
                System.out.println(ex);
                Logger.getLogger(EmpresaDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EmpresaDAOImplements.class.getName()).log(Level.SEVERE, null, ex);
            }

//        HBox hbox = new HBox(5);
//        hbox.getChildren().addAll(importXLToDB);
    }

}
