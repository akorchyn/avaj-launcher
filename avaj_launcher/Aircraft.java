package avaj_launcher;

public abstract class Aircraft {
    protected long   id;
    protected String name;
    protected Coordinates coordinates;

    private static long idCounter = 0;

    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    protected void logMessage(String additional) {
        System.out.println(getAirname() + ": " + additional);
    }

    public String getAirname() {
        return this.getClass().getSimpleName() + '#' + this.name + '(' + this.id + ')';
    }

    private long nextId() {
        return ++idCounter;
    }

}
