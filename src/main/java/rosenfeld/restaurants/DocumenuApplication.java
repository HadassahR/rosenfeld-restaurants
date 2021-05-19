package rosenfeld.restaurants;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DocumenuApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        DocumenuService service = new DocumenuFactory().newInstance();
        DocumenuController controller = new DocumenuController(service);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/documenu_application.fxml"));
        loader.setController(controller);

        Parent parent = loader.load();
        Scene scene = new Scene(parent, 700, 400);

        stage.setTitle("Restaurant Finder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}