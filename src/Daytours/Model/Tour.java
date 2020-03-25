package Daytours.Model;
import java.util.*;

public class Tour {
    private String company;
    private double length;
    private Date date;
    private String location;
    private String tourInfo;
    private double price;
    private int tourID;
    private int participantNum;
    private String tourName;

    public Tour(String company, double length, String location, String tourInfo, double price, int tourID, int participantNum, String tourName) {
        this.company = company;
        this.length = length;
        //this.date = date;
        this.location = location;
        this.tourInfo = tourInfo;
        this.price = price;
        this.tourID = tourID;
        this.participantNum = participantNum;
        this.tourName = tourName;
    }


    public String getCompany() {
        return company;
    }

    public double getLength() {
        return length;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getTourInfo() {
        return tourInfo;
    }

    public double getPrice() {
        return price;
    }

    public int getTourID() {
        return tourID;
    }

    public int getParticipantNum() {
        return participantNum;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTourInfo(String tourInfo) {
        this.tourInfo = tourInfo;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTourID(int tourID) {
        this.tourID = tourID;
    }

    public void setParticipantNum(int participantNum) {
        this.participantNum = participantNum;
    }


    public String getTourName() { return tourName; }

    public void setTourName(String tourName) { this.tourName = tourName; }

}
