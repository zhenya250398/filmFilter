package com.example.sweater;

import com.example.sweater.domain.Movie;
import com.example.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        return "main";
    }

    @PostMapping("filterByFull")
    public String filterByFull(@RequestParam String filterByFull, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByFull != null && !filterByFull.isEmpty()) {
            messages = messageRepo.findByName(filterByFull);
        } else {
            messages = messageRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterByWord")
    public String filterByWord(@RequestParam String filterByWord, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByWord != null && !filterByWord.isEmpty()) {
            messages = messageRepo.findByNameContaining(filterByWord);
        } else {
            messages = messageRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterByWords")
    public String filterByWords(@RequestParam String filterByWords, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByWords != null && !filterByWords.isEmpty()) {
            messages = messageRepo.findByNameContainingAndNameContaining(filterByWords);
        } else {
            messages = messageRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterByWordsYear")
    public String filterByWordsYear(@RequestParam String filterByWord,int filterByYear, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByWord != null && !filterByWord.isEmpty()) {
            messages = messageRepo.findByNameContainingAndYear(filterByWord,filterByYear);
        } else {
            messages = messageRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }
}
