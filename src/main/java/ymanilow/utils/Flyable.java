package ymanilow.utils;

import ymanilow.weather.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
    public AircraftType getTypeOfAircraft();
    public String getNameOfAircraft();
}
