package Daytours;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class BookingSiteController {
    public TextField nameField;
    public TextField addressField;
    public TextField phoneNoField;
    public Button bookButton;
    public CheckBox hotelPickupBox;
    public boolean hotelPickup;

    public TextField getNameField() {
        return nameField;
    }

    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    public TextField getAddressField() {
        return addressField;
    }

    public void setAddressField(TextField addressField) {
        this.addressField = addressField;
    }

    public TextField getPhoneNoField() {
        return phoneNoField;
    }

    public void setPhoneNoField(TextField phoneNoField) {
        this.phoneNoField = phoneNoField;
    }

    public void hotelPickupHandler(ActionEvent actionEvent) {
        hotelPickup = hotelPickupBox.isSelected();
    }
}
