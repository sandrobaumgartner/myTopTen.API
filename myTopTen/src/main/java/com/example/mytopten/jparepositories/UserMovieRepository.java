package com.example.mytopten.jparepositories;

import com.example.mytopten.models.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserMovieRepository extends JpaRepository<UserMovie, Long> {

    @Query("SELECT um FROM UserMovie um INNER JOIN Movie m ON um.movie.id = m.id WHERE um.user.id = :userId ORDER BY um.position")
    Optional<List<UserMovie>> findMoviesByUserId(Long userId);
    @SuppressWarnings("unchecked")
    UserMovie save(UserMovie userMovie);
}
