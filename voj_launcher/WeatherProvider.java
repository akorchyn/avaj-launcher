package voj_launcher;
import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider ourInstance = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    public static WeatherProvider getProvider() {
        return ourInstance;
    }
    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();

        int randomNum = rand.nextInt(1000);
        int index = (randomNum + coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) % 4;
        return weather[index];
    }

    private WeatherProvider() {
    }

}
