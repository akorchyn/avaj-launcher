public interface Flyable {
    void   updateConditions();
    void   registerTower(WeatherTower WeatherTower);
    String getAirname();
}
