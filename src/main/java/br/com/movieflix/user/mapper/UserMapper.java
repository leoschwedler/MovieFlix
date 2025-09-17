package br.com.movieflix.user.mapper;

import br.com.movieflix.user.dto.UserRequestDTO;
import br.com.movieflix.user.dto.UserResponseDTO;
import br.com.movieflix.user.model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static UserEntity map(UserRequestDTO request){
        return UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponseDTO map(UserEntity userEntity){
        return UserResponseDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .build();
    }
}
