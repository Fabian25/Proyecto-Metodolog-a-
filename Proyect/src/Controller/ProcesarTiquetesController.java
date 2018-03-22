package Controller;

import Model.Tiquetes;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javax.swing.JOptionPane;

public class ProcesarTiquetesController implements Initializable {

    public final Tiquetes tiquete = new Tiquetes("1", "2", "Checked");

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
    private ComboBox<?> cb_status;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnSend.setDisable(true);
        btnApproved.setDisable(true);
        btnAnalyzing.setDisable(true);
        btnChecked.setDisable(true);

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
                    case "Analyzing":
                        return 0.50;
                    case "Checked":
                        return 0.75;
                    case "Approved":
                        return 1.0;
                    default:
                        return 0.25;
                }
            }
        }).start();
    }

}
