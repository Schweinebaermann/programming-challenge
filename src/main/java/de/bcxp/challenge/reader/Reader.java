package de.bcxp.challenge.reader;

import java.util.LinkedList;

public interface Reader {

    /**
     * Reads a file and returns a list of maps. These contain the values for each of the different headers.
     *
     * @param filePath  Path to the file from the resources-folder.
     * @param separator Character used to separate the values.
     * @return A list of maps containing the values for the different headers.
     */
    LinkedList readFile(String filePath, String separator);
}
