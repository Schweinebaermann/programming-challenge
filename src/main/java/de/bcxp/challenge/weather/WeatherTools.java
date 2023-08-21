package de.bcxp.challenge.weather;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class WeatherTools {
    /**
     * Determines the day with the highest population density from a list of weather datapoints.
     *
     * @param weatherDatapointList List of weather datapoints.
     * @return The day with the smallest temperature spread.
     */
    public static int getDayWithSmallestTemperatureSpread(LinkedList<WeatherDatapoint> weatherDatapointList) {
        WeatherDatapoint searchedDatapoint = weatherDatapointList
                .stream()
                .min(Comparator.comparing(datapoint -> datapoint.getTemperatureSpread()))
                .orElseThrow(NoSuchElementException::new);
        return searchedDatapoint.getDay();
    }

    /**
     * Creates a list of weather datapoints from a list of maps.
     *
     * @param dataList A list of maps, each containing information about a weather datapoint.
     * @return A list of initialised weather-datapoint objects.
     */
    public static LinkedList<WeatherDatapoint> createObjectList(LinkedList<HashMap> dataList) {
        LinkedList<WeatherDatapoint> weatherDatapointList = new LinkedList<>();

        for (HashMap value : dataList) {
            try {
                weatherDatapointList.add(new WeatherDatapoint(value));
            } catch (NoSuchFieldException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return weatherDatapointList;
    }
}
