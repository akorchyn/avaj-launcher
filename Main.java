import java.io.*;

public class Main {
    private WeatherTower weatherTower = new WeatherTower();
    private int          nChanges = 0;

    private void changeStream() {
        try {
            PrintStream file = new PrintStream(new FileOutputStream("simulation.txt"));
            System.setErr(System.out);
            System.setOut(file);
        }
        catch (FileNotFoundException e) {
            System.err.println("ERROR: " + e.getMessage());
            System.exit(1);
        }
    }

    private void startSimulation() {
        while (nChanges-- != 0) {
            weatherTower.changeWeather();
        }
    }

    private void parseFile(String filename) {
        try{
            int i = 1;
            FileReader file = new FileReader(filename);
            BufferedReader in = new BufferedReader(file);
            String line = in.readLine();
            nChanges = Integer.parseInt(line);
            while((line = in.readLine()) != null) {
                i++;
                String[] arguments = line.split(" ");
                if (arguments.length != 5)
                    throw new AvajException("Error on " + i + " line: not enough arguments");
                Flyable flyable = AircraftFactory.newAircraft(arguments[0], arguments[1], Integer.parseInt(arguments[2]),
                        Integer.parseInt(arguments[3]), Integer.parseInt(arguments[4]));
                flyable.registerTower(weatherTower);
            }
        }
        catch (FileNotFoundException e) {
            System.err.println("ERROR: " + e.getMessage());
            System.exit(1);
        }
        catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            System.exit(1);
        }
        catch (AvajException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        catch (NumberFormatException e) {
            System.err.println("ERROR: " + e.getMessage());
            System.exit(1);
        }
		catch (Exception e)
		{
			System.err.println("ERROR: " + e.getMessage());
			System.exit(1);
		}
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please give me a file");
            System.exit(0);
        }
        Main m = new Main();
        m.changeStream();
        m.parseFile(args[0]);
        m.startSimulation();
    }
}
