package de.bcxp.challenge.country;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CountriesAnalysis {
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
}
