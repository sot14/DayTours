package Daytours.Controller;
import Daytours.Model.Tour;
import Daytours.Database.DataBaseManager;

import java.util.ArrayList;


public class TourController {

    public Tour tour;
    public DataBaseManager db;

    public TourController(DataBaseManager db){
        this.db = db;
    }

    public Tour getTour(int tourId){
        return db.getTour(tourId);
    }

    public ArrayList<Tour> getAllTours(){
        return db.getAllTours();
    }

    public ArrayList<Tour> searchTour(String tourName) {
        return db.searchTourName(tourName);
    }
    public DataBaseManager getDb(){
        return db;
    }
}
