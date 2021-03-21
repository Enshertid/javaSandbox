package main.ymanilow.weather;

import main.ymanilow.utils.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private final static String [] weather = {"Sun", "Fog", "Rain", "Snow"};
    private static Random random = new Random (System.currentTimeMillis());
    private static int count = 0;


    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            return new WeatherProvider();
        } else {
            return weatherProvider;
        }
    }

    public String getCurrentWeather(Coordinates coordinates) {
        count++;
        int index = Math.abs(random.nextInt());
        if (count == 200) {
            random = new Random(System.currentTimeMillis());
            count = 0;
        }
        return weather[index % weather.length];
    }

}
