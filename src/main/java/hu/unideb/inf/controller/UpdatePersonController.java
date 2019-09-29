package hu.unideb.inf.controller;

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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static hu.unideb.inf.controller.utils.FXUtils.*;

public class UpdatePersonController {
    @FXML
    protected TextField ID;

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
    private static String condition;

    @FXML
    public void initialize(){
        filterFields.put(ID, DataTypes.NUMBER);
        filterFields.put(firstName, DataTypes.STRING);
        filterFields.put(lastName, DataTypes.STRING);
        filterFields.put(birthDate, DataTypes.STRING);
        filterFields.put(adress, DataTypes.STRING);
        refresPersonTableView(table,"");
    }


    public void handleSelection(MouseEvent mouseEvent) {
        Person person = table.getSelectionModel().getSelectedItem();
        ID.setText(person.getId().toString());
        firstName.setText(person.getFirstName());
        lastName.setText(person.getLastName());
        birthDate.setText(person.getBirthDate().toString());
        adress.setText(person.getAdress());
    }


    public void handleMod(ActionEvent actionEvent) {

        StringBuilder queryCommand = new StringBuilder("UPDATE Person SET ");
        String extend;
        int x =0;
        ArrayList<String> prefix = new ArrayList<>();
        prefix.add("id = ");
        prefix.add("firstName = ");
        prefix.add("lastName = ");
        prefix.add("birthDate = ");
        prefix.add("adress = ");


        for(Map.Entry i : filterFields.entrySet()){
            if (x==0) {
                condition=ID.getText();
                x++;
                continue;
            } else if(textFieldIsEmpty((TextField) i.getKey())){
                generateAlert(Alert.AlertType.ERROR, "Tag adatainak módosítása", "Módosítás", "Valamelyik érték érvénytelen!").show();
                x=0;
                return;
            } else {
                extend = wrapValue((TextField) i.getKey(), (DataTypes) i.getValue());
                queryCommand.append(prefix.get(x) + extend + " , ");
                x++;
            }
        }

        queryCommand.delete(queryCommand.length() - 3, queryCommand.length()).append("WHERE id = " + condition);
        DBUtils.updateTable(queryCommand.toString());
        refresPersonTableView(table, "");
        clearFields();
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));
    }

    private void clearFields(){
        for(Map.Entry i : filterFields.entrySet()){
            TextField textField = (TextField) i.getKey();
            textField.setText("");
        }
    }
}
