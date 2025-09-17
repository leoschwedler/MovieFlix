package br.com.movieflix.user.service;

import br.com.movieflix.user.dto.UserRequestDTO;
import br.com.movieflix.user.dto.UserResponseDTO;
import br.com.movieflix.user.mapper.UserMapper;
import br.com.movieflix.user.model.UserEntity;
import br.com.movieflix.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserResponseDTO register(UserRequestDTO request){
        UserEntity user = UserMapper.map(request);
        user = repository.save(user);
        return UserMapper.map(user);
    }
}
