package de.bcxp.challenge.reader;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

public class CSVReader implements Reader {

    @Override
    public LinkedList readFile(String filePath, String separator) {
        InputStream is = this.getClass().getResourceAsStream(filePath);
        LinkedList<HashMap> outputList = new LinkedList();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            String[] header = br.readLine().split(separator);
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(separator);

                HashMap<String, String> valueMap = new HashMap();
                for (int i = 0; i < values.length; i++) {
                    valueMap.put(header[i], values[i]);
                }
                outputList.add(valueMap);

            }
        } catch (NullPointerException e) {
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            logger.severe("File is empty or the file path is wrong.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputList;
    }
}

