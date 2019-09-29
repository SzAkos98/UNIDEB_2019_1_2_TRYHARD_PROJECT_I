package hu.unideb.inf.controller;

import hu.unideb.inf.controller.utils.FXUtils;
import hu.unideb.inf.model.Person;
import hu.unideb.inf.utils.DBUtils;
import hu.unideb.inf.utils.DataTypes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static hu.unideb.inf.controller.utils.FXUtils.*;

public class NewPersonController {
    @FXML
    protected TextField ID;

    @FXML
    protected TextField firstName;

    @FXML
    protected TextField surname;

    @FXML
    protected TextField birthDate;

    @FXML
    protected TextField adress;

    @FXML
    protected TableView<Person> table;

    private Map<TextField, DataTypes> filterFields = new LinkedHashMap<>();

    @FXML
    public void initialize(){
        filterFields.put(ID, DataTypes.NUMBER);
        filterFields.put(firstName, DataTypes.STRING);
        filterFields.put(surname, DataTypes.STRING);
        filterFields.put(birthDate, DataTypes.STRING);
        filterFields.put(adress, DataTypes.STRING);
        refresPersonTableView(table,"");
    }


    public void handleSelection(MouseEvent mouseEvent) {
        Person person = table.getSelectionModel().getSelectedItem();
        ID.setText(person.getId().toString());
        firstName.setText(person.getFirstName());
        surname.setText(person.getLastName());
        birthDate.setText(person.getBirthDate().toString());
        adress.setText(person.getAdress());
    }

    public void handleAdding(ActionEvent actionEvent) {

        for(Map.Entry i : filterFields.entrySet()){
            if(textFieldIsEmpty((TextField) i.getKey())){
                generateAlert(Alert.AlertType.ERROR, "Új tag", "Hozzáadás", "Valamelyik érték érvénytelen!").show();
                return;
            }
        }

        Person person = null;
        try{
            person = new Person(Long.parseLong(ID.getText()), firstName.getText(), surname.getText(), parseDate(birthDate.getText()) , adress.getText());
        }
        catch(Exception e){
            generateAlert(Alert.AlertType.ERROR, "Új tag", "Hozzáadás", "Valamelyik érték érvénytelen!").show();
            return;
        }

        DBUtils.persist(person);
        refresPersonTableView(table,"");
//        clearFields();
    }



    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));

    }
}
