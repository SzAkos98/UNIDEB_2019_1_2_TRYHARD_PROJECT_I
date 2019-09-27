package hu.unideb.inf.controller;

import hu.unideb.inf.main.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.stage.WindowEvent;

import java.io.IOException;

import static hu.unideb.inf.controller.utils.FXUtils.*;

public class MainMenuController {


    public void handleLoan(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/Loan.fxml"));

    }

    public void handleNewPerson(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/NewPerson.fxml"));

    }

    public void handleNewBook(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/NewBook.fxml"));


    }

    public void handleModBook(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/UpdateBook.fxml"));


    }

    public void handleDeleteBook(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/DeleteBook.fxml"));


    }

    public void handleModPerson(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/UpdatePerson.fxml"));


    }

    public void handleDeletePerson(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/DeletePerson.fxml"));

    }

    public void handleExit(ActionEvent actionEvent) {
        MainApp.primaryStage.fireEvent( new WindowEvent(MainApp.primaryStage, WindowEvent.WINDOW_CLOSE_REQUEST));
    }
}
