package br.com.movieflix.streaming.repository;

import br.com.movieflix.streaming.model.StreamingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingEntity,Long> {
}
