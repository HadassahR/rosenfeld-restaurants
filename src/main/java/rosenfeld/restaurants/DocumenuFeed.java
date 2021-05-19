package rosenfeld.restaurants;

import java.util.Date;
import java.util.List;

public class DocumenuFeed {
    List<Data> data;

    public static class Data {
        String restaurant_name;
        String restaurant_phone;
        String restaurant_website;
        List <String> cuisines;
        Address address;
    }

    public static class Address {
        String city;
        String postal_code;
        String formatted;
    }

}