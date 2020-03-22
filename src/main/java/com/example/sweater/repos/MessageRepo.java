package com.example.sweater.repos;

import com.example.sweater.domain.Movie;
import com.example.sweater.domain.QMovie;
import javafx.beans.binding.BooleanExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public interface MessageRepo extends JpaRepository<Movie, Long>, QueryDslPredicateExecutor<Movie>{

    List<Movie> findByNameContaining(String name);
    List<Movie> findByName(String name);
    List<Movie> findByNameContaining(List<String> names);
    List<Movie> findByNameContainingAndYear (String name, int year);

}
