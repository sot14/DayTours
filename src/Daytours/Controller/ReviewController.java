package Daytours.Controller;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Review;

import java.awt.*;

public class ReviewController {
    public Review review;
    public DataBaseManager db;

    public void addReview() {
        db.addReview(review);
    }

}
