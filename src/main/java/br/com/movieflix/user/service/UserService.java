package br.com.movieflix.user.service;

import br.com.movieflix.infra.security.TokenService;
import br.com.movieflix.user.dto.UserLoginRequestDTO;
import br.com.movieflix.user.dto.UserLoginResponseDTO;
import br.com.movieflix.user.dto.UserRegisterRequestDTO;
import br.com.movieflix.user.dto.UserRegisterResponseDTO;
import br.com.movieflix.user.mapper.UserMapper;
import br.com.movieflix.user.model.UserEntity;
import br.com.movieflix.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UserLoginResponseDTO login(UserLoginRequestDTO request){
        UsernamePasswordAuthenticationToken userAndPassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPassword);
        UserEntity user = (UserEntity) authenticate.getPrincipal();
        String token = tokenService.generateToken(user);
        return new UserLoginResponseDTO(token);
    }

    public UserRegisterResponseDTO register(UserRegisterRequestDTO request){
        String password = request.password();
        UserEntity user = UserMapper.map(request);
        user.setPassword(passwordEncoder.encode(password));
        user = repository.save(user);
        return UserMapper.map(user);
    }


}
