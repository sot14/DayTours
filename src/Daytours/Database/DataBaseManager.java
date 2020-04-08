package Daytours.Database;

import Daytours.Model.Booking;
import Daytours.Model.Review;
import Daytours.Model.Tour;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

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
            String sql = "INSERT INTO tour values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = db.prepareStatement(sql);
            int id = getNewTourId();

            stmt.setInt(1, id);
            stmt.setString(2, tour.getCompany());
            stmt.setDate(3, tour.getDate());
            stmt.setDouble(4, tour.getLength());
            stmt.setString(5, tour.getLocation());
            stmt.setString(6, tour.getTourInfo());
            stmt.setDouble(7, tour.getPrice());
            stmt.setInt(8,tour.getParticipantNum());
            stmt.setString(9, tour.getTourName());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn id og skilar Tour hlutnum með það id
    public Tour getTour(int id) {
        try {
            String sql = "SELECT * FROM tour WHERE id=?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            String company = rs.getString("company");
            double length = rs.getDouble("length");
            Date date = rs.getDate("date");
            String location = rs.getString("location");
            String tourInfo = rs.getString("tourinfo");
            double price = rs.getDouble("price");
            int tourID = rs.getInt("id");
            int participantNum = rs.getInt("participantnum");
            String tourName = rs.getString("tourname");

            Tour tour = new Tour(company, length, date, location, tourInfo, price, participantNum, tourName);
            tour.setTourID(tourID);
            return tour;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Skilar lista með öllum Tour í databaseinu
    public ArrayList<Tour> getAllTours(){
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            String sql = "SELECT * FROM tour";
            PreparedStatement stmt = db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                Date date = rs.getDate("date");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                Tour tour = new Tour(company, length, date, location, tourInfo, price, participantNum, tourName);
                tour.setTourID(tourID);
                tourList.add(tour);
            }

            return tourList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Skilar lista með öllum Tour sem eru eins og ákveðinn strengur
    public ArrayList<Tour> searchTourName(String name) {
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            String sql = "SELECT * FROM tour WHERE tourname LIKE ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                Date date = rs.getDate("date");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                tourList.add(new Tour(company, length, date, location, tourInfo, price, tourID, participantNum, tourName));
            }

            return tourList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //skilar lista með öllum Tour sem eru með lengd undir len
    public ArrayList<Tour> getAllToursWithMaxLength(int len){
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            String sql = "SELECT * FROM tour WHERE length <= ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, len);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                Date date = rs.getDate("date");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                tourList.add(new Tour(company, length, date, location, tourInfo, price, tourID, participantNum, tourName));
            }

            return tourList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //skilar lista með öllum Tour sem eru á ákveðnum landshluta
    public ArrayList<Tour> getAllToursWithLocation(String loc){
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            String sql = "SELECT * FROM tour WHERE location = ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, loc);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                Date date = rs.getDate("date");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                tourList.add(new Tour(company, length, date, location, tourInfo, price, tourID, participantNum, tourName));
            }

            return tourList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //skilar lista með öllum Tour sem eru á ákveðnu tímabili hvað varðar dagsetningu
    public ArrayList<Tour> getAllToursInsideTimePeriod(Date start, Date end){
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            String sql = "SELECT * FROM tour WHERE date >= ? AND date <= ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setDate(1, start);
            stmt.setDate(2,end);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                Date date = rs.getDate("date");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                tourList.add(new Tour(company, length, date, location, tourInfo, price, tourID, participantNum, tourName));
            }

            return tourList;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //skilar lista með öllum Tour sem eru ódýrari en pri
    public ArrayList<Tour> getAllToursCheaper(int pri){
        try{
            ArrayList<Tour> tourList = new ArrayList<Tour>();
            String sql = "SELECT * FROM tour WHERE price <= ?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, pri);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                String company = rs.getString("company");
                double length = rs.getDouble("length");
                Date date = rs.getDate("date");
                String location = rs.getString("location");
                String tourInfo = rs.getString("tourinfo");
                double price = rs.getDouble("price");
                int tourID = rs.getInt("id");
                int participantNum = rs.getInt("participantnum");
                String tourName = rs.getString("tourname");

                Tour tour = new Tour(company, length, date, location, tourInfo, price, participantNum, tourName);
                tour.setTourID(tourID);
                tourList.add(tour);
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
            String sql = "INSERT INTO booking values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = db.prepareStatement(sql);
            int id = getNewBookingId();

            stmt.setInt(1, id);
            stmt.setString(2, booking.getPhoneNo());
            stmt.setString(3, booking.getCardNo());
            stmt.setBoolean(4, booking.isHotelPickup());
            stmt.setString(5, booking.getParticipantName());
            stmt.setInt(6, booking.getParticipantNo());
            stmt.setString(7, booking.getHotelAddress());
            stmt.setInt(8, booking.getTourID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn id og skilar Booking hlut með það id
    public Booking getBooking(int id) {
        try {
            String sql = "SELECT * FROM booking WHERE id=?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            int bookingId = rs.getInt("id");
            String phoneNo = rs.getString("phoneno");
            String cardNo = rs.getString("cardno");
            boolean hotelPickup = rs.getBoolean("hotelpickup");
            String participant = rs.getString("participants");
            int tourID = rs.getInt("tourid");
            int participantNo = rs.getInt("participantno");
            String hotelAddress = rs.getString("hoteladdress");

            Booking booking = new Booking(phoneNo, cardNo, tourID, hotelPickup, participant, participantNo, hotelAddress);
            booking.setBookingId(bookingId);
            return booking;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Tekur inn Review hlut og setur hann í databaseið
    public void addReview(Review review){
        try {
            String sql = "INSERT INTO review values (?, ?, ?)";
            PreparedStatement stmt = db.prepareStatement(sql);

            stmt.setInt(1, review.getTourId());
            stmt.setString(2, review.getReviewText());
            stmt.setString(3, review.getName());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Tekur inn Tour id og skilar lista af öllum Review fyrir þann Tour
    public ArrayList<Review> getReviews(int tourId){
        try{
            ArrayList<Review> reviewList = new ArrayList<Review>();
            String sql = "SELECT * FROM review WHERE tourid=?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setInt(1, tourId);
            ResultSet rs = stmt.executeQuery();

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

    public int getNewTourId(){
        try {
            String sql = "SELECT MAX(id) FROM tour";
            PreparedStatement stmt = db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            return ++id;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int getNewBookingId(){
        try {
            String sql = "SELECT MAX(id) FROM booking";
            PreparedStatement stmt = db.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            return ++id;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
}
