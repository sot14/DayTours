package Daytours.UI;

import Daytours.Controller.ReviewController;
import Daytours.Controller.TourController;
import Daytours.Database.DataBaseManager;
import Daytours.Model.Review;
import Daytours.Model.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.ArrayList;

public class ReviewSiteController {

    @FXML
    public TextArea wReview;
    @FXML
    public TextField wName;
    @FXML
    public ImageView mynd;
    @FXML
    private Button bokaFerdButton,tilBakaButton;
    @FXML
    private Label tourNafn,company,date,length,loc,price,participants;
    @FXML
    private TextArea info;
    @FXML
    private TableView<Review> reviews;
    @FXML
    private TableColumn<Review,String> name;
    @FXML
    private TableColumn<Review,String> reviewText;

    public String nafn;
    public String reviewTexti;
    public Review review;
    public int tourId;
    public Text popUpMessage;

    private DataBaseManager db;
    private Tour tour;
    private ReviewController reviewController;
    private TourController tourController;



    public void init(Tour tour, DataBaseManager db){
        this.tour = tour;
        reviewController = new ReviewController(db);
        tourController = new TourController(db);
        synaTour();
        synaReview();
        reviews.setFixedCellSize(60.0);
        wReview.setWrapText(true);
        wReview.setWrapText(true);

    }

    public void synaTour() {
        tourNafn.setText(tour.getTourName());
        company.setText(tour.getCompany());

        String strDate = (tour.getDate()).toString();
        date.setText(strDate);

        String lengd = String.valueOf(tour.getLength());
        length.setText(lengd + " klst.");

        loc.setText(tour.getLocation());

        info.setText(tour.getTourInfo());
        info.setWrapText(true);

        String verd = String.valueOf(tour.getPrice());
        price.setText(verd + " kr");

        String fjoldi = String.valueOf(tour.getParticipantNum());
        participants.setText(fjoldi);


    }

    public void synaMynd() {

    }

    public void synaReview() {
        tourId = tour.getTourID();
        ArrayList<Review> listOfReviews = reviewController.getAllReviews(tourId);
        ObservableList<Review> listViewReviews = FXCollections.observableArrayList(listOfReviews);
        reviews.setItems(listViewReviews);
        name.setCellValueFactory(
                new PropertyValueFactory<Review,String>("name"));
        name.setCellFactory(WRAPPING_CELL_FACTORY);
        reviewText.setCellValueFactory(
                new PropertyValueFactory<Review,String>("reviewText"));
        reviewText.setCellFactory(WRAPPING_CELL_FACTORY);

    }

    public static final Callback<TableColumn<Review,String>, TableCell<Review,String>> WRAPPING_CELL_FACTORY =
            new Callback<TableColumn<Review,String>, TableCell<Review,String>>() {

                @Override public TableCell<Review,String> call(TableColumn<Review,String> param) {
                    TableCell<Review,String> tableCell = new TableCell<Review,String>() {
                        @Override protected void updateItem(String item, boolean empty) {
                            if (item == getItem()) return;

                            super.updateItem(item, empty);

                            if (item == null) {
                                super.setText(null);
                                super.setGraphic(null);
                            } else {
                                super.setText(item);
                                super.setGraphic(null);
                            }
                        }
                    };
                    tableCell.setWrapText(true);
                    return tableCell;
                }
            };

    public void bokaFerdHandler(ActionEvent actionEvent) throws IOException {
        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        //popup.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);

        if (tour.getParticipantNum() == 0) {
            popUpMessage = new Text("Ferðin er uppbókuð");
            bokaFerdButton.setDisable(true);
        }
        else {
            //loka núverandi glugga þ.e. tour/review glugga
            Stage stage = (Stage) bokaFerdButton.getScene().getWindow();
            stage.close();

            //opna næsta glugga þ.e. booking glugga
            System.out.println(IndexSiteController.class.getResource("/Daytours/UI/BookingSite.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/BookingSite.fxml"));
            Parent root = fxmlLoader.load();
            BookingSiteController controller = fxmlLoader.getController();
            controller.init(tour, tourController.getDb());
            Stage stage2 = new Stage();
            stage2.setTitle("Bóka tour");
            stage2.setScene(new Scene(root, 700, 450));
            stage2.show();
        }
        dialogVbox.getChildren().add(popUpMessage);
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        popup.setScene(dialogScene);
        popup.show();
    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. index glugga
        System.out.println(IndexSiteController.class.getResource("/Daytours/UI/IndexSite.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/IndexSite.fxml"));
        Parent root = fxmlLoader.load();
        IndexSiteController controller = fxmlLoader.getController();
        controller.init(tourController.getDb());
        Stage stage2 = new Stage();
        stage2.setTitle("Dagsferðir ehf");
        stage2.setScene(new Scene(root, 900, 600));
        stage2.show();
    }

    public void sendaHandler(ActionEvent actionEvent) {
        nafn = wName.getText();
        reviewTexti = wReview.getText();
        review = new Review(tourId,reviewTexti,nafn);
        checkWriteReview();
    }

    private void checkWriteReview() {
        final Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        //popup.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);

        if (this.nafn.length() <= 0) popUpMessage = new Text("Vinsamlegast skrifið nafnið ykkar");
        else if (this.reviewTexti.length() <= 0) popUpMessage = new Text("Vinsamlegast skrifið inn ummæli");
        else {
            popUpMessage = new Text("Ummæli móttekin, takk fyrir");
            reviewController.addReview(review);
            wName.clear();
            wReview.clear();
        }

        dialogVbox.getChildren().add(popUpMessage);
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        popup.setScene(dialogScene);
        popup.show();
    }


}
