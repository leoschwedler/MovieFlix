package br.com.movieflix.streaming.controller;

import br.com.movieflix.category.dto.CategoryDTO;
import br.com.movieflix.streaming.dto.StreamingDTO;
import br.com.movieflix.streaming.service.StreamingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaming")
public class StreamingController {

    private final StreamingService service;

    public StreamingController(StreamingService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<StreamingDTO>> getAllStreamings() {
        List<StreamingDTO> categories = service.getAllStreamings();
        return ResponseEntity.ok(categories);
    }


    @PostMapping("create")
    public ResponseEntity<StreamingDTO> createStreaming(@RequestBody StreamingDTO streamingDTO) {
        StreamingDTO streaming = service.createStreaming(streamingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(streaming);
    }


    @GetMapping("search/{id}")
    public ResponseEntity<?> getStreamingById(@PathVariable Long id) {
        StreamingDTO streaming = service.getStreamingById(id);
        if (streaming != null){
            return ResponseEntity.ok(streaming);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A streaming com o ID: " + id + " nao existe nos nossos registros");
        }
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteStreamingByid(@PathVariable Long id) {
        if (service.getStreamingById(id) != null){
            service.deleteStreamingByid(id);
            return ResponseEntity.ok("A streaming com o ID: " + id + " foi deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A streaming com o ID: " + id + " nao existe nos nossos registros");
        }
    }
}
