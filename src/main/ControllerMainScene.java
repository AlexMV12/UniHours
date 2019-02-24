package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerMainScene implements Initializable {

    @FXML
    private VBox mainWindow;

    @FXML
    private Button buttonShowTable;

    @FXML
    private Button buttonNewTable;

    @FXML
    private void createNewTable(ActionEvent e) throws IOException {
        Stage stage = (Stage) buttonNewTable.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/newTable.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    private void showTable() throws IOException {
        Stage stage = (Stage) buttonShowTable.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/showTable.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
