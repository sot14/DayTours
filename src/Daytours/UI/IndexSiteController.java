package Daytours.UI;
import Daytours.Controller.BookingController;
import Daytours.Controller.TourController;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Booking;
import Daytours.Model.Tour;
import Daytours.UI.ReviewSiteController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    public Label lengthLabel;
    @FXML
    public Label priceLabel;
    @FXML
    public Button afbokaFerdButton;
    @FXML
    public ImageView landshlutiMynd;
    @FXML
    private ListView <Tour> tourList;
    @FXML
    private TextField leitaFerd;
    @FXML
    private Button veljaFerdButton;

    private TourController tourController;
    private BookingController bookingController;
    int tourID;

    private Tour tour;
    String searchString = "";
    int chosenLength = 12;
    String chosenLandshluti = "";
    Date fraDate = Date.valueOf("1980-01-01");
    Date tilDate = Date.valueOf("2050-01-01");
    int chosenPrice = 17000;



    public Image AlltLandiðImg = new Image("Daytours/Img/AlltLandid.png");
    public Image AusturlandImg = new Image("Daytours/Img/Austurland.png");
    public Image HöfuðborgarsvæðiðImg = new Image("Daytours/Img/Hofudborgarsvaedid.png");
    public Image NorðurlandImg = new Image("Daytours/Img/Nordurland.png");
    public Image SuðurlandImg = new Image("Daytours/Img/Sudurland.png");
    public Image VestfirðirImg = new Image("Daytours/Img/Vestfirdir.png");
    public Image VesturlandImg = new Image("Daytours/Img/Vesturland.png");



    public void init(DataBaseManager db) {
        tourController = new TourController(db);
        bookingController = new BookingController(db);
        setTourList();
        landshlutiCombobox.getItems().removeAll(landshlutiCombobox.getItems());
        landshlutiCombobox.getItems().addAll("Allt landið", "Höfuðborgarsvæðið", "Vesturland", "Vestfirðir", "Norðurland", "Austurland", "Suðurland");
        landshlutiCombobox.getSelectionModel().select("Allt landið");

        leitaFerd.textProperty().addListener((observable, oldValue, newValue) -> {
            searchString=leitaFerd.getText();
            ArrayList<Tour> listOfTours;
            if(chosenLandshluti.equals("Allt landið")) {
                listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, "", chosenLength);
            }
            else {
                listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, chosenLandshluti, chosenLength);
            }
            ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
            tourList.setItems(listViewTours);
        });
        veljaFerdButton.setDisable(true);
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
            //System.out.println(IndexSiteController.class.getResource("/Daytours/UI/ReviewSite.fxml"));

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/ReviewSite.fxml"));
            Parent root = fxmlLoader.load();
            ReviewSiteController reviewsitecontroller = fxmlLoader.getController();
            reviewsitecontroller.init(tour, tourController.getDb());
            Stage stage2 = new Stage();
            stage2.setTitle(tour.getTourName());
            stage2.setScene(new Scene(root, 900, 750));
            stage2.show();

    }

    // atburðarhandler á sleðanum sem notaður er til að velja hámarkslengd ferða
    public void lengdSliderHandler(MouseEvent mouseEvent) {
        chosenLength = (int)lengdSlider.getValue();
        //ArrayList<Tour> listOfTours = tourController.getAllToursWithMaxLength(chosenLength);
        ArrayList<Tour> listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, chosenLandshluti, chosenLength);
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);
        lengthLabel.setText(Integer.toString(chosenLength));
    }

    // atburðahandler fyrir hvaða landshluti er valinn
    public void landshlutiHandler(ActionEvent actionEvent) {
        chosenLandshluti = landshlutiCombobox.getSelectionModel().getSelectedItem().toString();
        ArrayList<Tour> listOfTours;
        if(chosenLandshluti.equals("Allt landið")) {
            listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, "", chosenLength);
        }
        else {
            listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, chosenLandshluti, chosenLength);
        }
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);

        //myndabirting


        switch(chosenLandshluti) {
            case "Allt landið":
                landshlutiMynd.setImage(AlltLandiðImg);
                break;
            case "Austurland":
                landshlutiMynd.setImage(AusturlandImg);
                break;
            case "Höfuðborgarsvæðið":
                landshlutiMynd.setImage(HöfuðborgarsvæðiðImg);
                break;
            case "Norðurland":
                landshlutiMynd.setImage(NorðurlandImg);
                break;
            case "Suðurland":
                landshlutiMynd.setImage(SuðurlandImg);
                break;
            case "Vestfirðir":
                landshlutiMynd.setImage(VestfirðirImg);
                break;
            case "Vesturland":
                landshlutiMynd.setImage(VesturlandImg);
                break;
        }
    }

    // atburðarhandler fyrir hvaða dagsetninga tímabil er valið
    public void timabilHandler(ActionEvent actionEvent) {
        LocalDate fra = fraDatePicker.getValue();
        LocalDate til = tilDatePicker.getValue();


        // passa að búið sé að velja bæði frá og til dagsetningu
        if(fra != null && til!=null) {
            if (fra.isAfter(til)) {
                System.out.println("*** Ólöglegt val á tímabili. *** ");
                System.out.println("Byrjunardagsetning á tímabilinu kemur á eftir endadagsetningu tímabilsins.");
            }
            else {
                fraDate = Date.valueOf(fra);
                tilDate = Date.valueOf(til);
                ArrayList<Tour> listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, chosenLandshluti, chosenLength);
                ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
                tourList.setItems(listViewTours);
            }
        }

    }

    public void verdSliderHandler(MouseEvent mouseEvent) {
        chosenPrice = (int)verdSlider.getValue();
        ArrayList<Tour> listOfTours = tourController.getFilteredTours(searchString, chosenPrice, fraDate, tilDate, chosenLandshluti, chosenLength);
        ObservableList<Tour> listViewTours = FXCollections.observableArrayList(listOfTours);
        tourList.setItems(listViewTours);
        priceLabel.setText(Integer.toString(chosenPrice));
    }


    public void afbokaFerdHandler(ActionEvent actionEvent) {
        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        //popup.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        TextField bokunarnumer = new TextField();
        Button afbokaFerdButton2 = new Button("Afbóka ferð");


        dialogVbox.getChildren().add(new Text("Sláðu inn bókunarnúmer"));
        dialogVbox.getChildren().add(new Label("Bókunarnúmer:"));
        dialogVbox.getChildren().add(bokunarnumer);
        dialogVbox.getChildren().add(afbokaFerdButton2);
        Scene dialogScene = new Scene(dialogVbox, 300, 200);
        popup.setScene(dialogScene);
        popup.show();

        EventHandler<ActionEvent> afbokaFerd = event -> {
            int bokunarnumerInput = Integer.parseInt(bokunarnumer.getText());
            Booking booking = bookingController.getBooking(bokunarnumerInput);
            int bookingTourID = booking.getTourID();
            System.out.println("Bókuninni þinni á ferðinni: " + tourController.getTour(bookingTourID).getTourName() + " á nafninu " + booking.getParticipantName() + " hefur verið eytt");
            Tour afbokadTour = tourController.getTour(bookingTourID);
        };
        afbokaFerdButton2.setOnAction(afbokaFerd);
    }

    public void ytaAFerdHandler(MouseEvent mouseEvent) {
        //Takkinn að velja ferð virkjast þegar við ýtum á ferð í listView
        veljaFerdButton.setDisable(false);
    }
}
