package uz.ksan.backend.Auth_service.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.Auth_service.model.AuthEntity;
import uz.ksan.backend.Auth_service.repository.AuthRepository;
import uz.ksan.backend.Auth_service.service.AuthService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth/")
@FieldDefaults(makeFinal = true)
@Transactional
public class AuthController {

    private final AuthService authService;

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("register")
    public AuthEntity register(@RequestBody AuthEntity auth) {
        return authService.registerUser(auth);
    }

    @PostMapping("login")
    public String login(@RequestBody AuthEntity auth) {
        return authService.verify(auth);
    }

    @GetMapping
    public List<AuthEntity> getAll() {
        return authService.getAllUsers();
    }
}
