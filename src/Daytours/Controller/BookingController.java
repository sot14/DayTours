package Daytours.Controller;

import Daytours.Model.Booking;
import Daytours.Database.DataBaseManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BookingController {
    public boolean hotelPickup;
    public Booking booking;
    public DataBaseManager db;

    public void bookTour(int tourId) {
        db.addBooking(booking);
    }
}
