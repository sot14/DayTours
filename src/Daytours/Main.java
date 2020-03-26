package Daytours;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Daytours.Controller.TourController;


public class Main extends Application {
    public TourController tourC;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("IndexSite.fxml"));
        primaryStage.setTitle("Dagsferðir ehf");
        primaryStage.setScene(new Scene(root, 700, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
