package main.ymanilow.weather;

import main.ymanilow.utils.Coordinates;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.Log;

import java.util.List;

public class WeatherTower extends Tower{

    public WeatherTower(Log log) {
        super(log);
    }

    public String getWeather(Coordinates coordinates) { return WeatherProvider.getProvider().getCurrentWeather(coordinates); }

    public void doAction(){
        List<Flyable> flyableCrafts = this.getObservers();
        int size = flyableCrafts.size();
        int j = 0;

        while (j < size) {
            flyableCrafts.get(j++).updateConditions();
            if (size != flyableCrafts.size()) {
                size = flyableCrafts.size();
                j--;
            }
        }
    }

    private void changeWeather() {}
}