package com.example.pbl.domain.controller;


import com.example.pbl.domain.service.CSVService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/csv")
public class CSVController {
    private final CSVService csvService;

    public CSVController(CSVService csvService) {
        this.csvService = csvService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCSVStoriesHouse() {
        csvService.updateStoryHouse();
    }
}
