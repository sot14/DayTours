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
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.Date;

public class IndexSiteController {

    @FXML
    public Slider lengdSlider;
    @FXML
    public ComboBox landshlutiCombobox;
    @FXML
    public DatePicker tilDatePicker;
    @FXML
    public DatePicker fraDatePicker;
    @FXML
    public Slider verdSlider;
    @FXML
    private ListView <Tour> tourList;
    @FXML
    private TextField leitaFerd;
    @FXML
    private Button veljaFerdButton;

    private TourController tourController;
    int tourID;
    private Tour tour;

    public void init(DataBaseManager db) {
        tourController = new TourController(db);
        setTourList();
        landshlutiCombobox.getItems().removeAll(landshlutiCombobox.getItems());
        landshlutiCombobox.getItems().addAll("Allt landið", "Höfuðborgarsvæðið", "Vesturland", "Vestfirðir", "Norðurland", "Austurland", "Suðurland");
        landshlutiCombobox.getSelectionModel().select("Allt landið");
    }

    public void setTourList(){
        ArrayList<Tour> listOfTours = tourController.getAllTours();
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);
        tourList.setFixedCellSize(60.0);
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

    // atburðarhandler á sleðanum sem notaður er til að velja hámarkslengd ferða
    public void lengdSliderHandler(MouseEvent mouseEvent) {
        int chosenLength = (int)lengdSlider.getValue();
        ArrayList<Tour> listOfTours = tourController.getAllToursWithMaxLength(chosenLength);
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);
    }

    // atburðahandler fyrir hvaða landshluti er valinn
    public void landshlutiHandler(ActionEvent actionEvent) {
        String chosenLandshluti = landshlutiCombobox.getSelectionModel().getSelectedItem().toString();
        if(chosenLandshluti.equals("Allt landið")) {
            setTourList();
        }
        else {
            ArrayList<Tour> listOfTours = tourController.getAllToursWithLocation(chosenLandshluti);
            ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
            tourList.setItems(listViewTours);
        }
    }

    // atburðarhandler fyrir hvaða dagsetninga tímabil er valið
    public void timabilHandler(ActionEvent actionEvent) {
        LocalDate fraDate = fraDatePicker.getValue();
        LocalDate tilDate = tilDatePicker.getValue();


        // passa að búið sé að velja bæði frá og til dagsetningu
        if(fraDate != null && tilDate!=null) {
            if (fraDate.isAfter(tilDate)) {
                System.out.println("*** Ólöglegt val á tímabili. *** ");
                System.out.println("Byrjunardagsetning á tímabilinu kemur á eftir endadagsetningu tímabilsins.");
            }
            else {
                Date fraDatesql = Date.valueOf(fraDate);
                Date tilDatesql = Date.valueOf(tilDate);
                ArrayList<Tour> listOfTours = tourController.getAllToursInsideTimePeriod(fraDatesql,tilDatesql);
                ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
                tourList.setItems(listViewTours);
            }
        }

    }

    public void verdSliderHandler(MouseEvent mouseEvent) {
        int chosenPrice = (int)verdSlider.getValue();
        System.out.println(chosenPrice);
        ArrayList<Tour> listOfTours = tourController.getAllToursCheaper(chosenPrice);
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);
    }
}
