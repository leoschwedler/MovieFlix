package br.com.movieflix.user.repository;

import br.com.movieflix.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

     Optional<UserEntity> findUserByEmail(String email);
}
