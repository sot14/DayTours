package Daytours;

public class Review {
    private int tourId;
    private String reviewText;

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
