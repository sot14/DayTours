package Daytours.Controller;

import Daytours.Model.Booking;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Tour;

public class BookingController {
    public Booking booking;
    public DataBaseManager db;

    public BookingController(DataBaseManager db) {
        this.db = db;
    }

    public void bookTour(Booking booking) {
        this.booking = db.addBooking(booking);
        Tour tour = db.getTour(booking.getTourID());
        int no = tour.getParticipantNum();
        tour.setParticipantNum(--no);
    }

    public DataBaseManager getDb(){
        return db;
    }

    public Booking getBooking(int id) {
        return db.getBooking(id);
    }
}
