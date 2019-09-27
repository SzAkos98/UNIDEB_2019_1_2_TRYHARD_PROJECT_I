package hu.unideb.inf.main;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static hu.unideb.inf.controller.utils.FXUtils.*;

public class MainApp extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        Parent root = loadFxml("/fxml/MainMenu.fxml");
        Scene scene = new Scene(root);

        scene.getStylesheets().add("style/style.css");
        askConfirmationOnClose(primaryStage);
        primaryStage.setTitle("BookLoan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
