package br.com.movieflix.movie.dto;

import br.com.movieflix.category.model.CategoryEntity;
import br.com.movieflix.streaming.model.StreamingEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {


    private Long id;

    private String name;

    private String description;

    private LocalDate releaseDate;

    private double rating;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<CategoryEntity> categories;

    private List<StreamingEntity> streamings;
}
