package Daytours;
import java.util.*;

public class Tour {
    String company;
    double length;
    Date date;
    String[] location;
    String tourInfo;
    double price;
    int tourID;
    int participantNum;
    Review[] review;

    public String getCompany() {
        return company;
    }

    public double getLength() {
        return length;
    }

    public Date getDate() {
        return date;
    }

    public String[] getLocation() {
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

    public Review[] getReview() {
        return review;
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

    public void setLocation(String[] location) {
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

    public void setReview(Review[] review) {
        this.review = review;
    }
}
