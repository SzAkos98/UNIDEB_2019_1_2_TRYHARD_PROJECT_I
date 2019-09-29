package hu.unideb.inf.main;

import hu.unideb.inf.utils.HibernateUtils;
import javafx.application.Application;
import javafx.stage.Stage;
import static hu.unideb.inf.controller.utils.FXUtils.*;

public class MainApp extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainApp.primaryStage = primaryStage;
        configScene(loadFxml("/fxml/MainMenu.fxml"));
        askConfirmationOnClose(primaryStage);
        HibernateUtils.getSessionFactory();
    }

    public static void main(String[] args){
        launch(args);
    }
}
