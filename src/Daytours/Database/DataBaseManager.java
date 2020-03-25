package Daytours.Database;

import Daytours.Model.Booking;
import Daytours.Model.Review;
import Daytours.Model.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DataBaseManager {

    private String uName;
    private String pWord;
    private String url;
    private Connection db;

    public DataBaseManager() {
        try {
            uName = "fezqdgur";
            pWord = "ibGl_wiv1-uiiJkJZ_xkbNpAcy46LWB9";
            url = "jdbc:postgresql://kandula.db.elephantsql.com:5432/fezqdgur";

            db = DriverManager.getConnection(url, uName, pWord);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn Tour hlut og setur hann í databaseið
    public void addTour(Tour tour) {
        try {
            String company = "'" + tour.getCompany() + "'";
            double length = tour.getLength();
            //Date date = tour.getDate();
            String location = "'" + tour.getLocation() + "'";
            String tourInfo = "'" + tour.getTourInfo() + "'";
            double price = tour.getPrice();
            int tourID = tour.getTourID();
            int participantNum = tour.getParticipantNum();
            String tourName = "'" + tour.getTourName() + "'";

            Statement stmt = db.createStatement();
            String sql = "INSERT INTO tour (id, company, length, location, tourinfo, price, participantnum, tourname)" +
                    " values (" + tourID + "," + company + "," + length + "," + location + "," + tourInfo +
                    "," + price + "," + participantNum + "," + tourName + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn id og skilar Tour hlutnum með það id
    public Tour getTour(int id) {
        try {
            Statement stmt = db.createStatement();
            String sql = "SELECT * FROM tour WHERE id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            String company = rs.getString("company");
            double length = rs.getDouble("length");
            String location = rs.getString("location");
            String tourInfo = rs.getString("tourinfo");
            double price = rs.getDouble("price");
            int tourID = rs.getInt("id");
            int participantNum = rs.getInt("participantnum");
            String tourName = rs.getString("tourname");

            return new Tour(company, length, location, tourInfo, price, tourID, participantNum, tourName);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Skilar lista með öllum Tour í databaseinu
    public ArrayList<Tour> getAllTours(){
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            Statement stmt = db.createStatement();
            String sql = "SELECT * FROM tour";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                tourList.add(new Tour(company, length, location, tourInfo, price, tourID, participantNum, tourName));
            }

            return tourList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Tekur inn Booking hlut og setur hann í databaseið
    public void addBooking(Booking booking){
        try {
            String phoneNo = "'" + booking.getPhoneNo() + "'";
            String cardNo= "'" + booking.getCardNo() + "'";
            int tourId = booking.getTourId();
            boolean hotelPickup = booking.isHotelPickup();
            String participants = "'" + booking.getParticipants() + "'";
            int participantNo = booking.getParticipantNo();
            String hotelAddress = "'" + booking.getHotelAddress() + "'";
            int bookingId = booking.getBookingId();

            Statement stmt = db.createStatement();
            String sql = "INSERT INTO booking (id, phoneno, cardno, hotelpickup, participants, participantno, hoteladdress, tourid)" +
                    " values (" + bookingId + "," + phoneNo + "," + cardNo + "," + hotelPickup + "," + participants +
                    "," + participantNo + "," + hotelAddress + "," + tourId + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn id og skilar Booking hlut með það id
    public Booking getBooking(int id) {
        try {
            Statement stmt = db.createStatement();
            String sql = "SELECT * FROM booking WHERE id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            int bookingId = rs.getInt("id");
            String phoneNo = rs.getString("phoneno");
            String cardNo = rs.getString("cardno");
            boolean hotelPickup = rs.getBoolean("hotelpickup");
            String participants = rs.getString("participants");
            int tourID = rs.getInt("tourid");
            int participantNo = rs.getInt("participantno");
            String hotelAddress = rs.getString("hoteladdress");

            return new Booking(phoneNo, cardNo, tourID, hotelPickup, participants, participantNo, hotelAddress, bookingId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Tekur inn Review hlut og setur hann í databaseið
    public void addReview(Review review){
        try {
            String name = "'" + review.getName() + "'";
            String reviewText = "'" + review.getReviewText() + "'";
            int tourId = review.getTourId();

            Statement stmt = db.createStatement();
            String sql = "INSERT INTO review (tourid, reviewtext, name)" +
                    " values (" + tourId + "," + reviewText + "," + name + ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn Tour id og skilar lista af öllum Review fyrir þann Tour
    public ArrayList<Review> getReviews(int tourId){
        try{
            ArrayList<Review> reviewList = new ArrayList<Review>();
            Statement stmt = db.createStatement();
            String sql = "SELECT * FROM review WHERE tourid=" + tourId;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String name = rs.getString("name");
                String reviewText = rs.getString("reviewtext");

                reviewList.add(new Review(name, tourId, reviewText));
            }

            return reviewList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
