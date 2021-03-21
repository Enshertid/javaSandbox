package main.ymanilow.parser;

import main.ymanilow.aircraft.AircraftFactory;
import main.ymanilow.exceptions.AvajException;
import main.ymanilow.utils.AircraftType;
import main.ymanilow.utils.Coordinates;
import main.ymanilow.utils.Flyable;
import main.ymanilow.utils.Log;

import java.util.*;

public class Scenario {
    private long iterations;
    private long numOfCurrentString;
    private List<Flyable> flyableCrafts;
    private final Log log;
    private final Scanner scanner;

    public Scenario(Scanner scanner, Log log) throws AvajException {
        this.scanner = scanner;
        this.log = log;
    }

    public void scanScenario() throws AvajException {
            scanIterations();
            scanCrafts();
    }

    private void scanIterations() throws AvajException {
        try {
            numOfCurrentString++;
            iterations = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException ex) {
            throw new AvajException("first line must be some integer/long value of cycles", ex, numOfCurrentString);
        } catch (Exception ex) {
            throw new AvajException("problem with file", ex);
        }
    }

    private void scanCrafts() throws AvajException {
        flyableCrafts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            try {
                numOfCurrentString++;
                flyableCrafts.add(checkLine(scanner.nextLine()));
            } catch (AvajException ex) {
                log.printExceptionWithoutStacktrace(ex);
            }
        }
        if (flyableCrafts.isEmpty()) {
            throw new AvajException("scenario file have no Aircraft, program is ending");
        }
    }

    private Flyable checkLine(String nextLine) throws AvajException {
        List<String> tokens = Arrays.asList(nextLine.split(" "));

        if (tokens.size() != 5) {
            throw new AvajException("not enough characteristics of Aircraft in string", numOfCurrentString);
        }

        String type = checkTypeValid(tokens.get(0));
        String name = tokens.get(1);
        Coordinates coordinates = checkCoordinatesValid(tokens.get(2), tokens.get(3), tokens.get(4));

        return AircraftFactory.newAircraft(
                type
                , name
                , coordinates.getLongitude()
                , coordinates.getLatitude()
                , coordinates.getHeight()
        );
    }

    private String checkTypeValid(String type) throws AvajException {
        if (type.equals(AircraftType.Baloon.name()) || type.equals(AircraftType.Helicopter.name()) || type.equals(AircraftType.JetPlane.name())) {
            return type;
        } else {
            throw new AvajException ("wrong type of aircraft", numOfCurrentString);
        }
    }

    private Coordinates checkCoordinatesValid(String longitude, String latitude, String height) throws AvajException {
        try {
            int longitudeNum = Integer.parseInt(longitude);
            int latitudeNum = Integer.parseInt(latitude);
            int heightNum = Integer.parseInt(height);
            if (longitudeNum <= 0 || latitudeNum <= 0 || heightNum <= 0)
                throw new AvajException("coordinates must be positive integer number", numOfCurrentString);
            return new Coordinates(longitudeNum, latitudeNum, heightNum);
        } catch (NumberFormatException ex) {
            throw new AvajException("wrong format of coordinate's number", ex, numOfCurrentString);
        }
    }

    public long getIterations() {
        return iterations;
    }

    public List<Flyable> getFlyableCrafts() {
        return flyableCrafts;
    }
}
