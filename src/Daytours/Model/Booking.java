package Daytours.Model;

public class Booking {
    private String phoneNo;
    private String cardNo;
    private Tour tour;
    private boolean hotelPickup = false;
    private String participantName;
    private int participantNo;
    private int tourID;
    private String hotelAddress;
    private int bookingId;

    public Booking( String phoneNo, String cardNo, int tourID, boolean hotelPickup, String participantName, int participantNo, String hotelAddress) {
        this.phoneNo = phoneNo;
        this.cardNo = cardNo;
        this.hotelPickup = hotelPickup;
        this.participantName = participantName;
        this.participantNo = participantNo;
        this.tourID = tourID;
        this.hotelAddress = hotelAddress;

    }

    public String getPhoneNo() {
        return phoneNo;
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

    public Tour getTour() {
        return tour;
    }

    public void setTours(Tour tour) {
        this.tour = tour;
    }

    public boolean isHotelPickup() {
        return hotelPickup;
    }

    public void setHotelPickup(boolean hotelPickup) {
        this.hotelPickup = hotelPickup;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participant) {
        this.participantName = participant;
    }

    public int getParticipantNo() {
        return participantNo;
    }

    public void setParticipantNo(int participantNo) {
        this.participantNo = participantNo;
    }

    public int getTourID() { return tourID; }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }
}

