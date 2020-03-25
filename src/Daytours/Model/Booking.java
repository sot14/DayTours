package Daytours.Model;

import Daytours.Controller.BookingController;

public class Booking {
    private String phoneNo;
    private String cardNo;
    private int tourId;
    private boolean hotelPickup = false;
    private String participants;
    private int participantNo;
    private String hotelAddress;
    private int bookingId;

    public Booking(String phoneNo, String cardNo, int tourId, boolean hotelPickup, String participants, int participantNo, String hotelAddress, int id) {
        this.phoneNo = phoneNo;
        this.cardNo = cardNo;
        this.tourId = tourId;
        this.hotelPickup = hotelPickup;
        this.participants = participants;
        this.participantNo = participantNo;
        this.hotelAddress = hotelAddress;
        this.bookingId = id;
    }

    public int getBookingId() { return bookingId; }

    public void setBookingId(int id) { this.bookingId = id; }

    public String getPhoneNo() {return phoneNo;}

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getTourId() { return tourId; }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public boolean isHotelPickup() {
        return hotelPickup;
    }

    public void setHotelPickup(boolean hotelPickup) {
        this.hotelPickup = hotelPickup;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public int getParticipantNo() {
        return participantNo;
    }

    public void setParticipantNo(int participantNo) {
        this.participantNo = participantNo;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}
