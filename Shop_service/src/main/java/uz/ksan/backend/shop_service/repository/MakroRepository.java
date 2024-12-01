package uz.ksan.backend.shop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uz.ksan.backend.shop_service.model.MakroEntity;

public interface MakroRepository extends JpaRepository<MakroEntity, Long> {
}
