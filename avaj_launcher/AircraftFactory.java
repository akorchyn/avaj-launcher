package avaj_launcher;

public class AircraftFactory {

    static public Flyable newAircraft(String type, String name,
                                      int longitude, int latitude, int height) throws AvajException {
        Coordinates cords = new Coordinates(longitude, latitude, height);
        switch (type) {
            case ("Baloon"):
                return new Baloon(name, cords);
            case ("Helicopter"):
                return new Helicopter(name, cords);
            case ("JetPlane"):
                return new JetPlane(name, cords);
            default:
                throw new AvajException("No such type: " + type);
        }
    }
}
