package main.ymanilow.aircraft;

import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;
import main.ymanilow.weather.Weather;


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

    protected void logWeather(Weather weatherType, AircraftType aircraftType) {
        switch (weatherType) {
            case Sun:
                System.out.println("sun with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
            case Rain:
                System.out.println("rain with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
            case Fog:
                System.out.println("fog with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
            case Snow:
                System.out.println("snow with " + aircraftType.name() + " " + this.name + " coordinates " + coordinates);
                break;
        }
    }

    protected void logLanding(AircraftType type) {
        System.out.println(type + name + ": landing");
    }

    private long nextId(){
        return idCounter++;
    }
}
