package com.csvFileProcessor.Service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.csvFileProcessor.Model.CustomData;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@UtilityClass
public class ServiceUtils {
    public static String processCSVFile(String csvFilePath) {

        CustomData customData = new CustomData();
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            // Read the header to get column names
            String[] header = reader.readNext();

            // Map to store column indices
            Map<String, Integer> columnIndexMap = new HashMap<>();
            for (int i = 0; i < header.length; i++) {
                columnIndexMap.put(header[i], i);
            }

            // Variables for statistics
            int totalRecords = 0;
            int searchCount = 0;

            // Perform statistics and search
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                totalRecords++;

                // Example: Search for a record with a specific condition
                String conditionColumnName = "Age";
                String conditionValue = "25";
                int conditionColumnIndex = columnIndexMap.get(conditionColumnName);
                String valueInConditionColumn = nextLine[conditionColumnIndex];

                if (valueInConditionColumn.equals(conditionValue)) {
                    // Found a record that matches the condition
                    searchCount++;
                    // Perform further processing or print the record
                    System.out.println("Found matching record: " + String.join(", ", nextLine));
                }

                // You can add more logic for other statistics
            }

            customData.setSearchCount(searchCount);
            customData.setTotalRecords(totalRecords);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return customData.toString();

    }
}
