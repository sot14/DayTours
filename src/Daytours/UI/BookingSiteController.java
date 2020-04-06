package Daytours.UI;

import javafx.event.ActionEvent;
import Daytours.Controller.BookingController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class BookingSiteController {
    @FXML
    public Button tilBakaButton;

    BookingController bookingController;
    int tourID; //sækja frá booking síðu

    public void initialize() {
        bookingController = new BookingController();
    }
    public void bookTour(ActionEvent actionEvent) {
        bookingController.bookTour(tourID);
    }

    public void hotelPickupHandler(ActionEvent actionEvent) {

    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. index glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/ReviewSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/ReviewSite.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setOpacity(1);
        stage2.setTitle("Nafn á völdum tour");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.showAndWait();
    }
}
