package rosenfeld.restaurants;
import org.junit.Assert;
import org.junit.Test;


public class CoordinatesTest {

    @Test
    public void importsFirstCoordinates(){
        // given
        Coordinates coordinates = new Coordinates();

        // when
        boolean containsZip = coordinates.checkForZip("55795");

        // then
        Assert.assertTrue(containsZip);

    }

    @Test
    public void importsLastCoordinates(){
        // given
        Coordinates coordinates = new Coordinates();

        // when
        boolean containsZip = coordinates.checkForZip("85326");

        // then
        Assert.assertTrue(containsZip);

    }

    @Test
    public void invalid_checkForZip() {
        // given
        Coordinates coordinates = new Coordinates();

        // when
        boolean containsZip = coordinates.checkForZip("11111");

        // then
        Assert.assertFalse(containsZip);
    }

    @Test
    public void returnsCorrectCoordinates() {
        Coordinates coordinates = new Coordinates();

        // when
        String latitude  = coordinates.getLat("93722");
        String longitude  = coordinates.getLong("93722");

        // then
        Assert.assertEquals("36.801603", latitude);
        Assert.assertEquals("-119.88878", longitude);
    }


}