package ymanilow.aircraft;

import ymanilow.utils.AircraftType;
import ymanilow.utils.Coordinates;
import ymanilow.utils.Flyable;
import ymanilow.weather.Weather;
import ymanilow.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        Weather weather = Weather.valueOf(weatherTower.getWeather(coordinates));

        logWeather(weather, AircraftType.Helicopter);
        switch (weather) {
            case Sun:
                changeCoordinates(new Coordinates(10, 0, 2));
                break;
            case Rain:
                changeCoordinates(new Coordinates(5,0,0));
                break;
            case Fog:
                changeCoordinates(new Coordinates(1, 0 , 0));
                break;
            case Snow:
                changeCoordinates(new Coordinates(0, 0, 12));
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
        return AircraftType.Helicopter;
    }

    @Override
    public String getNameOfAircraft() {
        return name;
    }
}
