package Controller;

import DAO.EmpleadoDAOImplements;
import Model.Tiquetes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

public class ProcesarTiquetesController implements Initializable {

    public static Tiquetes tiquete = new Tiquetes();
    EmpleadoDAOImplements h = new EmpleadoDAOImplements();

    @FXML
    private ProgressBar ProgressBar;
    @FXML
    private Button btnSend;
    @FXML
    private Button btnApproved;
    @FXML
    private Button btnAnalyzing;
    @FXML
    private Button btnChecked;
    @FXML
    private TextArea txt_Solution;
    @FXML
    private ComboBox<String> cb_status;
    @FXML
    private Button BarViewTickets;
    @FXML
    private Button BarProcessTickets;
    @FXML
    private Button BarHomeTik;
    @FXML
    private Button txtSerie;
    @FXML
    private TextArea txaDescripcion;
    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txaDescripcion.setText(tiquete.getDescripcion());
        txtSerie.setText(tiquete.getID_Tiquete());
        txaDescripcion.setEditable(false);
        txt_Solution.setText(tiquete.getSolucion());
        cb_status.getItems().add(0, "Send");
        cb_status.getItems().add(1, "Analyzing");
        cb_status.getItems().add(2, "Checked");
        cb_status.getItems().add(3, "Approved");
        switch(Integer.parseInt(tiquete.getEstado())){
            case 1:
                cb_status.setValue("Send");
                break;
            case 2:
                cb_status.setValue("Analyzing");
                break;
            case 3:
                    cb_status.setValue("Checked");
                break;
            default:
                cb_status.setValue("Approved");
                break;
        }
        btnSend.setDisable(true);
        btnApproved.setDisable(true);
        btnAnalyzing.setDisable(true);
        btnChecked.setDisable(true);
        Hilo();
    }
    
     private void TiquetesMenu(String Vista, String Titulo) {
       try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/" + Vista + ".fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle(Titulo);
            stage.setScene(new Scene(root1));
            stage.show();
            Stage act = (Stage)  BarHomeTik.getScene().getWindow();
            act.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
   
    @FXML
    private void Tik_BarView(ActionEvent event) {
        TiquetesMenu("VerTiqueteEmpleado", "Tickets");
    }

    @FXML
    private void Tik_Home(ActionEvent event) {
         TiquetesMenu("MenuEmpleado", "Home");
    }

    @FXML
    private void Tik_BarProcess(ActionEvent event) {
         TiquetesMenu("procesarTiquetes", "Tickets");
    }

    @FXML
    private void SaveAll(ActionEvent event) {
        int priority = 0;
            switch (cb_status.getSelectionModel().getSelectedItem()) {
                case "Analyzing":
                    priority = 2;
                    break;
                case "Checked":
                    priority = 3;
                    break;
                case "Approved":
                    priority = 4;
                    break;
                default:
                    priority = 1;
                    break;
            }
        h.procesarTiquete(priority, txt_Solution.getText(), tiquete);
        tiquete.setEstado(Integer.toString(priority));
        tiquete.setSolucion(txt_Solution.getText());
        Hilo();
    }
    
    private void Hilo(){
          new Thread(new Runnable() {
            double progress = 0.0;
            boolean continuar = true;
            double size = calcularSize(tiquete.getEstado());
            
            public void run() {
                try {
                    while (continuar) {
                        progress = (double) Math.round(progress * 100d) / 100d;
                        ProgressBar.setProgress(progress);
                        if (progress == size) {
                            continuar = false;
                        } else {
                            progress += 0.01;
                            Thread.sleep(100);
                        }
                        switch ((int) (progress * 100)) {
                            case 25:
                                btnSend.setDisable(false);
                                break;
                            case 50:
                                btnAnalyzing.setDisable(false);
                                break;
                            case 75:
                                btnChecked.setDisable(false);
                                break;
                            case 100:
                                btnApproved.setDisable(false);
                                break;
                        }
                    }
                } catch (InterruptedException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            
            private double calcularSize(String estado) {
                switch (estado) {
                    case "2":
                        return 0.50;
                    case "3":
                        return 0.75;
                    case "4":
                        return 1.0;
                    default:
                        return 0.25;
                }
            }
        }).start();
    }
}
