import java.util.ArrayList;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable) {
        System.out.println("Tower says: " + flyable.getAirname() + " registered to weather tower.");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        System.out.println("Tower says: " + flyable.getAirname() + " unregistered from weather tower.");
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++)
            observers.get(i).updateConditions();
    }
}
