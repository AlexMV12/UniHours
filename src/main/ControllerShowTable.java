package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        // First, create all the columns for the table...

        List<TableColumn> tableColumns = new ArrayList<>();

        TableColumn hourColumn = new TableColumn("Hour");
        hourColumn.setCellValueFactory(new PropertyValueFactory<>("hour"));
        tableColumns.add(hourColumn);

        TableColumn mondayColumn = new TableColumn("Monday");
        mondayColumn.setCellValueFactory(new PropertyValueFactory<String, String>("mondaySubj"));
        tableColumns.add(mondayColumn);

        TableColumn tuesdayColumn = new TableColumn("Tuesday");
        tuesdayColumn.setCellValueFactory(new PropertyValueFactory<>("tuesdaySubj"));
        tableColumns.add(tuesdayColumn);

        TableColumn wednesdayColumn = new TableColumn("Wednesday");
        wednesdayColumn.setCellValueFactory(new PropertyValueFactory<>("wednesdaySubj"));
        tableColumns.add(wednesdayColumn);

        TableColumn thursdayColumn = new TableColumn("Thursday");
        thursdayColumn.setCellValueFactory(new PropertyValueFactory<>("thursdaySubj"));
        tableColumns.add(thursdayColumn);

        TableColumn fridayColumn = new TableColumn("Friday");
        fridayColumn.setCellValueFactory(new PropertyValueFactory<>("fridaySubj"));
        tableColumns.add(fridayColumn);

        // ... then add them to the Table and fetch the rows through the static method getTimeRow().

        hoursTable.getColumns().addAll(tableColumns);

        hoursTable.getItems().addAll(JSONReader.getTimeRow());

        /* Now, for each column, try to pair the content of the cell with the hashmap which links subjects and
           colours.
         */

        HashMap<String, Colour> subjects = JSONReader.getSubjects();

        for (TableColumn tableColumn : tableColumns) {
            tableColumn.setCellFactory(new Callback<TableColumn, TableCell>() {
                public TableCell call(TableColumn param) {
                    return new TableCell<String, String>() {

                        @Override
                        public void updateItem(String item, boolean empty) {
                            super.updateItem(item, empty);
                            if (!isEmpty()) {
                                Colour colour = subjects.getOrDefault(item, Colour.BLACK);
                                this.setTextFill(Color.valueOf(colour.toString()));
                                setText(item);
                            }
                        }
                    };
                }
            });

        }

    }
}
