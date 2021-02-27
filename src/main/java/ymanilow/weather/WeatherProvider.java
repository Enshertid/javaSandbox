package ymanilow.weather;

import ymanilow.utils.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private final static String [] weather = {"Sun", "Fog", "Rain", "Snow"};


    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            return new WeatherProvider();
        } else {
            return weatherProvider;
        }
    }

    public String getCurrentWeather(Coordinates coordinates) {

        if (coordinates.getLatitude() < 50)
            return weather[1];
        else if (coordinates.getLatitude() < 65)
            return weather[2];
        else if (coordinates.getLongitude() < 75)
            return weather[3];
        else
            return weather[4];
    }

}
