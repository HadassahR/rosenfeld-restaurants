package rosenfeld.restaurants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coordinates {

    private final Map<String, String> zipToLatLong = new HashMap<>();

    public Coordinates () {
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

    public String getLatLong(String zip){
        String latLong = zipToLatLong.get(zip);
        return latLong.substring(latLong.indexOf(",") + 1, latLong.length()-1);
    }

    public void printCoordinates(){
        zipToLatLong.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }
}
