package de.bcxp.challenge.country;

import java.util.HashMap;
import java.util.logging.Logger;

public class Country {
    private int population;
    private int area;
    private String name;

    /**
     * Constructor for creating a country object.
     *
     * @param map A HashMap containing the data for the country.
     * @throws NoSuchFieldException
     */
    public Country(HashMap<String, String> map) throws NoSuchFieldException, NumberFormatException {
        if (map.containsKey("Name") && map.containsKey("Population") && map.containsKey("Area (km²)")) {
            this.name = map.get("Name");
            try {
                this.population = Integer.parseInt(map.get("Population").replaceAll("\\.", "").replaceAll(",00", ""));
                this.area = Integer.parseInt(map.get("Area (km²)"));
            } catch (NumberFormatException nfe) {
                Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
                logger.severe("Numerical data for the country statistics are in the wrong format.");
                throw new NumberFormatException();
            }
        } else {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.severe("Missing fields in the input map for creating a country object.");
            throw new NoSuchFieldException();
        }
    }

    /**
     * Calculates the population density of the country.
     *
     * @return The population density.
     */
    public double getPopulationDensity() {
        return (double) population / area;
    }

    public String getName() {
        return name;
    }
}
