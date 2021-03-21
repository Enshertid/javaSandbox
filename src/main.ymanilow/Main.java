package main.ymanilow;

import main.ymanilow.exceptions.AvajException;
import main.ymanilow.parser.Scenario;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.Log;
import main.ymanilow.weather.WeatherTower;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws AvajException, FileNotFoundException {
        Scanner scanner = setScanner(args);
        Log log = new Log(System.out, new PrintStream("scenario.txt"));
        WeatherTower weatherTower = new WeatherTower(log);

        Scenario scenario = getScenario(scanner, log);
        scenario.scanScenario();

        List<Flyable> flyableCrafts = scenario.getFlyableCrafts();
        for (Flyable flyableCraft : flyableCrafts) {
            weatherTower.register(flyableCraft);
            flyableCraft.registerTower(weatherTower);
        }

        for (int i = 0; i < scenario.getIterations(); i++) {
            weatherTower.doAction();
        }
    }

    private static Scenario getScenario(Scanner scanner, Log log) throws AvajException {
        try {
            return new Scenario(scanner, log);
        } catch (AvajException ex) {
            log.printException(ex);
            throw ex;
        }
    }

    public static Scanner setScanner(String [] args) throws AvajException {
        if (args.length == 1) {
            try {
                return new Scanner(new File(args[0]));
            } catch (FileNotFoundException ex) {
                throw new AvajException("have no file there " + args[0], ex);
            }
        } else {
            throw new AvajException("invalid input, must be only one argument, with path to Scenario file");
        }
    }
}
