package hu.unideb.inf.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

import static hu.unideb.inf.controller.utils.FXUtils.configScene;
import static hu.unideb.inf.controller.utils.FXUtils.loadFxml;


public class DeleteBookController {

    public void handleSelection(MouseEvent mouseEvent) {
    }

    public void handleDelete(ActionEvent actionEvent) {
    }

    public void handleBack(ActionEvent actionEvent) throws IOException {
        configScene(loadFxml("/fxml/MainMenu.fxml"));

    }
}
