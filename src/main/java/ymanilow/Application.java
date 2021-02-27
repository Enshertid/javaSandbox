package ymanilow;

import ymanilow.aircraft.AircraftFactory;
import ymanilow.aircraft.Baloon;
import ymanilow.utils.AircraftType;
import ymanilow.utils.Coordinates;
import ymanilow.utils.Flyable;
import ymanilow.weather.WeatherTower;

import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {
        WeatherTower weatherTower = new WeatherTower();

        for (int i = 0; i < 3; i++) {
            weatherTower.register(AircraftFactory.newAircraft(AircraftType.Baloon.name(), "B" + i, 1 + i, 2 + i,3 + i));
        }
        for (int i = 0; i < 3; i++) {
            weatherTower.register(AircraftFactory.newAircraft(AircraftType.Helicopter.name(), "H" + i, 1 + i, 2 + i,3 + i));
        }
        for (int i = 0; i < 3; i++) {
            weatherTower.register(AircraftFactory.newAircraft(AircraftType.JetPlain.name(), "JP" + i, 1 + i, 2 + i,3 + i));
        }
        List<Flyable> flyableList = weatherTower.getObservers();

        for(Flyable flyable :flyableList) {
            flyable.registerTower(weatherTower);
        }

        for (int i = 0; i < 10; i++) {
            int size = flyableList.size();
            int j = 0;

            while (j < size) {
                flyableList.get(j++).updateConditions();
                if (size != flyableList.size()) {
                    size = flyableList.size();
                    j--;
                }
            }
        }
    }
}
