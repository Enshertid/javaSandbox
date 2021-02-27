package ymanilow.weather;

import ymanilow.utils.AircraftType;
import ymanilow.utils.Flyable;
import ymanilow.utils.Log;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers;
    private Log log = new Log();

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable){
        if (!observers.contains(flyable)) {
            observers.add(flyable);
        }
    }
    public void unregister(Flyable flyable) {
        logLanding(flyable.getTypeOfAircraft(), flyable.getNameOfAircraft());
        observers.remove(flyable);
        log.getStream().println(
                "Tower says: " +
                flyable.getTypeOfAircraft() +
                flyable.getNameOfAircraft() +
                " unregistered from weather tower."
        );
    }
    public List<Flyable> getObservers() {
        return observers;
    }

    protected void conditionsChanged() {
    }

    private void logLanding(AircraftType aircraftType, String nameOfAircraft) {
        log.getStream().println(aircraftType.name() + nameOfAircraft + " landing.");
    }
}
