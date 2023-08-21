package de.bcxp.challenge;

import de.bcxp.challenge.country.Country;
import de.bcxp.challenge.country.CountriesTools;
import de.bcxp.challenge.reader.CSVReader;
import de.bcxp.challenge.weather.WeatherDatapoint;
import de.bcxp.challenge.weather.WeatherTools;

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

        // Loading and initialising the weather objects
        LinkedList<HashMap> weatherDataList = csvReader.readFile("/de/bcxp/challenge/weather.csv", ",");
        LinkedList<WeatherDatapoint> weatherDatapointList = WeatherTools.createObjectList(weatherDataList);

        // Loading and initialising the country objects
        LinkedList<HashMap> countriesDataList = csvReader.readFile("/de/bcxp/challenge/countries.csv", ";");
        LinkedList<Country> countriesObjectList = CountriesTools.createObjectList(countriesDataList);

        String dayWithSmallestTempSpread = String.valueOf(WeatherTools.getDayWithSmallestTemperatureSpread(weatherDatapointList));     // Your day analysis function call …
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = CountriesTools.getCountryWithHighestPopulationDensity(countriesObjectList); // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
