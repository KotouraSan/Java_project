package uz.ksan.backend.Auth_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.ksan.backend.Auth_service.model.AuthEntity;

public interface UserDetailsRepository extends JpaRepository<AuthEntity, Long> {
}
