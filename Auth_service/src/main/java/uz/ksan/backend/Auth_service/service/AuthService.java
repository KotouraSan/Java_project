package uz.ksan.backend.Auth_service.service;

import uz.ksan.backend.Auth_service.model.AuthEntity;

public interface AuthService {
    AuthEntity saveUser(AuthEntity authEntity);
}
