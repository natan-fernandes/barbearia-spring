package com.natan.barbearia.resources;

import com.natan.barbearia.dtos.AuthRequestDto;
import com.natan.barbearia.dtos.AuthResponseDto;
import com.natan.barbearia.dtos.CadastroUserDto;
import com.natan.barbearia.models.User;
import com.natan.barbearia.services.AuthService;
import com.natan.barbearia.utils.JwtTokenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api/auth")
public class AuthResource {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthService authService;

    public AuthResource(AuthenticationManager authenticationManager,
                        JwtTokenUtil jwtTokenUtil,
                        AuthService authService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDto authRequest) {
        try {
            UsernamePasswordAuthenticationToken userPasswordAuthToken
                    = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getSenha());

            Authentication auth = authenticationManager.authenticate(userPasswordAuthToken);
            User user = (User)auth.getPrincipal();

            String accessToken = jwtTokenUtil.generateAcessToken(user);
            AuthResponseDto response = new AuthResponseDto(user.getEmail(), accessToken);
            return ResponseEntity.ok(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/registrar")
    public User registrar(@RequestBody CadastroUserDto cadastroUserDto) {
        return authService.registrar(cadastroUserDto);
    }
}
