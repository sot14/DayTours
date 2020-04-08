package Daytours.UI;

import javafx.event.ActionEvent;
import Daytours.Controller.BookingController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class BookingSiteController {
    @FXML
    public Button tilBakaButton;
    public TextField nameField;
    public TextField phoneNoField;
    public TextField addressField;
    public Button bookButton;
    public CheckBox hotelPickupBox;
    public TextField cardNumber;
    public ChoiceBox day;
    public ChoiceBox month;
    public ChoiceBox year;
    public Label tourNameField;

    BookingController bookingController;
    ReviewSiteController reviewSiteController;
    int tourID; //sækja frá booking síðu

    public BookingSiteController() {

    }
    public void showSite() {

    }
    public void initialize() {
        bookingController = new BookingController();
        tourNameField.setText("Prófun");
    }

    public void setReviewSiteController(ReviewSiteController r) {
        reviewSiteController = r;
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

    public void bokaFerdHandler(ActionEvent actionEvent) {

    }
}
