package Daytours.Controller;
import Daytours.Model.Tour;
import Daytours.Database.DataBaseManager;

import java.util.ArrayList;


public class TourController {

    public Tour tour;
    public DataBaseManager db;

    public Tour getTour(int tourId){
        return db.getTour(tourId);
    }

    public ArrayList<Tour> getAllTours(){
        return db.getAllTours();
    }

    public Tour searchTour(String tourName) {
        return tour;
    }




}
