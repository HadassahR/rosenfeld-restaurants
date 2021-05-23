package rosenfeld.restaurants;

import io.reactivex.rxjava3.core.Single;
import javafx.scene.control.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class DocumenuControllerTest{
    private DocumenuController controller;
    DocumenuService service;

    @BeforeClass
    public static void beforeClass() {
        com.sun.javafx.application.PlatformImpl.startup(() -> {
        });
    }

    private void givenDocumenuController() {
        DocumenuFactory factory = new DocumenuFactory();
        DocumenuService svc = factory.newInstance();
        Coordinates coordinates = mock(Coordinates.class);
        service = mock(DocumenuService.class);
        controller = new DocumenuController(service);
        controller.lblEnterZip = mock(Label.class);
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

    }

    @Test
    public void getRestaurants() {
        // given
        givenDocumenuController();
//        doReturn(Single.never()).when(service).getCurrentWeather("New York", "imperial");
//        doReturn(Single.never()).when(service).getWeatherForecast("New York", "imperial");
//        doReturn("New York").when(controller.enterLocation).getText();
//        doReturn(true).when(controller.units.get(1)).isSelected();

        // when
        controller.getRestaurants();

        // then
//        verify(service).getCurrentWeather("New York", "imperial");
    }
    @Test
    public void searchLocation(){
//        // given
//        givenDocumenuController();
//        doReturn(true).when(controller.coordinates.checkForZip("07055"));
//
//        // when
//        controller.searchLocation();
//
//        // then
//        verify(controller.coordinates.checkForZip("07055"));
    }
}
