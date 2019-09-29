package hu.unideb.inf.controller;

import hu.unideb.inf.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

import static hu.unideb.inf.controller.utils.FXUtils.configScene;
import static hu.unideb.inf.controller.utils.FXUtils.loadFxml;

public class LoanController {

    @FXML
    TableView<Person> table;

    public void handleSelection(MouseEvent mouseEvent) {

    }

    public void handleAdding(ActionEvent actionEvent) {
        Person person = table.getSelectionModel().getSelectedItem();
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));

    }

    public void handleSearch(ActionEvent actionEvent) {
    }
}
