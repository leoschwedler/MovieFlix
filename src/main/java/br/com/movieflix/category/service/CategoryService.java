package br.com.movieflix.category.service;

import br.com.movieflix.category.dto.CategoryDTO;
import br.com.movieflix.category.mapper.CategoryMapper;
import br.com.movieflix.category.model.CategoryEntity;
import br.com.movieflix.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {



    private final CategoryRepository repository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository repository, CategoryMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categories = repository.findAll();
        return categories.stream()
                .map(categoryMapper::map)
                .collect(Collectors.toList());
    }

    public CategoryDTO createCategory(CategoryDTO categorydto) {
      CategoryEntity category = categoryMapper.map(categorydto);
      category = repository.save(category);
      return categoryMapper.map(category);
    }

    public CategoryDTO getCategoryById(Long id) {
        Optional<CategoryEntity> category = repository.findById(id);
        return category.map(categoryMapper::map).orElse(null);
    }

    public void deleteCategoryByid(Long id) {
        repository.deleteById(id);
    }



}
