package main.ymanilow.aircraft;

import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;
import main.ymanilow.utils.Log;
import main.ymanilow.weather.Weather;


public class Aircraft {
    protected long id;
    protected String name;
    private static long idCounter;
    private final Log log;

    Coordinates coordinates;

    protected Aircraft(String name, Coordinates coordinates, Log log) {
        this.name = "#" + name + "(" + id + ")";
        this.coordinates = coordinates;
        this.id = nextId();
        this.log = log;
    }

    protected void changeCoordinates(Coordinates offset) {
        int longitude = coordinates.getLongitude() + offset.getLongitude();
        int latitude = coordinates.getLatitude() + offset.getLatitude();
        int height = coordinates.getHeight() + offset.getHeight();

        if (height > 100)
            height = 100;
        this.coordinates = new Coordinates(longitude, latitude, height);
    }

    protected void logWeather(Weather weatherType, AircraftType aircraftType) {
        switch (weatherType) {
            case Sun:
                log.printMessage("sun with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
            case Rain:
                log.printMessage("rain with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
            case Fog:
                log.printMessage("fog with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
            case Snow:
                log.printMessage("snow with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
        }
    }

    protected void logLanding(AircraftType type) {
        log.printMessage(type + name + ": landing");
    }

    private long nextId(){
        return idCounter++;
    }
}
