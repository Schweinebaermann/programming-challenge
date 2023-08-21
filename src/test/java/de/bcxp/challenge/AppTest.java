package de.bcxp.challenge;

import de.bcxp.challenge.country.Country;
import de.bcxp.challenge.country.CountriesTools;
import de.bcxp.challenge.reader.CSVReader;
import de.bcxp.challenge.weather.WeatherDatapoint;
import de.bcxp.challenge.weather.WeatherTools;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit test cases.
 */
class AppTest {

    @Test
    void readCSVTest() {
        CSVReader csvReader = new CSVReader();
        LinkedList<HashMap> weatherDataList = csvReader.readFile("/de/bcxp/challenge/weather.csv", ",");
        assertEquals(30, weatherDataList.size(), "Wrong number of data rows found for the weather.csv file");
        assertEquals(14, weatherDataList.get(0).size(), "Wrong number of data columns found for the weather.csv file");
        LinkedList<HashMap> countriesDataList = csvReader.readFile("/de/bcxp/challenge/countries.csv", ";");
        assertEquals(27, countriesDataList.size(), "Wrong number of data rows found for the countries.csv file");
        assertEquals(8, countriesDataList.get(0).size(), "Wrong number of data columns found for the countries.csv file");
        LinkedList<HashMap> otherDataList = csvReader.readFile("/de/bcxp/challenge/not_existing.csv", ",");
        assertEquals(0, otherDataList.size(), "A non-existent file should lead to an empty list");
    }

    @Test
    void weatherTest() throws NoSuchFieldException {
        LinkedList<WeatherDatapoint> weatherDatapointList = new LinkedList<>();

        HashMap<String, String> datapoint1 = new HashMap();
        datapoint1.put("Day", "12");
        datapoint1.put("MxT", "86");
        datapoint1.put("MnT", "32");
        weatherDatapointList.add(new WeatherDatapoint(datapoint1));

        HashMap<String, String> datapoint2 = new HashMap();
        datapoint2.put("Day", "15");
        datapoint2.put("MxT", "72");
        datapoint2.put("MnT", "45");
        weatherDatapointList.add(new WeatherDatapoint(datapoint2));

        assertEquals(54, weatherDatapointList.get(0).getTemperatureSpread(), "Incorrectly determined temperature spread");

        int dayWithSmallestTempSpread = WeatherTools.getDayWithSmallestTemperatureSpread(weatherDatapointList);

        assertEquals(15, dayWithSmallestTempSpread, "Wrong determined day with minimum temperature spread");

    }

    @Test
    void countriesTest() throws NoSuchFieldException {
        LinkedList<Country> countryObjectList = new LinkedList<>();

        HashMap<String, String> country1 = new HashMap();
        country1.put("Name", "Test1");
        country1.put("Population", "9014520");
        country1.put("Area (km²)", "83856");
        countryObjectList.add(new Country(country1));

        HashMap<String, String> country2 = new HashMap();
        country2.put("Name", "Test2");
        country2.put("Population", "9926000");
        country2.put("Area (km²)", "103855");
        countryObjectList.add(new Country(country2));

        assertEquals(107.5, countryObjectList.get(0).getPopulationDensity(), "Incorrectly determined population density");

        String countryWithHighestPopulationDensity = CountriesTools.getCountryWithHighestPopulationDensity(countryObjectList);

        assertEquals("Test1", countryWithHighestPopulationDensity, "Wrong determined country name with the highest population density");

    }

}
