package br.com.movieflix.user.dto;

import lombok.Builder;

@Builder
public record UserRegisterRequestDTO(String name, String email, String password) {
}
