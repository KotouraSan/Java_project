package uz.ksan.backend.Auth_service.service;

import uz.ksan.backend.Auth_service.model.AuthEntity;

import java.util.List;

public interface AuthService {
    AuthEntity registerUser(AuthEntity authEntity);

    String verify(AuthEntity auth);

    List<AuthEntity> getAllUsers();
}
