package Daytours;

import Daytours.Database.DataBaseManager;
import Daytours.UI.IndexSiteController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DataBaseManager db = new DataBaseManager();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/IndexSite.fxml"));
        Parent root = fxmlLoader.load();
        IndexSiteController controller = fxmlLoader.getController();
        controller.init(db);
        primaryStage.setTitle("Dagsferðir ehf");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.show();
    }


    public static void main(String[] args) { launch(args);}
}
