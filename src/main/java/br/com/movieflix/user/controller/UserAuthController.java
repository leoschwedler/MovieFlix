package br.com.movieflix.user.controller;

import br.com.movieflix.user.dto.UserRequestDTO;
import br.com.movieflix.user.dto.UserResponseDTO;
import br.com.movieflix.user.model.UserEntity;
import br.com.movieflix.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthController {

    private final UserService service;

   @PostMapping("/register")
   public ResponseEntity<UserResponseDTO> register(UserRequestDTO request){
       UserResponseDTO response = service.register(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

}
