package com.example.pbl.utils;

import com.example.pbl.model.Story;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ListConverter {
    private final Set<Story> stories = new HashSet<>();

    public Set<Story> convertStringListByTopic(List<List<String>> stringData) {
        stringData.forEach(arr -> {
            String data = arr.get(0);
            String[] splitData = data.split(";");
            Story story = new Story(splitData[0],splitData[1],splitData[2]);
            stories.add(story);
        });
        return stories;
    }
}
