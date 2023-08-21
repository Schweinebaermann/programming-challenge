package de.bcxp.challenge.weather;

import java.util.HashMap;
import java.util.logging.Logger;

public class WeatherDatapoint {
    private int minTemperature;
    private int maxTemperature;
    private int day;

    /**
     * Constructor for creating a weather-datapoint.
     *
     * @param map A HashMap containing the data for the weather of a day.
     * @throws NoSuchFieldException
     */
    public WeatherDatapoint(HashMap<String, String> map) throws NoSuchFieldException, NumberFormatException {
        if (map.containsKey("MnT") && map.containsKey("MxT") && map.containsKey("Day")) {
            try {
                this.minTemperature = Integer.parseInt(map.get("MnT"));
                this.maxTemperature = Integer.parseInt(map.get("MxT"));
                this.day = Integer.parseInt(map.get("Day"));
            } catch (NumberFormatException nfe) {
                Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
                logger.severe("Numerical data for the weather datapoint are in the wrong format.");
                throw new NumberFormatException();
            }
        } else {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.severe("Missing fields in the input map for creating a weather datapoint.");
            throw new NoSuchFieldException();
        }
    }

    /**
     * Calculates the temperature spread of the day.
     *
     * @return The temperature spread.
     */
    public int getTemperatureSpread() {
        return maxTemperature - minTemperature;
    }

    public int getDay() {
        return day;
    }
}
