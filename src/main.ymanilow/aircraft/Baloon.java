package main.ymanilow.aircraft;

import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;
import main.ymanilow.utils.Flyable;
import main.ymanilow.weather.Weather;
import main.ymanilow.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        Weather weather = Weather.valueOf(weatherTower.getWeather(coordinates));

        logWeather(weather, AircraftType.Baloon);
        switch (weather) {
            case Sun:
                changeCoordinates(new Coordinates(2, 0, 4));
                break;
            case Rain:
                changeCoordinates(new Coordinates(0,0,-5));
                break;
            case Fog:
                changeCoordinates(new Coordinates(0, 0 ,-3));
                break;
            case Snow:
                changeCoordinates(new Coordinates(0, 0, -15));
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
        return AircraftType.Baloon;
    }

    @Override
    public String getNameOfAircraft() {
        return name;
    }
}
