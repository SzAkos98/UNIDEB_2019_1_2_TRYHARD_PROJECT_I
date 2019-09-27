package hu.unideb.inf.controller;


import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static hu.unideb.inf.controller.utils.FXUtils.configScene;
import static hu.unideb.inf.controller.utils.FXUtils.loadFxml;

public class BookLoanController {

    public void handleSelection(MouseEvent mouseEvent) {
    }

    public void handleCartSelection(MouseEvent mouseEvent) {
    }

    public void handleTyping(KeyEvent keyEvent) {
    }

    public void handleAddToLoan(ActionEvent actionEvent) {
    }

    public void handleLoan(ActionEvent actionEvent) {
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));
    }

    public void handleDeleteAllBook(ActionEvent actionEvent) {
    }

    public void handleDeleteBook(ActionEvent actionEvent) {
    }
}
