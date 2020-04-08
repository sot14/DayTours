package Daytours.Controller;
import Daytours.Model.Tour;
import Daytours.Database.DataBaseManager;


import java.util.ArrayList;
import java.sql.Date;


public class TourController {

    public Tour tour;
    public DataBaseManager db;

    public TourController(){
        db = new DataBaseManager();
    }

    public Tour getTour(int tourId){
        return db.getTour(tourId);
    }

    public ArrayList<Tour> getAllTours(){
        return db.getAllTours();
    }

    public ArrayList<Tour> getAllToursWithMaxLength(int len){
        return db.getAllToursWithMaxLength(len);
    }

    public ArrayList<Tour> getAllToursWithLocation(String loc){
        return db.getAllToursWithLocation(loc);
    }

    public ArrayList<Tour> getAllToursInsideTimePeriod(Date start, Date end){ return db.getAllToursInsideTimePeriod(start,end); }

    public ArrayList<Tour> getAllToursCheaper(int price) { return db.getAllToursCheaper(price); }


    public ArrayList<Tour> searchTour(String tourName) {
        return db.searchTourName(tourName);
    }




}
