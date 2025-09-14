package br.com.movieflix.movie.repository;

import br.com.movieflix.category.model.CategoryEntity;
import br.com.movieflix.movie.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository  extends JpaRepository<MovieEntity, Long> {

    List<MovieEntity> findByCategories_IdIn(List<Long> categoryIds);

}
