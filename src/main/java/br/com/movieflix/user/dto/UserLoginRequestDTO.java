package br.com.movieflix.user.dto;

import lombok.Builder;

@Builder
public record UserLoginRequestDTO (String email, String password){
}
