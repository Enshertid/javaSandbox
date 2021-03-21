package main.ymanilow.aircraft;

import main.ymanilow.exceptions.AvajException;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;
import main.ymanilow.utils.Log;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height, Log log) throws AvajException {
        Coordinates coordinates = new Coordinates(longitude,latitude,height);
        switch (AircraftType.valueOf(type)) {
            case JetPlane:
                return new JetPlain(name, coordinates, log);
            case Baloon:
                return new Baloon(name, coordinates, log);
            case Helicopter:
                return new Helicopter(name, coordinates, log);
            default:
                throw new AvajException("invalid type here: " + type);
        }
    }
}
