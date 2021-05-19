package rosenfeld.restaurants;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DocumenuController {

    private final DocumenuService service;

    public DocumenuController(DocumenuService service) {
        this.service = service;
    }

    public void initialize() {

    }

}