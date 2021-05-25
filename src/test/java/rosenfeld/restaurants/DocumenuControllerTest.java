package rosenfeld.restaurants;

import io.reactivex.rxjava3.core.Single;
import javafx.scene.control.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class DocumenuControllerTest {
    private DocumenuController controller;
    DocumenuService service;
    Coordinates coordinates;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    private void givenDocumenuController() {
        DocumenuFactory factory = new DocumenuFactory();
        DocumenuFeed feed = mock(DocumenuFeed.class);
        DocumenuService svc = factory.newInstance();
        service = mock(DocumenuService.class);
        controller = new DocumenuController(service);
        controller.lblEnterZip = mock(Label.class);
        controller.lblCuisines = mock(Label.class);
        controller.lblError = mock(Label.class);
        controller.tfEnterZip = mock(TextField.class);
        controller.btnGo = mock(Button.class);
        controller.cbCuisines = mock(ComboBox.class);
        controller.names = mock(ArrayList.class);
        controller.phones = mock(ArrayList.class);
        controller.websites = mock(ArrayList.class);
        controller.addresses = mock(ArrayList.class);
    }

    @Test
    public void initialize() {
        //given
        givenDocumenuController();
        SingleSelectionModel<String> selectionModel = mock(SingleSelectionModel.class);
        doReturn(selectionModel).when(controller.cbCuisines).getSelectionModel();


        // when
        controller.initialize();

        // then
        verify(controller.cbCuisines.getSelectionModel());

    } // done


    @Test
    public void invalid_searchLocation() {
        // given
        givenDocumenuController();
        coordinates = mock(Coordinates.class);

        doReturn("07055").when(controller.tfEnterZip).getText();
        doReturn(false).when(coordinates.checkForZip(controller.tfEnterZip.getText()));

        // when
        controller.searchLocation();

        // then
        verify(controller.lblError).setText("Invalid ZipCode");
        verify(controller, times(0)).getRestaurants();
    } // work on


    @Test
    public void valid_searchLocation() {
        // given
        givenDocumenuController();
        Coordinates coordinates = mock(Coordinates.class);
        doReturn("07055").when(controller.tfEnterZip).getText();
        doReturn(true).when(coordinates.checkForZip(controller.tfEnterZip.toString()));

        // when
        controller.searchLocation();

        // then
//        verify(controller.getRestaurants());
    } // work on

    @Test
    public void getRestaurants() {
        // given
        givenDocumenuController();
        doReturn(Single.never()).when(service).getByZipCode(controller.coordinates.getLat("07055"),
                controller.coordinates.getLong("07055"), "5", "Italian", "5");
        doReturn("07055").when(controller.tfEnterZip).getText();
        doReturn("Italian").when(controller.cbCuisines).getValue();

        // when
        controller.getRestaurants();

        // then
        verify(service).getByZipCode("40.857384", "-74.12899",
                "5", "Italian", "5");
    } // done

    @Test
    public void labelsText_onDocumenuFeed() {
//        // given
//        givenDocumenuController();
//        DocumenuFeed feed = mock(DocumenuFeed.class);
////        DocumenuFeed.Data data = mock(DocumenuFeed.Data.class);
//        feed.data = mock(DocumenuFeed.Data.class);
//        feed.data.get(1).restaurant_name = mock(String.class);
////        feed.data.get(1).restaurant_name = "Romeo's Pizzeria Restaurant";
////        feed.data.get(1).restaurant_phone = "(973) 777-1450";
////        feed.data.get(1).restaurant_website = "http://www.romeosnj.com/";
////        feed.data.get(1).address.formatted = "199 Main Ave PASSAIC, NJ 07055";
//        doReturn(data).when(controller.names.get(1).getText());
//        doReturn("Romeo's Pizzeria Restaurant").when(controller.names.get(1)).getText();
//        controller.names.get(1).setText("Romeo's Pizzeria Restaurant");
//
//        // when
//        controller.onDocumenuFeed(feed);
//
//        //then
//        verify(controller.names.get(1)).setText(String.valueOf(feed.data.get(1).restaurant_name));

    } // work on
}


