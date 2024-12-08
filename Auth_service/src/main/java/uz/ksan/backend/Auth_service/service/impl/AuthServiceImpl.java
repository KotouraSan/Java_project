package uz.ksan.backend.Auth_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uz.ksan.backend.Auth_service.model.AuthEntity;
import uz.ksan.backend.Auth_service.repository.AuthRepository;
import uz.ksan.backend.Auth_service.service.AuthService;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class AuthServiceImpl implements AuthService {

    final AuthRepository authRepository;
    final AuthenticationManager authenticationManager;


    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

    @Override
    public AuthEntity registerUser(AuthEntity authEntity) {
        authEntity.setAuthPassword(bCryptPasswordEncoder.encode(authEntity.getAuthPassword()));
        return authRepository.save(authEntity);
    }

    @Override
    public String verify(AuthEntity auth) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getAuthEmail(), auth.getAuthPassword()));
        if(authentication.isAuthenticated()){
            return "success";
        }
        return "fail";
    }
}
