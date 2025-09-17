package br.com.movieflix.user.mapper;

import br.com.movieflix.user.dto.UserLoginRequestDTO;
import br.com.movieflix.user.dto.UserLoginResponseDTO;
import br.com.movieflix.user.dto.UserRegisterRequestDTO;
import br.com.movieflix.user.dto.UserRegisterResponseDTO;
import br.com.movieflix.user.model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static UserEntity map(UserRegisterRequestDTO request){
        return UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserRegisterResponseDTO map(UserEntity userEntity){
        return UserRegisterResponseDTO.builder()
                .id(userEntity.getId())
                .email(userEntity.getEmail())
                .name(userEntity.getName())
                .build();
    }

    public static UserEntity map(UserLoginRequestDTO request){
        return UserEntity.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }


}
