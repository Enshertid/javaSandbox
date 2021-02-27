package ymanilow.aircraft;

import ymanilow.utils.AircraftType;
import ymanilow.utils.Coordinates;
import ymanilow.utils.Flyable;
import ymanilow.weather.Weather;
import ymanilow.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        Weather weather = Weather.valueOf(weatherTower.getWeather(coordinates));

        logWeather(weather);
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
        if (coordinates.getHeight() < 0) {
            logLanding(AircraftType.Baloon);
            weatherTower.unregister(this);
        }
    }

    protected void logWeather(Weather weatherType) {
        switch (weatherType) {
            case Sun:
                System.out.println("sun with baloon");
                break;
            case Rain:
                System.out.println("rain with baloon");
                break;
            case Fog:
                System.out.println("fog with baloon");
                break;
            case Snow:
                System.out.println("snow with baloon");
                break;
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
    }
}
