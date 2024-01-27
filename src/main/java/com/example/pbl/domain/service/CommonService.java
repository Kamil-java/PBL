package com.example.pbl.domain.service;

import com.example.pbl.model.Story;
import com.example.pbl.utils.ListConverter;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommonService {
    private final CSVService csvService;
    private final ListConverter listConverter;
    private final Set<Story> usedStories = new HashSet<>();

    public CommonService(CSVService csvService, ListConverter listConverter) {
        this.csvService = csvService;
        this.listConverter = listConverter;
    }

    public Optional<Story> singleStory(String character, String action) {
        Set<Story> stories = getStories();
        stories.removeAll(usedStories);
        Optional<Story> first = stories.stream().filter(story -> story.getCharacter().equals(character) && story.getAction().equals(action)).findFirst();
        first.ifPresent(usedStories::add);
        return first;
    }

    public Optional<Story> singleStoryByAction(String action) {
        Set<Story> stories = getStories();
        stories.removeAll(usedStories);
        Optional<Story> first = stories.stream().filter(story -> story.getAction().equals(action)).findFirst();
        first.ifPresent(usedStories::add);
        return first;
    }

    public Optional<Story> singleStoryByCharacter(String character) {
        Set<Story> stories = getStories();
        stories.removeAll(usedStories);
        Optional<Story> first = stories.stream().filter(story -> story.getCharacter().equals(character)).findFirst();
        first.ifPresent(usedStories::add);
        return first;
    }

    public Set<Story> allStory() {
        return getStories();
    }

    public List<Story> allStoryByCharacter(String character) {
        return getStories().stream().filter(story -> story.getCharacter().equals(character)).toList();
    }

    public List<Story> allStoryByAction(String action) {
        return getStories().stream().filter(story -> story.getAction().equals(action)).toList();
    }

    private Set<Story> getStories() {
        return listConverter.convertStringListByTopic(csvService.getAllStories());
    }
}
