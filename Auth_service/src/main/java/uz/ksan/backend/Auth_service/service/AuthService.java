package uz.ksan.backend.Auth_service.service;

import uz.ksan.backend.Auth_service.model.AuthEntity;

public interface AuthService {
    AuthEntity registerUser(AuthEntity authEntity);

    String verify(AuthEntity auth);
}
