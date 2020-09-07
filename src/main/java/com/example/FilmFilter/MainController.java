package com.example.FilmFilter;

import com.example.FilmFilter.domain.Movie;
import com.example.FilmFilter.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    private final FilmRepo filmRepo;

    public MainController(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping
    public String main() {
        return "main";
    }

    @PostMapping("filterByFull")
    public String filterByFull(@RequestParam String filterByFull, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByFull != null && !filterByFull.isEmpty()) {
            messages = filmRepo.findByName(filterByFull);
        } else {
            messages = filmRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterByWord")
    public String filterByWord(@RequestParam String filterByWord, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByWord != null && !filterByWord.isEmpty()) {
            messages = filmRepo.findByNameContaining(filterByWord);
        } else {
            messages = filmRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterByWords")
    public String filterByWords(@RequestParam String filterByWords, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByWords != null && !filterByWords.isEmpty()) {
            messages = filmRepo.findByNameContainingAndNameContaining(filterByWords);
        } else {
            messages = filmRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }

    @PostMapping("filterByWordsYear")
    public String filterByWordsYear(@RequestParam String filterByWord,int filterByYear, Map<String, Object> model) {
        Iterable<Movie> messages;

        if (filterByWord != null && !filterByWord.isEmpty()) {
            messages = filmRepo.findByNameContainingAndYear(filterByWord,filterByYear);
        } else {
            messages = filmRepo.findAllWithLimit();
        }

        model.put("messages", messages);

        return "main";
    }
}
