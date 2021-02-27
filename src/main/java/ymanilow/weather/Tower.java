package ymanilow.weather;

import ymanilow.utils.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private final List<Flyable> observers;

    public Tower() {
        observers = new ArrayList<Flyable>();
    }

    public void register(Flyable flyable){
        if (observers.contains(flyable)) {
            observers.add(flyable);
        }
    }
    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        System.out.println("aaaaa");
    }
}
