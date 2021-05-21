package rosenfeld.restaurants;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DocumenuController {


    @FXML
    Label lblEnterZip;
    @FXML
    TextField tfEnterZip;
    @FXML
    Button btnGo;
    @FXML
    ComboBox <String> cbCuisines;
    @FXML
    Label lblError;


    private final DocumenuService service;
    private final Coordinates coordinates = new Coordinates();

    public DocumenuController(DocumenuService service) {
        this.service = service;
    }

    public void initialize() {
        cbCuisines.getSelectionModel();
    }

    public void findRestaurants() {
        if(!coordinates.checkForZip(tfEnterZip.getText())){
            lblError.setText("Invalid ZipCode");
        } else {
            displayRestaurants();
        }
    }

    private void displayRestaurants() {
    }
}