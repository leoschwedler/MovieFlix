package br.com.movieflix.movie.service;

import br.com.movieflix.movie.dto.MovieDTO;
import br.com.movieflix.movie.mapper.MovieMapper;
import br.com.movieflix.movie.model.MovieEntity;
import br.com.movieflix.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository repository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.repository = movieRepository;
    }

    public List<MovieDTO> getAllMovies(){
        List<MovieEntity> movie = repository.findAll();
        return movie.stream()
                .map(movieMapper::map)
                .collect(Collectors.toList());
    }

    public MovieDTO getMovieById(Long id){
        Optional<MovieEntity> movie = repository.findById(id);
        return movie.map(movieMapper::map).orElse(null);
    }

    public MovieDTO createMovie(MovieDTO movieDTO){
        MovieEntity movie = movieMapper.map(movieDTO);
        movie = repository.save(movie);
        return movieMapper.map(movie);
    }

    public void deleteMovie(Long id){
        repository.deleteById(id);
    }
}
