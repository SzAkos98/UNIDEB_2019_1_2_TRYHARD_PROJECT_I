package hu.unideb.inf.controller.utils;

import hu.unideb.inf.main.MainApp;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
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

        MainApp.primaryStage.setScene(scene);
        MainApp.primaryStage.show();
    }


}
