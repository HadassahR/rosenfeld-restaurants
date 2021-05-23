package rosenfeld.restaurants;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class DocumenuController {


    @FXML
    Label lblEnterZip;
    @FXML
    TextField tfEnterZip;
    @FXML
    Button btnGo;
    @FXML
    ComboBox<String> cbCuisines;
    @FXML
    Label lblError;
    //    @FXML
//    Label name, phone, website, cuisines, address;
    @FXML
    ArrayList<Label> names, phones, websites, addresses;


    private final DocumenuService service;
    private final Coordinates coordinates = new Coordinates();

    public DocumenuController(DocumenuService service) {
        this.service = service;
    }

    public void initialize() {
        cbCuisines.getSelectionModel();
    }

    public void searchLocation() {
        if (!coordinates.checkForZip(tfEnterZip.getText())) {
            lblError.setText("Invalid ZipCode");
        } else {
            getRestaurants();
        }
    }

    private void getRestaurants() {
        Disposable disposableFeed = service.getByZipCode(coordinates.getLat(tfEnterZip.getText()), coordinates.getLong(tfEnterZip.getText()),
                "5", cbCuisines.getValue(), "5")
                // request the data in the background
                .subscribeOn(Schedulers.io())
                // work with the data in the foreground
                .observeOn(Schedulers.trampoline())
                // work with the feed whenever it gets downloaded
                .subscribe(this::onDocumenuFeed, this::onError);
    }

    public void onDocumenuFeed(DocumenuFeed feed) {
        Platform.runLater(() -> onDocumenuFeedRunLater(feed));
    }

    public void onDocumenuFeedRunLater(DocumenuFeed feed) {

        for (int ix = 0; ix < names.size(); ix ++){
            names.get(ix).setText(feed.data.get(ix).restaurant_name);
            phones.get(ix).setText(feed.data.get(ix).restaurant_phone);
            if (feed.data.get(ix).restaurant_website.equals("")){
                websites.get(ix).setText("No website listed");
            } else {
                websites.get(ix).setText(feed.data.get(ix).getWebsite());
            }

            if (feed.data.get(ix).address.formatted.equals("")){
                addresses.get(ix).setText("No address listed");
            } else {
                addresses.get(ix).setText(feed.data.get(ix).address.shortAddress());
            }
//            websites.get(ix).setText(feed.data.get(ix).restaurant_website);
//            addresses.get(ix).setText(feed.data.get(ix).address.formatted);
        }
//        names.get(0).setText(feed.data.get(0).restaurant_name);
//        phones.get(0).setText(feed.data.get(0).restaurant_phone);
//        websites.get(0).setText(feed.data.get(0).restaurant_website);
//        addresses.get(0).setText(feed.data.get(0).address.formatted);

    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }
}