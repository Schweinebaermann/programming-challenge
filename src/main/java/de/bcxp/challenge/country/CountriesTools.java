package de.bcxp.challenge.country;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CountriesTools {
    /**
     * Determines the country with the highest population density from a list of countries.
     *
     * @param countriesObjectList List of country objects.
     * @return The name of the country with the the highest population density.
     */
    public static String getCountryWithHighestPopulationDensity(LinkedList<Country> countriesObjectList) {
        Country searchedCountry = countriesObjectList
                .stream()
                .max(Comparator.comparing(country -> country.getPopulationDensity()))
                .orElseThrow(NoSuchElementException::new);
        return searchedCountry.getName();
    }

    /**
     * Creates a list of country objects from a list of maps.
     *
     * @param dataList A list of maps, each containing information about a country.
     * @return A list of initialised country objects.
     */
    public static LinkedList<Country> createObjectList(LinkedList<HashMap> dataList) {
        LinkedList<Country> countriesObjectList = new LinkedList<>();

        for (HashMap value : dataList) {
            try {
                countriesObjectList.add(new Country(value));
            } catch (NoSuchFieldException | NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return countriesObjectList;
    }
}
