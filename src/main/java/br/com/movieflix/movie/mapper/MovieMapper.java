package br.com.movieflix.movie.mapper;

import br.com.movieflix.movie.dto.MovieDTO;
import br.com.movieflix.movie.model.MovieEntity;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieEntity map(MovieDTO movieDTO){
        MovieEntity movie = new MovieEntity();
        movie.setId(movieDTO.getId());
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie.setReleaseDate(movieDTO.getReleaseDate());
        movie.setRating(movieDTO.getRating());
        movie.setCreatedAt(movieDTO.getCreatedAt());
        movie.setUpdatedAt(movieDTO.getUpdatedAt());
        movie.setCategories(movieDTO.getCategories());
        movie.setStreamings(movieDTO.getStreamings());
        return movie;
    }

    public MovieDTO map(MovieEntity movieEntity){
        MovieDTO movie = new MovieDTO();
        movie.setId(movieEntity.getId());
        movie.setName(movieEntity.getName());
        movie.setDescription(movieEntity.getDescription());
        movie.setReleaseDate(movieEntity.getReleaseDate());
        movie.setRating(movieEntity.getRating());
        movie.setCreatedAt(movieEntity.getCreatedAt());
        movie.setUpdatedAt(movieEntity.getUpdatedAt());
        movie.setCategories(movieEntity.getCategories());
        movie.setStreamings(movieEntity.getStreamings());
        return movie;
    }
}
