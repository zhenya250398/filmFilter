package com.example.sweater.repos;

import com.example.sweater.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepo extends JpaRepository<Movie, Long>{

    @Query(value = "SELECT * FROM Movie limit 10", nativeQuery = true)
    List<Movie> findAllWithLimit();
    @Query(value = "SELECT * FROM Movie where name like %?1% limit 10", nativeQuery = true)
    List<Movie> findByNameContaining(String name);
    @Query(value = "SELECT * FROM Movie where name = ?1 limit 10", nativeQuery = true)
    List<Movie> findByName(String name);
    @Query(value = "SELECT *  from movie where (select to_tsvector(name) @@ plainto_tsquery(?1)) limit 10", nativeQuery = true)
    List<Movie> findByNameContainingAndNameContaining(String name);
    @Query(value = "SELECT * FROM Movie where name like %?1% and year = ?2 limit 10", nativeQuery = true)
    List<Movie> findByNameContainingAndYear (String name, int year);

}
