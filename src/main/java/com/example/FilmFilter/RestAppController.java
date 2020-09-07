package com.example.FilmFilter;

import com.example.FilmFilter.domain.Movie;
import com.example.FilmFilter.repos.FilmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest")
public class RestAppController {
    private  final FilmRepo filmRepo;

    public RestAppController(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping
    public List<Movie> list(){return filmRepo.findAll();}

    @GetMapping("{name}")
    public List<Movie> findByFullName(@PathVariable String name){ return filmRepo.findByName(name);
    }

    @GetMapping("one/{name}")
    public List<Movie> findByOne(@PathVariable String name){ return filmRepo.findByNameContaining(name);
    }

    @GetMapping("some/{name}")
    public List<Movie> findBySome(@PathVariable String name){ return filmRepo.findByNameContainingAndNameContaining(name);
    }

    @GetMapping("year/{name}")
    public List<Movie> findByYear(@PathVariable String name){
        String[] names = name.split("_");
        return filmRepo.findByNameContainingAndYear(names[0], Integer.parseInt(names[1]));
    }

}
