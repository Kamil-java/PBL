package com.example.pbl.domain.controller;

import com.example.pbl.domain.service.CommonService;
import com.example.pbl.model.Story;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/story")
public class CommonStoryController {
    private final CommonService commonService;

    public CommonStoryController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/single")
    public Story getSingleStory(@RequestParam("character") String character, @RequestParam("action") String action) {
        return commonService.singleStory(character, action).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/single/action")
    public Story getSingleStoryByAction(@RequestParam("action") String action) {
        return commonService.singleStoryByAction(action).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/single/character")
    public Story getSingleStoryByCharacter(@RequestParam("character") String character) {
        return commonService.singleStoryByCharacter(character).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/all")
    public Set<Story> getAllStory() {
        Set<Story> stories = commonService.allStory();
        if (stories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return stories;
    }

    @GetMapping("/all/action")
    public List<Story> getAllStoryByAction(@RequestParam("action") String action) {
        List<Story> stories = commonService.allStoryByAction(action);
        if (stories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return stories;
    }

    @GetMapping("/all/character")
    public List<Story> getAllStoryByCharacter(@RequestParam("character") String character) {
        List<Story> stories = commonService.allStoryByCharacter(character);
        if (stories.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return stories;
    }
}
