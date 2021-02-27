package ymanilow.aircraft;

import ymanilow.utils.AircraftType;
import ymanilow.utils.Coordinates;


public class Aircraft {
    protected long id;
    protected String name;
    private static long idCounter;


    Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = "#" + name + "(" + id + ")";
        this.coordinates = coordinates;
        this.id = nextId();
    }

    protected void changeCoordinates(Coordinates offset) {
        int longitude = coordinates.getLongitude() + offset.getLongitude();
        int latitude = coordinates.getLatitude() + offset.getLatitude();
        int height = coordinates.getHeight() + offset.getHeight();

        if (height > 100)
            height = 100;
        this.coordinates = new Coordinates(longitude, latitude, height);
    }

    protected void logLanding(AircraftType type) {
        System.out.println(type + name + ": landing");
    }

    private long nextId(){
        return idCounter++;
    }
}
