package Daytours.Controller;

import Daytours.Model.Booking;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BookingController {
    public TextField nameField;
    public TextField addressField;
    public TextField phoneNoField;
    public Button bookButton;
    public CheckBox hotelPickupBox;
    public boolean hotelPickup;
    public Booking booking;
    public TextField cardNumber;
    public ChoiceBox day;
    public ChoiceBox year;
    public ChoiceBox month;

    public String getName() {
        return nameField.getText();
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public String getAddressField() {
        return addressField.getText();
    }

    public void setAddressField(TextField addressField) {
        this.addressField = addressField;
    }

    public String getPhoneNoField() {
        return phoneNoField.getText();
    }

    public void setPhoneNoField(TextField phoneNoField) {
        this.phoneNoField = phoneNoField;
    }

    public void hotelPickupHandler(ActionEvent event) {
        hotelPickup = hotelPickupBox.isSelected();
    }

    public String getCardNumber() {
        return cardNumber.getText();
    }

    public void setCardNumber(TextField cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void bookTour() {
        String participants = getName(); //laga fjölda
        booking.setParticipants(participants); //laga hér þannig að margir geti verið í einu booking
        booking.setHotelPickup(hotelPickup);
        booking.setPhoneNo(getPhoneNoField());
        booking.setHotelAddress(getAddressField());
        booking.setCardNo(getCardNumber());
    }
}
