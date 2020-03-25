package Daytours.Model;

public class Review {

    private int tourId;
    private String name;
    private String reviewText;

    public String getName() {
        return name;
    }

    public int getTourId() {
        return tourId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
