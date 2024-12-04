package uz.ksan.backend.Auth_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
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

    @Override
    public AuthEntity saveUser(AuthEntity authEntity) {
        return authRepository.save(authEntity);
    }
}
