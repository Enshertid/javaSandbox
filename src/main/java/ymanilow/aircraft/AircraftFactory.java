package ymanilow.aircraft;

import ymanilow.utils.Flyable;
import ymanilow.utils.AircraftType;
import ymanilow.utils.Coordinates;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws Exception {
        Coordinates coordinates = new Coordinates(longitude,latitude,height);
        switch (AircraftType.valueOf(type)) {
            case JetPlain:
                return new JetPlain(name, coordinates);
            case Baloon:
                return new Baloon(name, coordinates);
            case Helicopter:
                return new Helicopter(name, coordinates);
            default:
                throw new Exception("invalid type here: " + type);
        }
    }
}
