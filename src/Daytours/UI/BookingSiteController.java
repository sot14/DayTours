package Daytours.UI;

import Daytours.Database.DataBaseManager;
import Daytours.Model.Tour;
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
    private Button tilBakaButton;

    private BookingController bookingController;
    private Tour tour;

    public void init(Tour tour, DataBaseManager db) {
        bookingController = new BookingController(db);
        this.tour = tour;
    }
    public void bookTour(ActionEvent actionEvent) {
        //bookingController.bookTour(booking);
    }

    public void hotelPickupHandler(ActionEvent actionEvent) {

    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. booking glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. review glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/ReviewSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/ReviewSite.fxml"));
        Parent root = fxmlLoader.load();
        ReviewSiteController controller = fxmlLoader.getController();
        controller.init(tour, bookingController.getDb());
        Stage stage2 = new Stage();
        stage2.setTitle(tour.getTourName());
        stage2.setScene(new Scene(root, 600, 400));
        stage2.show();
    }
}
