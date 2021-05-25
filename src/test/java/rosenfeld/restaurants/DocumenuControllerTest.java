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

    /*
    Tests that ComboBox was initialized
 */
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

    }


    /*
    Tests that error label shows up and service isn't called when search location is invalid
*/
    @Test
    public void invalid_searchLocation() {
        // given
        givenDocumenuController();
        Coordinates coordinates = mock(Coordinates.class);
        doReturn("11111").when(controller.tfEnterZip).getText();
        String zip = controller.tfEnterZip.getText();
        doReturn(false).when(coordinates).checkForZip(zip);

        // when
        controller.searchLocation();

        // then
        verify(controller.lblError).setText("Invalid ZipCode");
        verify(service, times(0)).getByZipCode(coordinates.getLat(zip), coordinates.getLong(zip),
                "5", "Italian", "5");

    }

    /*
    Tests that when service.getRestaurants() is called, getByZipCode() is called
 */
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
    }

    /*
    Tests that restaurant labels are set onDocumenuFeed(). Incomplete method, wasn't able to finish, doesn't work.
*/
    @Test
    public void labelsText_onDocumenuFeed() {
        // given
        givenDocumenuController();
        DocumenuFeed feed = mock(DocumenuFeed.class);
        DocumenuFeed.Data data = mock(DocumenuFeed.Data.class);

        String restaurantName = "Romeo's Pizzeria Restaurant";
        String restaurantPhone = "(973) 777-1450";
        String restaurantWebsite = "http://romeosnj.com/";
        String restaurantAddressForm = "199 Main Ave";

//        doReturn(data).when(controller.names).get(1).getText();
        doReturn("07055").when(controller.tfEnterZip).getText();
        doReturn("Italian").when(controller.cbCuisines).getValue();
        doReturn(restaurantName).when(controller.names).get(1);
        doReturn(restaurantPhone).when(controller.phones).get(1);
        doReturn(restaurantWebsite).when(controller.websites).get(1);
        doReturn(restaurantAddressForm).when(controller.addresses).get(1);


        // when
        controller.onDocumenuFeed(feed);

        // then
        verify(controller.names.get(1), times(1)).setText("Romeo's Pizzeria Restaurant");
        verify(controller.phones.get(1), times(1)).setText("(973) 777-1450");
        verify(controller.websites.get(1), times(1)).setText("http://romeosnj.com/");
        verify(controller.addresses.get(1), times(1)).setText("199 Main Ave");


    }
}


