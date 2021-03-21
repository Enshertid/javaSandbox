package main.ymanilow.aircraft;

import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.Log;
import main.ymanilow.weather.Weather;
import main.ymanilow.weather.WeatherTower;

public class JetPlain extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    JetPlain(String name, Coordinates coordinates, Log log) {
        super(name, coordinates, log);
    }

    @Override
    public void updateConditions() {
        Weather weather = Weather.valueOf(weatherTower.getWeather(coordinates));

        logWeather(weather, AircraftType.JetPlane);
        switch (weather) {
            case Sun:
                changeCoordinates(new Coordinates(0, 10, 2));
                break;
            case Rain:
                changeCoordinates(new Coordinates(0,5,0));
                break;
            case Fog:
                changeCoordinates(new Coordinates(0, 1 ,0));
                break;
            case Snow:
                changeCoordinates(new Coordinates(0, 0, -7));
                break;
        }
        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }

    @Override
    public AircraftType getTypeOfAircraft() {
        return AircraftType.JetPlane;
    }

    @Override
    public String getNameOfAircraft() {
        return name;
    }
}
