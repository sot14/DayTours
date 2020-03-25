package Daytours.UI;
import Daytours.Controller.BookingController;
import Daytours.Controller.TourController;
import Daytours.Model.Tour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class IndexController {

    TourController tourController;

    @FXML
    ListView <Tour> tourList;

    int tourID;

    public void setTourList(){
        ArrayList<Tour> listOfTours = tourController.getAllTours();
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        // bæta einum tour við í einu?
        tourList = new ListView<Tour>(listViewTours);
    }

    // atburðar handler fyrir velja ferð takkann á forsíðu
    public void veljaFerdHandler(ActionEvent actionEvent) {
        System.out.println("prufa");


    }


}
