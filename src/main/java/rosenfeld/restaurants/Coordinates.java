package rosenfeld.restaurants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coordinates {

    private final Map<String, String> zipToLatLong = new HashMap<>();

    public Coordinates() {
        importCoordinates();
    }

    private void importCoordinates() {
        try {
            File coordinateFile = new File("zip_lat_long.csv");
            Scanner reader = new Scanner(coordinateFile);
            reader.useDelimiter(",");
            while (reader.hasNext()) {
                zipToLatLong.put(
                        reader.next(), //key
                        reader.nextLine().trim() //value
                );
            }
            reader.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public String getLat(String zip) {
        String latitude = zipToLatLong.get(zip);
        return latitude.substring(latitude.indexOf(",") + 1, latitude.indexOf(",", 1));
    }

    public String getLong(String zip) {
        String longitude = zipToLatLong.get(zip);
        return longitude.substring(longitude.indexOf(",", 1) + 1, longitude.length() - 1);
    }

    public void printCoordinates() {
        zipToLatLong.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}
