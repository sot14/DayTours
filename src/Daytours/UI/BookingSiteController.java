package Daytours.UI;

import Daytours.Controller.TourController;
import Daytours.Model.Tour;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import Daytours.Controller.BookingController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Booking;

import java.io.IOException;


public class BookingSiteController {
    @FXML
    public Button tilBakaButton;
    public TextField nameField;
    public String name;
    public TextField phoneNoField;
    public String phoneNo;
    public TextField addressField;
    public String hotelAddress;
    public Button bookButton;
    public CheckBox hotelPickupBox;
    public boolean hotelPickup = false;
    public TextField cardNumber;
    public String cardNo;
    public ChoiceBox<Integer> month;
    public ChoiceBox<Integer> year;
    public Label tourNameField;
    public ComboBox<Integer> numParticipantsBox;
    public Text popUpMessage;
    public Booking booking;
    public Label tilBorgunar;

    private BookingController bookingController;
    private TourController tourController;
    private Tour tour;
    int numParticipants;

    public void init(Tour tour, DataBaseManager db) {
        this.bookingController = new BookingController(db);
        this.tourController = new TourController(db);
        this.tour = tour;
        ObservableList<Integer> noParticipantsList = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8);
        ObservableList<Integer> dayList = FXCollections.observableArrayList();
        ObservableList<Integer> monthList = FXCollections.observableArrayList();
        ObservableList<Integer> yearList = FXCollections.observableArrayList(2020, 2021, 2022, 2023, 2024, 2025);

        for(int i = 1; i <= 31; i++) {
            dayList.add(i);
            if(i < 13) monthList.add(i);
        }
        String tourName = tour.getTourName();
        this.tourNameField.setText(tourName);
        numParticipantsBox.setItems(noParticipantsList);
        month.setItems(monthList);
        year.setItems(yearList);
        tilBorgunar.setText("");
        addressField.setDisable(true);
    }
    public void bookTour(ActionEvent actionEvent) {
        phoneNo = phoneNoField.getText();
        cardNo = cardNumber.getText();
        int tourID = tour.getTourID();
        this.name = nameField.getText();
        numParticipants = numParticipantsBox.getSelectionModel().getSelectedIndex() + 1;
        hotelAddress = addressField.getText();
        booking = new Booking(phoneNo, cardNo, tourID, hotelPickup, name, numParticipants, hotelAddress);

        checkBookingInfo();;
    }

    public void checkBookingInfo() {
        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        //popup.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);

        if (this.name.length() <= 0) dialogVbox.getChildren().add(new Text("Vinsamlegast skrifið nafnið ykkar"));
        else if (numParticipantsBox.getSelectionModel().isEmpty()) dialogVbox.getChildren().add(new Text("Vinsamlegast veljið fjölda ferðalanga"));
        else if (month.getSelectionModel().isEmpty() || year.getSelectionModel().isEmpty() || this.cardNo.length() <= 0) {
            dialogVbox.getChildren().add(new Text("Vinsamlegast fyllið út kortaupplýsingar"));
        }
        else if (this.phoneNo.length() < 7) dialogVbox.getChildren().add(new Text("Vinsamlegast sláið inn símanúmer"));
        else {
            dialogVbox.getChildren().add(new Text("Bókun móttekin, takk fyrir viðskiptin"));
            bookingController.bookTour(booking);
            dialogVbox.getChildren().add(new Text("Bókunarnúmerið þitt er: " + booking.getBookingId()));
            tourController.changeTourSeatsLeft(tour.getTourID(), numParticipants, tour.getParticipantNum(), true);
            System.out.println(tour.getTourID() + "Fjöldi er " + numParticipants + "Pláss er " + tour.getParticipantNum());
        }

        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        popup.setScene(dialogScene);
        popup.show();
    }

    public void hotelPickupHandler(ActionEvent actionEvent) {
        hotelPickup = !hotelPickup;
        addressField.setDisable(!addressField.isDisabled());
    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. booking glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. review glugga
        //System.out.println(IndexSiteController.class.getResource("/Daytours/UI/ReviewSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/ReviewSite.fxml"));
        Parent root = fxmlLoader.load();
        ReviewSiteController controller = fxmlLoader.getController();
        controller.init(tour, bookingController.getDb());
        Stage stage2 = new Stage();
        stage2.setTitle(tour.getTourName());
        stage2.setScene(new Scene(root, 900, 750));
        stage2.show();
    }

    public void uppfaeraVerd(ActionEvent dragEvent) {
        numParticipants = numParticipantsBox.getSelectionModel().getSelectedIndex() + 1;
        String verd = Integer.toString((int) (numParticipants * tour.getPrice()));
        tilBorgunar.setText(verd + " kr.");
    }
}
