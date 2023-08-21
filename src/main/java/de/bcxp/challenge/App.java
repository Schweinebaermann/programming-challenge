package de.bcxp.challenge;

import de.bcxp.challenge.country.Country;
import de.bcxp.challenge.country.CountriesAnalysis;
import de.bcxp.challenge.reader.CSVReader;
import de.bcxp.challenge.weather.WeatherDatapoint;
import de.bcxp.challenge.weather.WeatherAnalysis;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     *
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Your preparation code …
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.ALL);

        CSVReader csvReader = new CSVReader();
        LinkedList<HashMap> weatherDataList = csvReader.readFile("/de/bcxp/challenge/weather.csv", ",");
        LinkedList<WeatherDatapoint> weatherDatapointList = new LinkedList<>();

        for (HashMap value : weatherDataList) {
            try {
                weatherDatapointList.add(new WeatherDatapoint(value));
            } catch (NoSuchFieldException | NumberFormatException e) {
                e.printStackTrace();
                return;
            }
        }


        LinkedList<HashMap> countriesDataList = csvReader.readFile("/de/bcxp/challenge/countries.csv", ";");
        LinkedList<Country> countriesObjectList = new LinkedList<>();

        for (HashMap value : countriesDataList) {
            try {
                countriesObjectList.add(new Country(value));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return;
            }
        }

        String dayWithSmallestTempSpread = String.valueOf(WeatherAnalysis.getDayWithSmallestTemperatureSpread(weatherDatapointList));     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = CountriesAnalysis.getCountryWithHighestPopulationDensity(countriesObjectList); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
