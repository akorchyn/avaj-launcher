public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String msg = new String();
        switch (weather) {
            case ("SUN"):
                coordinates.updateLongitude(2);
                coordinates.updateHeight(4);
                msg = "Excellent weather to fly";
                break;
            case ("RAIN"):
                coordinates.updateHeight(-5);
                msg = "Weather is bad. We are landing";
                break;
            case ("FOG"):
                coordinates.updateHeight(-3);
                msg = "Landing procedure is started";
                break;
            case ("SNOW"):
                coordinates.updateHeight(-15);
                msg = "Why i fly in such weather?";
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
