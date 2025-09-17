package br.com.movieflix.user.dto;

import lombok.Builder;

@Builder
public record UserRegisterResponseDTO(Long id, String name, String email) {
}
