package rosenfeld.restaurants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Coordinates {

    private final Map<String, String> zipToLongLat = new HashMap<>();

    public Coordinates () {
        importCoordinates();
    }

    private void importCoordinates() {
        try {
            File coordinateFile = new File("zip_lat_long.txt");
            Scanner reader = new Scanner(coordinateFile);
            while (reader.hasNext()) {
                zipToLongLat.put(
                        reader.next(), //key
                        reader.nextLine().trim() //value
                );
            }
            reader.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
