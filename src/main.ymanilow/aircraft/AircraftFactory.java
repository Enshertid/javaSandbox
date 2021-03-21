package main.ymanilow.aircraft;

import main.ymanilow.exceptions.AvajException;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws AvajException {
        Coordinates coordinates = new Coordinates(longitude,latitude,height);
        switch (AircraftType.valueOf(type)) {
            case JetPlane:
                return new JetPlain(name, coordinates);
            case Baloon:
                return new Baloon(name, coordinates);
            case Helicopter:
                return new Helicopter(name, coordinates);
            default:
                throw new AvajException("invalid type here: " + type);
        }
    }
}
