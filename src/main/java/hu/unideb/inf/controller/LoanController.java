package hu.unideb.inf.controller;

import hu.unideb.inf.model.Loan;
import hu.unideb.inf.model.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

import static hu.unideb.inf.controller.utils.FXUtils.*;

public class LoanController {

    @FXML
    TableView<Person> table;

    public static Person person = null;

    @FXML
    public void initialize(){
        refresPersonTableView(table, "");
    }

    public void handleSelection(MouseEvent mouseEvent) {

    }

    public void handleAdding(ActionEvent actionEvent) throws IOException {
        Person person = table.getSelectionModel().getSelectedItem();
        if(person  == null){
            generateAlert(Alert.AlertType.ERROR, "Kölcsönzés", "Tag", "Nincs kiválasztott tag!").show();
        }
        else {
            LoanController.person = person;
            configScene(loadFxml("/fxml/BookLoan.fxml"));
        }

    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));

    }

    public void handleSearch(ActionEvent actionEvent) {
    }


}
