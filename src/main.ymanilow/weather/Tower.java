package main.ymanilow.weather;

import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.Log;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers;
    private Log log;

    public Tower() {
        observers = new ArrayList<>();
    }

    public Tower(Log log) {
        this.log = log;
        observers = new ArrayList<>();
    }

    public void register(Flyable flyable){
        if (!observers.contains(flyable)) {
            observers.add(flyable);
            log.printMessage(
                    "Tower says: " +
                    flyable.getTypeOfAircraft() +
                    flyable.getNameOfAircraft() +
                    " registered to weather tower."
            );
        }
    }
    public void unregister(Flyable flyable) {
        logLanding(flyable.getTypeOfAircraft(), flyable.getNameOfAircraft());
        observers.remove(flyable);
        log.printMessage(
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
        log.printMessage(aircraftType.name() + nameOfAircraft + " landing.");
    }
}
