package de.bcxp.challenge.weather;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class WeatherAnalysis {
    /**
     * Determines the day with the highest population density from a list of weather datapoints.
     *
     * @param weatherObjectList List of weather datapoints.
     * @return The day with the smallest temperature spread.
     */
    public static int getDayWithSmallestTemperatureSpread(LinkedList<WeatherDatapoint> weatherObjectList) {
        WeatherDatapoint searchedDatapoint = weatherObjectList
                .stream()
                .min(Comparator.comparing(datapoint -> datapoint.getTemperatureSpread()))
                .orElseThrow(NoSuchElementException::new);
        return searchedDatapoint.getDay();
    }
}
