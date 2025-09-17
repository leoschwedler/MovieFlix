package br.com.movieflix.user.controller;

import br.com.movieflix.user.dto.UserLoginRequestDTO;
import br.com.movieflix.user.dto.UserLoginResponseDTO;
import br.com.movieflix.user.dto.UserRegisterRequestDTO;
import br.com.movieflix.user.dto.UserRegisterResponseDTO;
import br.com.movieflix.user.mapper.UserMapper;
import br.com.movieflix.user.model.UserEntity;
import br.com.movieflix.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

   @PostMapping("/register")
   public ResponseEntity<UserRegisterResponseDTO> register(@RequestBody UserRegisterRequestDTO request){
       UserRegisterResponseDTO response = service.register(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

   @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginRequestDTO request){
        UserLoginResponseDTO response = service.login(request);
     return  ResponseEntity.ok(response);
    }

}
