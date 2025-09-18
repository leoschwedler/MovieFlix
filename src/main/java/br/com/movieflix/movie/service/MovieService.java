package br.com.movieflix.movie.service;

import br.com.movieflix.category.dto.CategoryDTO;
import br.com.movieflix.category.mapper.CategoryMapper;
import br.com.movieflix.category.model.CategoryEntity;
import br.com.movieflix.category.service.CategoryService;
import br.com.movieflix.movie.dto.MovieDTO;
import br.com.movieflix.movie.mapper.MovieMapper;
import br.com.movieflix.movie.model.MovieEntity;
import br.com.movieflix.movie.repository.MovieRepository;
import br.com.movieflix.streaming.dto.StreamingDTO;
import br.com.movieflix.streaming.mapper.StreamingMapper;
import br.com.movieflix.streaming.model.StreamingEntity;
import br.com.movieflix.streaming.service.StreamingService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieMapper movieMapper;
    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final StreamingService streamingService;
    private final StreamingMapper streamingMapper;

    public MovieService(MovieMapper movieMapper, MovieRepository repository, CategoryService categoryService, CategoryMapper categoryMapper, StreamingService streamingService, StreamingMapper streamingMapper) {
        this.movieMapper = movieMapper;
        this.repository = repository;
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
        this.streamingService = streamingService;
        this.streamingMapper = streamingMapper;
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

        if (movie.getCategories() != null  && !movie.getCategories().isEmpty()){
            movie.setCategories(findCategories(movie.getCategories()));
        }

        if (movie.getStreamings() != null && !movie.getStreamings().isEmpty()) {
            movie.setStreamings(findStreamings(movie.getStreamings()));
        }

        movie = repository.save(movie);
        return movieMapper.map(movie);
    }

    public void deleteMovie(Long id){
        repository.deleteById(id);
    }

    private List<CategoryEntity> findCategories(List<CategoryEntity> categories){
        List<CategoryEntity> categoriesFound = new ArrayList<>();
        for (CategoryEntity category : categories){
           CategoryDTO dto = categoryService.getCategoryById(category.getId());
           if (dto != null){
               categoriesFound.add(categoryMapper.map(dto));
           }
        }
        return categoriesFound;
    }


    public List<MovieDTO> getMovieByCategory(List<Long> categoryId){
        return repository.findByCategories_IdIn(categoryId)
                .stream()
                .map(movieMapper::map)
                .collect(Collectors.toList());
    }


    private List<StreamingEntity> findStreamings(List<StreamingEntity> streamings) {
        List<StreamingEntity> streamingsFound = new ArrayList<>();
        for (StreamingEntity streaming : streamings) {
            StreamingDTO dto = streamingService.getStreamingById(streaming.getId());
            if (dto != null) {
                streamingsFound.add(streamingMapper.map(dto));
            }
        }
        return streamingsFound;
    }

    public MovieDTO updateMovie(Long id, MovieDTO movieDTO){
        Optional<MovieEntity> movieExist = repository.findById(id);
        if (movieExist.isPresent()){
            MovieEntity movie = movieMapper.map(movieDTO);
            movie.setId(id);
            MovieEntity movieSave = repository.save(movie);
            return movieMapper.map(movieSave);
        }else {
            return null;
        }
    }

}
