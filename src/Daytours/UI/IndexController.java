package Daytours.UI;
import Daytours.Controller.BookingController;
import Daytours.Controller.TourController;
import Daytours.Model.Tour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    private TourController tourController;

    @FXML
    private ListView <Tour> tourList;
    @FXML
    private TextField leitaFerd;

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
    public void veljaFerdHandler(ActionEvent actionEvent) {
        //Nær í ID á Tour sem er valinn
        tourID = tourList.getSelectionModel().getSelectedItem().getTourID();
        System.out.println(tourID);
    }

    public void leitaFerdHandler(ActionEvent actionEvent) {
        String l = leitaFerd.getText();
        ArrayList<Tour> listOfTours = tourController.searchTour(l);
        updateTour(FXCollections.observableArrayList(listOfTours));
    }


}
