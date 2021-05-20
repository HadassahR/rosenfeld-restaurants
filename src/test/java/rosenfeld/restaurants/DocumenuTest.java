package rosenfeld.restaurants;

import org.junit.Test;

import static org.junit.Assert.*;

public class DocumenuTest {

    @Test
    public void getByZipCode(){

        // given
        DocumenuFactory factory = new DocumenuFactory();
        DocumenuService service = factory.newInstance();
        Coordinates coordinates = new Coordinates();
        String latitude = coordinates.getLat("07055");
        String longitude = coordinates.getLong("07055");

        // when
        DocumenuFeed feed = service.getByZipCode(latitude, longitude, "5", "Italian", "5")
                .blockingGet();

        // then
        assertNotNull(feed);
        assertNotNull(feed.data);
        assertNotNull(feed.data.get(0).address);
        assertNotNull(feed.data.get(0).cuisines);
        assertTrue(feed.data.get(0).restaurant_name.length() > 1);
        assertTrue(feed.data.get(0).address.city.equalsIgnoreCase("Passaic"));
        assertEquals(feed.data.get(0).address.postal_code, "07055");
//        assertTrue(feed.data.get(0).address.formatted.contains("PASSAIC")
//                && feed.data.get(0).address.formatted.contains("07055"));

    }


}
