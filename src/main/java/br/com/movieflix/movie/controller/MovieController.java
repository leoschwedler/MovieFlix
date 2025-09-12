package br.com.movieflix.movie.controller;

import br.com.movieflix.movie.dto.MovieDTO;
import br.com.movieflix.movie.model.MovieEntity;
import br.com.movieflix.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        List<MovieDTO> movies = service.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/seach/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id){
        MovieDTO movie = service.getMovieById(id);
        if (movie != null){
            return ResponseEntity.ok(movie);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O filme com o ID: " + id + " nao existe nos nossos registros");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO){
        MovieDTO movie = service.createMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        if (service.getMovieById(id) != null){
            service.deleteMovie(id);
            return ResponseEntity.ok("O filme com o ID: " + id + " foi deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O filme com o ID: " + id + " nao existe nos nossos registros");
        }
    }
}
