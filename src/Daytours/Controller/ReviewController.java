package Daytours.Controller;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Review;
import Daytours.Model.Tour;

import java.awt.*;
import java.util.ArrayList;

public class ReviewController {
    public Review review;
    public DataBaseManager db;
    public int tourId;

    public ReviewController(DataBaseManager db) {
        this.db = db;
    }

    public void addReview(Review review) {
        db.addReview(review);
    }

    public ArrayList<Review> getAllReviews(int tourID){
        return db.getReviews(tourID);
    }


}
