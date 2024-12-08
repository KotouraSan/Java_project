package uz.ksan.backend.Auth_service.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ksan.backend.Auth_service.model.AuthEntity;
import uz.ksan.backend.Auth_service.repository.AuthRepository;
import uz.ksan.backend.Auth_service.service.AuthService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/")
@FieldDefaults(makeFinal = true)
@Transactional
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    public AuthEntity register(@RequestBody AuthEntity auth) {
        return authService.registerUser(auth);
    }

    @PostMapping("login")
    public String login(@RequestBody AuthEntity auth) {
        return authService.verify(auth);
    }
}
