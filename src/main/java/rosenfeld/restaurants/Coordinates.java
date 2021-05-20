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
        return zipToLatLong.get("07055");
    }

    public void printCoordinates(){
    }
}
