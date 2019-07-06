package voj_launcher;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String msg = new String();
        switch (weather) {
            case ("SUN"):
                coordinates.updateLongitude(10);
                coordinates.updateHeight(2);
                msg = "Sunny and funny";
                break;
            case ("RAIN"):
                coordinates.updateLongitude(5);
                msg = "Yey, rain cleans our helicopter.";
                break;
            case ("FOG"):
                coordinates.updateLongitude(1);
                msg = "I don't see anything";
                break;
            case ("SNOW"):
                coordinates.updateHeight(-12);
                msg = "Let it snow, let it snow, let it snow";
        }
        this.logMessage(msg);
        if (coordinates.getHeight() == 0)
            weatherTower.unregister(this);
    }
}
