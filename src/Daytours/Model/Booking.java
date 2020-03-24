package Daytours.Model;

import Daytours.Controller.BookingController;

public class Booking {
    private String phoneNo;
    private String cardNo;
    private Tour[] tours;
    private boolean hotelPickup = false;
    private String[] participants;
    private int participantNo;
    private int tourNo;
    private String hotelAddress;
    private BookingController bookingController;
    private int id;

    public Booking() {
        participants = new String[participantNo];
        tours = new Tour[tourNo];
    }

    public String getPhoneNo() {
        return bookingController.getPhoneNoField();
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Tour[] getTours() {
        return tours;
    }

    public void setTours(Tour[] tours) {
        this.tours = tours;
    }

    public boolean isHotelPickup() {
        return hotelPickup;
    }

    public void setHotelPickup(boolean hotelPickup) {
        this.hotelPickup = hotelPickup;
    }

    public String[] getParticipants() {
        return participants;
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

    public int getParticipantNo() {
        return participantNo;
    }

    public void setParticipantNo(int participantNo) {
        this.participantNo = participantNo;
    }

    public int getTourNo() {
        return tourNo;
    }

    public void setTourNo(int tourNo) {
        this.tourNo = tourNo;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
