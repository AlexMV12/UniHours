package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerShowTable implements Initializable {

    @FXML
    private TableView hoursTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TimeRow example = new TimeRow("8.30", "ex", "ex", "ex", "ex", "ex");
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


    }
}
