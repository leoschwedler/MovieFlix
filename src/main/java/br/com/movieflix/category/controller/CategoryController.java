package br.com.movieflix.category.controller;

import br.com.movieflix.category.dto.CategoryDTO;
import br.com.movieflix.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO> >getAllCategories() {
        List<CategoryDTO> categories = service.getAllCategories();
        return ResponseEntity.ok(categories);
    }


    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO category) {
        CategoryDTO categoryDto = service.createCategory(category);
      return   ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }


    @GetMapping("search/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        CategoryDTO category = service.getCategoryById(id);
        if (category != null){
            return ResponseEntity.ok(category);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("A categoria com o ID: " + id + " nao existe nos nossos registros");
        }
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteCategoryByid(@PathVariable Long id) {
        if (service.getCategoryById(id) != null){
            service.deleteCategoryByid(id);
            return ResponseEntity.ok("A categoria com o ID: " + id + " foi deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("A categoria com o ID: " + id + " nao existe nos nossos registros");
        }
    }


}
