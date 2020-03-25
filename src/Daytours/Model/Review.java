package Daytours.Model;

public class Review {
    private String name;
    private int tourId;
    private String reviewText;

    public Review(String name, int tourId, String reviewText) {
        this.name = name;
        this.tourId = tourId;
        this.reviewText = reviewText;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

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
