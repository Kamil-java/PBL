package com.example.pbl.utils;

import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CSVReader {
    private final List<List<String>> records = new ArrayList<>();
    public void readCSV() {
        try (com.opencsv.CSVReader csvReader = new com.opencsv.CSVReader(new FileReader("stories.csv"))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }
            System.out.println(records);
        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<List<String>> getRecords() {
        return records;
    }
}
