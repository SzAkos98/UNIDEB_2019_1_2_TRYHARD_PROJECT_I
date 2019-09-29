package hu.unideb.inf.controller.utils;

import hu.unideb.inf.main.MainApp;
import hu.unideb.inf.model.Book;
import hu.unideb.inf.model.Person;
import hu.unideb.inf.utils.DBUtils;
import hu.unideb.inf.utils.DataTypes;
import hu.unideb.inf.utils.Tables;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class FXUtils {

    public static Parent loadFxml(String name) throws IOException {
        return FXMLLoader.load(FXUtils.class.getResource(name));
    }

    public static void askConfirmationOnClose(Stage stage){
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Megerősítés");
                alert.setHeaderText("Kilépés");
                alert.setContentText("Biztosan kilépsz?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    Platform.exit();
                }
                else {
                    event.consume();
                }
            }
        });
    }

    public static void configScene(Parent root){
        Scene scene = new Scene(root);

        scene.getStylesheets().add("style/style.css");
        MainApp.primaryStage.setMaximized(true);
        MainApp.primaryStage.setScene(scene);
        MainApp.primaryStage.show();
    }

    public static boolean textFieldIsEmpty(TextField field){
        if(field.getText().replaceAll("\\s+","").isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    public static Alert generateAlert(Alert.AlertType type, String title, String header, String content){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert;
    }

    public static String wrapValue(TextField value, DataTypes type){
        if(type == DataTypes.NUMBER){
            return value.getText();
        }
        else {
            return "\'" + value.getText() + "\'";
        }
    }

    public static void refreshBookTableView(TableView<Book> tableView, String command){
        tableView.setItems(DBUtils.runQuery(command, Tables.BOOK));
        TableColumn<Book, Long> bookId = new TableColumn<>("Azonosító");
        bookId.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn<Book, String> bookAuthor = new TableColumn<>("Szerző");
        bookAuthor.setCellValueFactory(new PropertyValueFactory("author"));

        TableColumn<Book, Integer> bookTitle = new TableColumn<>("Cím");
        bookTitle.setCellValueFactory(new PropertyValueFactory("title"));

        TableColumn<Book, Integer> bookPublisher = new TableColumn<>("Kiadó");
        bookPublisher.setCellValueFactory(new PropertyValueFactory("publisher"));

        TableColumn<Book, Integer> bookpublishyear = new TableColumn<>("Kiadás éve");
        bookpublishyear.setCellValueFactory(new PropertyValueFactory("yearOfPublication"));


        tableView.getColumns().setAll(bookId, bookAuthor, bookTitle, bookPublisher, bookpublishyear);
    }

    public static void refresPersonTableView(TableView<Person> tableView,String command){
        tableView.setItems(DBUtils.runQuery(command,Tables.PERSON));
        TableColumn<Person, Long> personId = new TableColumn<>("Azonosító");
        personId.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn<Person, String> personFirstName = new TableColumn<>("Keresztnév");
        personFirstName.setCellValueFactory(new PropertyValueFactory("firstName"));

        TableColumn<Person, String> personLastName = new TableColumn<>("Vezetéknév");
        personLastName.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn<Person, Date> personBirthDate = new TableColumn<>("Születésnap");
        personBirthDate.setCellValueFactory(new PropertyValueFactory("BirthDate"));

        TableColumn<Person, String> personAdress = new TableColumn<>("Cím");
        personAdress.setCellValueFactory(new PropertyValueFactory("adress"));


        tableView.getColumns().setAll(personId ,personFirstName , personLastName , personBirthDate ,personAdress);
    }

   public static java.sql.Date parseDate(String string) throws ParseException {
       return new java.sql.Date(new SimpleDateFormat("yyyy.MM.dd").parse(string).getTime());
   }
}
