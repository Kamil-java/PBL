package com.example.pbl.domain.service;

import com.example.pbl.utils.CSVReader;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CSVService {
    private final CSVReader csvReader;

    public CSVService(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    public void updateStoryHouse() {
        csvReader.readCSV();
    }

    public List<List<String>> getAllStories() {
        return csvReader.getRecords();
    }
}
