package Daytours.UI;
import Daytours.Controller.TourController;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Tour;
import Daytours.UI.ReviewSiteController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IndexSiteController {


    private TourController tourController;

    @FXML
    private ListView <Tour> tourList;
    @FXML
    private TextField leitaFerd;
    @FXML
    public Button veljaFerdButton;

    Tour tour;

    public void init(DataBaseManager db) {
        tourController = new TourController(db);
        setTourList();
    }

    public void setTourList(){
        ArrayList<Tour> listOfTours = tourController.getAllTours();
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);
    }

    public void updateTour(ObservableList<Tour> obs) {
        tourList.setItems(obs);
    }

    // atburðar handler fyrir velja ferð takkann á forsíðu
    public void veljaFerdHandler(ActionEvent actionEvent) throws IOException {
        //Nær í þann Tour sem er valinn
        tour = tourList.getSelectionModel().getSelectedItem();
        Stage stage = (Stage) veljaFerdButton.getScene().getWindow();
        //loka núverandi glugga þ.e. tours glugga
        stage.close();

        //opna næsta glugga þ.e. tour&review glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/ReviewSite.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/ReviewSite.fxml"));
        Parent root = fxmlLoader.load();
        ReviewSiteController reviewsitecontroller = fxmlLoader.getController();
        reviewsitecontroller.init(tour, tourController.getDb());
        Stage stage2 = new Stage();
        stage2.setTitle(tour.getTourName());
        stage2.setScene(new Scene(root, 600, 400));
        stage2.show();
    }

    public void leitaFerdHandler(ActionEvent actionEvent) {
        String l = leitaFerd.getText();
        ArrayList<Tour> listOfTours = tourController.searchTour(l);
        updateTour(FXCollections.observableArrayList(listOfTours));

    }
}
