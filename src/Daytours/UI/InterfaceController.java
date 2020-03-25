package Daytours.UI;

import javafx.event.ActionEvent;
import Daytours.Controller.BookingController;


public class InterfaceController {
    BookingController bookingController;
    int tourID; //sækja frá booking síðu

    public void initialize() {
        bookingController = new BookingController();
    }
    public void bookTour(ActionEvent actionEvent) {
        bookingController.bookTour(tourID);
    }

    public void hotelPickupHandler(ActionEvent actionEvent) {

    }
}
