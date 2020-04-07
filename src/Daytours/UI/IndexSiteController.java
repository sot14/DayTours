package Daytours.UI;
import Daytours.Controller.TourController;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IndexSiteController implements Initializable {


    private TourController tourController;

    @FXML
    private ListView <Tour> tourList;
    @FXML
    private TextField leitaFerd;
    @FXML
    public Button veljaFerdButton;

    int tourID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tourController = new TourController();
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
        //Nær í ID á Tour sem er valinn
        tourID = tourList.getSelectionModel().getSelectedItem().getTourID();
        String tourName = tourList.getSelectionModel().getSelectedItem().getTourName();
        System.out.println(tourID);
        Stage stage = (Stage) veljaFerdButton.getScene().getWindow();
        //loka núverandi glugga þ.e. tours glugga
        stage.close();

        //opna næsta glugga þ.e. tour&review glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/ReviewSite.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/ReviewSite.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage2 = new Stage();
        stage2.initModality(Modality.APPLICATION_MODAL);
        stage2.setOpacity(1);
        stage2.setTitle(tourName);
        stage2.setScene(new Scene(root, 600, 400));
        stage2.showAndWait();

    }

    public void leitaFerdHandler(ActionEvent actionEvent) {
        String l = leitaFerd.getText();
        ArrayList<Tour> listOfTours = tourController.searchTour(l);
        updateTour(FXCollections.observableArrayList(listOfTours));
    }



}
