package Daytours.UI;
import Daytours.Controller.BookingController;
import Daytours.Controller.TourController;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Tour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IndexController implements Initializable {

    TourController tourController;

    @FXML
    ListView <Tour> tourList;

    public DataBaseManager db;

    int tourID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setTourList(){
        ArrayList<Tour> listOfTours = tourController.getAllTours();
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        // bæta einum tour við í einu?
        tourList = new ListView<Tour>(listViewTours);
    }

    public void updateTour(ObservableList<Tour> obs) {
        tourList.setItems(obs);
    }

    // atburðar handler fyrir velja ferð takkann á forsíðu
    public void veljaFerdHandler(ActionEvent actionEvent) {
        System.out.println("prufa");


    }


}
