package Daytours.UI;

import javafx.event.ActionEvent;
import Daytours.Controller.BookingController;


public class InterfaceController {
    BookingController bookingController;

    public void initialize() {
        bookingController = new BookingController();
    }
    public void bookTour(ActionEvent actionEvent) {
        bookingController.bookTour();
    }

    public void hotelPickupHandler(ActionEvent actionEvent) {

    }
}
