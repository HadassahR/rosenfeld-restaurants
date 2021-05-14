package rosenfeld.restaurants;

import org.junit.Test;

import static org.junit.Assert.*;

public class DocumenuTest {

    @Test
    public void getByZipCode(){

        // given
        DocumenuFactory factory = new DocumenuFactory();
        DocumenuService service = factory.newInstance();

        // when
        DocumenuFeed feed = service.getByZipCode("07055")
                .blockingGet();

        // then
        assertNotNull(feed);
//        assertNotNull(feed.main);
//        assertEquals("New York", feed.name);
//        assertTrue(feed.main.temp > 0);
//        assertTrue(feed.main.temp < 150); // testing that is in imperial
//        assertTrue(feed.dt > 0); // checking that date is coming in
    }


}
