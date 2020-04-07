package Daytours.UI;

import Daytours.Controller.ReviewController;
import Daytours.Controller.TourController;
import Daytours.Model.Tour;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ReviewSiteController {

    @FXML
    public Button bokaFerdButton;
    @FXML
    public Button tilBakaButton;
    @FXML
    public Label tourNafn;

    //ReviewController reviewController;
    //TourController tourController;

    public void setjaTourNafn(String tour) {
        tourNafn.setText(tour);
    }

    public void bokaFerdHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) bokaFerdButton.getScene().getWindow();
        stage.close();

        //opna næsta glugga þ.e. booking glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/BookingSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/BookingSite.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setOpacity(1);
        stage2.setTitle("Bóka tour");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.showAndWait();
    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. index glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/IndexSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/IndexSite.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setOpacity(1);
        stage2.setTitle("Daytours");
        stage2.setScene(new Scene(root, 910, 610));
        stage2.showAndWait();
    }
}
