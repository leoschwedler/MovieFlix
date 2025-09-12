package br.com.movieflix.movie.repository;

import br.com.movieflix.movie.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<MovieEntity, Long> {
}
