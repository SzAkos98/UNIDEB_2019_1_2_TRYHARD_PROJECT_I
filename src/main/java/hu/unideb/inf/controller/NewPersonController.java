package hu.unideb.inf.controller;

import hu.unideb.inf.model.Person;
import hu.unideb.inf.utils.DataTypes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static hu.unideb.inf.controller.utils.FXUtils.*;

public class NewPersonController {
    @FXML
    protected TextField id;

    @FXML
    protected TextField firstName;

    @FXML
    protected TextField lastName;

    @FXML
    protected TextField birthDate;

    @FXML
    protected TextField adress;

    @FXML
    protected TableView<Person> table;

    private Map<TextField, DataTypes> filterFields = new LinkedHashMap<>();

    @FXML
    public void initialize(){
        filterFields.put(id, DataTypes.NUMBER);
        filterFields.put(firstName, DataTypes.STRING);
        filterFields.put(lastName, DataTypes.STRING);
        filterFields.put(birthDate, DataTypes.STRING);
        filterFields.put(adress, DataTypes.NUMBER);
        refresPersonTableView(table);
    }


    public void handleSelection(MouseEvent mouseEvent) {
    }

    public void handleAdding(ActionEvent actionEvent) {
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));

    }
}
