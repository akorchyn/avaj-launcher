public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String msg = new String();
        switch (weather) {
            case ("SUN"):
                coordinates.updateLatitude(10);
                coordinates.updateHeight(2);
                msg = "Finally, weather is good";
                break;
            case ("RAIN"):
                coordinates.updateLatitude(5);
                msg = "I hope, it isn't thunderstorm";
                break;
            case ("FOG"):
                coordinates.updateLatitude(1);
                msg = "Do you see something?";
                break;
            case ("SNOW"):
                coordinates.updateHeight(-7);
                msg = "Mayday, mayday, to much snowing";
        }
        this.logMessage(msg);
        if (coordinates.getHeight() == 0)
            weatherTower.unregister(this);
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
