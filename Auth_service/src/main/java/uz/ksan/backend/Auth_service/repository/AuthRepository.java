package uz.ksan.backend.Auth_service.repository;

import uz.ksan.backend.Auth_service.model.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

}
