package rosenfeld.restaurants;

import java.util.List;

public class DocumenuFeed {
    List<Data> data;

    public static class Data {
        String restaurant_name;
        String restaurant_phone;
        String restaurant_website;
        List <String> cuisines;
        Address address;

        public String getWebsite() {
            return restaurant_website.substring(restaurant_website.indexOf("//")+2, restaurant_website.indexOf(".com")) + ".com";
        }
    }

    public static class Address {
        String city;
        String postal_code;
        String formatted;

        public String shortAddress() {
            return formatted.substring(0, (formatted.indexOf(city)));
        }
    }



}