package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerShowTable implements Initializable {

    @FXML
    private TableView hoursTable;

    @FXML
    private Button backToMainMenu;

    @FXML
    public void backToMainMenu() throws IOException {
            Stage stage = (Stage) backToMainMenu.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn hourColumn = new TableColumn("Hour");
        hourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));

        TableColumn mondayColumn = new TableColumn("Monday");
        mondayColumn.setCellValueFactory(new PropertyValueFactory<>("mondaySubj"));

        TableColumn tuesdayColumn = new TableColumn("Tuesday");
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>("tuesdaySubj"));

        TableColumn wednesdayColumn = new TableColumn("Wednesday");
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>("wednesdaySubj"));

        TableColumn thursdayColumn = new TableColumn("Thursday");
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>("thursdaySubj"));

        TableColumn fridayColumn = new TableColumn("Friday");
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>("fridaySubj"));

        hoursTable.getColumns().addAll(hourColumn, mondayColumn, tuesdayColumn, wednesdayColumn, thursdayColumn, fridayColumn);

        hoursTable.getItems().addAll(JSONReader.getTimeRow());


    }
}
