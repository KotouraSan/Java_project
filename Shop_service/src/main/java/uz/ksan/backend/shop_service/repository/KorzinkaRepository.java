package uz.ksan.backend.shop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.ksan.backend.shop_service.model.KorzinkaEntity;

public interface KorzinkaRepository extends JpaRepository<KorzinkaEntity, Long> {
}
