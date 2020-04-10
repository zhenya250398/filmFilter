package com.example.sweater.repos;

import com.example.sweater.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Movie, Long>{

    List<Movie> findByNameContaining(String name);
    List<Movie> findByName(String name);
    List<Movie> findByNameContainingAndNameContaining(String name,String name2);
    List<Movie> findByNameContainingAndYear (String name, int year);

}
