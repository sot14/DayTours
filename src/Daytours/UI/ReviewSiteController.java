package Daytours.UI;

import Daytours.Controller.ReviewController;
import Daytours.Controller.TourController;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Review;
import Daytours.Model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReviewSiteController {

    @FXML
    public Button bokaFerdButton;
    @FXML
    public Button tilBakaButton;
    @FXML
    public Label tourNafn;
    @FXML
    public Label company;
    @FXML
    public Label date;
    @FXML
    public Label length;
    @FXML
    public Label loc;
    @FXML
    public TextArea info;
    @FXML
    public Label price;
    @FXML
    public Label participants;
    @FXML
    public TextArea reviews;

    public Tour tour;
    ReviewController reviewController;
    public TourController tourController;

    public void init(Tour tour, DataBaseManager db){
        this.tour = tour;
        reviewController = new ReviewController(db);
        tourController = new TourController(db);
        synaTour();
    }

    public void synaTour() {
        tourNafn.setText(tour.getTourName());
        company.setText(tour.getCompany());

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(tour.getDate());
        date.setText(strDate);

        String lengd = String.valueOf(tour.getLength());
        length.setText(lengd + " klst.");

        loc.setText(tour.getLocation());

        info.setText(tour.getTourInfo());
        info.setWrapText(true);

        String verd = String.valueOf(tour.getPrice());
        price.setText(verd + " kr");

        String fjoldi = String.valueOf(tour.getParticipantNum());
        participants.setText(fjoldi);
    }

    public void synaReview() {

    }


    public void bokaFerdHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) bokaFerdButton.getScene().getWindow();
        stage.close();

        //opna næsta glugga þ.e. booking glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/BookingSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/BookingSite.fxml"));
        Parent root = fxmlLoader.load();
        BookingSiteController controller = fxmlLoader.getController();
        controller.init(tour, tourController.getDb());
        Stage stage2 = new Stage();
        stage2.setTitle("Bóka tour");
        stage2.setScene(new Scene(root, 600, 400));
        stage2.show();
    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. index glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/IndexSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/IndexSite.fxml"));
        Parent root = fxmlLoader.load();
        IndexSiteController controller = fxmlLoader.getController();
        controller.init(tourController.getDb());
        Stage stage2 = new Stage();
        stage2.setTitle("Dagsferðir ehf");
        stage2.setScene(new Scene(root, 900, 600));
        stage2.show();
    }
}
