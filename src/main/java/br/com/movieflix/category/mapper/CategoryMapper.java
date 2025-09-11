package br.com.movieflix.category.mapper;

import br.com.movieflix.category.dto.CategoryDTO;
import br.com.movieflix.category.model.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {


    public CategoryEntity map(CategoryDTO categorydto){
        CategoryEntity category = new CategoryEntity();
        category.setId(categorydto.getId());
        category.setName(categorydto.getName());
        return category;
    }

    public CategoryDTO map(CategoryEntity categoryentity){
        CategoryDTO category = new CategoryDTO();
        category.setId(categoryentity.getId());
        category.setName(categoryentity.getName());
        return category;
    }
}
