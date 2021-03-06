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
import javafx.scene.image.Image;
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

    public Image tourId1 = new Image("Daytours/Img/goldenCircle.jpg");
    public Image tourId2 = new Image("Daytours/Img/geitalabb.png");
    public Image tourId3 = new Image("Daytours/Img/thingvellir.png");
    public Image tourId4 = new Image("Daytours/Img/heidmork.png");
    public Image tourId5 = new Image("Daytours/Img/steingrimsfjordur.png");
    public Image tourId6 = new Image("Daytours/Img/vestmannaeyjar.png");
    public Image tourId7 = new Image("Daytours/Img/vidgelmir.png");
    public Image tourId8 = new Image("Daytours/Img/kayak.png");
    public Image tourId9 = new Image("Daytours/Img/zipline.png");
    public Image tourId10 = new Image("Daytours/Img/selir.png");
    public Image tourId11 = new Image("Daytours/Img/hestar.png");
    public Image tourId12 = new Image("Daytours/Img/hengifoss.png");
    public Image tourId13 = new Image("Daytours/Img/giljabod.png");
    public Image tourId14 = new Image("Daytours/Img/hvalaskodun.png");
    public Image tourId15 = new Image("Daytours/Img/jeppaferd.png");
    public Image tourId16 = new Image("Daytours/Img/egilsstadir.png");
    public Image tourId17 = new Image("Daytours/Img/vigur.png");
    public Image tourId18 = new Image("Daytours/Img/hornstrandir.png");
    public Image tourId19 = new Image("Daytours/Img/videy.png");
    public Image tourId20 = new Image("Daytours/Img/raudholar.png");




    public void init(Tour tour, DataBaseManager db){
        this.tour = tour;
        reviewController = new ReviewController(db);
        tourController = new TourController(db);
        synaTour();
        synaReview();
        synaMynd();
        reviews.setFixedCellSize(80.0);
        wReview.setWrapText(true);
        wReview.setWrapText(true);

    }

    public void synaTour() {
        tourNafn.setText(tour.getTourName());
        company.setText(tour.getCompany());

        String strDate = (tour.getDate()).toString();
        date.setText(strDate);

        String lengd = String.valueOf(tour.getLength());
        length.setText(lengd + " klst");

        loc.setText(tour.getLocation());

        info.setText(tour.getTourInfo());
        info.setWrapText(true);

        String verd = String.valueOf(tour.getPrice());
        price.setText(verd + " kr");

        String fjoldi = String.valueOf(tour.getParticipantNum());
        participants.setText(fjoldi);


    }

    public void synaMynd() {
        switch(tourId) {
            case 1:
                mynd.setImage(tourId1);
                break;
            case 2:
                mynd.setImage(tourId2);
                break;
            case 3:
                mynd.setImage(tourId3);
                break;
            case 4:
                mynd.setImage(tourId4);
                break;
            case 5:
                mynd.setImage(tourId5);
                break;
            case 6:
                mynd.setImage(tourId6);
                break;
            case 7:
                mynd.setImage(tourId7);
                break;
            case 8:
                mynd.setImage(tourId8);
                break;
            case 9:
                mynd.setImage(tourId9);
                break;
            case 10:
                mynd.setImage(tourId10);
                break;
            case 11:
                mynd.setImage(tourId11);
                break;
            case 12:
                mynd.setImage(tourId12);
                break;
            case 13:
                mynd.setImage(tourId13);
                break;
            case 14:
                mynd.setImage(tourId14);
                break;
            case 15:
                mynd.setImage(tourId15);
                break;
            case 16:
                mynd.setImage(tourId16);
                break;
            case 17:
                mynd.setImage(tourId17);
                break;
            case 18:
                mynd.setImage(tourId18);
                break;
            case 19:
                mynd.setImage(tourId19);
                break;
            case 20:
                mynd.setImage(tourId20);
                break;
        }
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

        if (tour.getParticipantNum() == 0) {
            final Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            VBox dialogVbox = new VBox(20);
            popUpMessage = new Text("  Ferðin er uppbókuð");
            bokaFerdButton.setDisable(true);
            dialogVbox.getChildren().add(popUpMessage);
            Scene dialogScene = new Scene(dialogVbox, 200, 100);
            popup.setScene(dialogScene);
            popup.show();
        }
        else {
            //loka núverandi glugga þ.e. tour/review glugga
            Stage stage = (Stage) bokaFerdButton.getScene().getWindow();
            stage.close();

            //opna næsta glugga þ.e. booking glugga
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Daytours/UI/BookingSite.fxml"));
            Parent root = fxmlLoader.load();
            BookingSiteController controller = fxmlLoader.getController();
            controller.init(tour, tourController.getDb());
            Stage stage2 = new Stage();
            stage2.setTitle("Bóka dagsferð");
            stage2.setScene(new Scene(root, 700, 450));
            stage2.show();
        }

    }

    public void tilBakaHandler(ActionEvent actionEvent) throws IOException {
        //loka núverandi glugga þ.e. tour/review glugga
        Stage stage = (Stage) tilBakaButton.getScene().getWindow();
        stage.close();

        //opna fyrrverandi glugga þ.e. index glugga
       // System.out.println(IndexSiteController.class.getResource("/Daytours/UI/IndexSite.fxml"));
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
            popUpMessage = new Text(" Ummæli móttekin, takk fyrir");
            reviewController.addReview(review);
            wName.clear();
            wReview.clear();
            synaReview();
        }

        dialogVbox.getChildren().add(popUpMessage);
        Scene dialogScene = new Scene(dialogVbox, 200, 100);
        popup.setScene(dialogScene);
        popup.show();
    }


}
