package uz.ksan.backend.shop_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.ksan.backend.shop_service.model.ShopEntity;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<ShopEntity, Long> {

    Optional<ShopEntity> findByShopName(String shopName);
    List<ShopEntity> findAll();

    @Query("SELECT param FROM ShopEntity param WHERE " +
            "(:shopDistrict IS NULL OR param.shopDistrict = :shopDistrict) AND " +
            "(:shopCity IS NULL OR LOWER(param.shopCity) = LOWER(:shopCity)) AND " +
            "(:shopRating IS NULL OR param.shopRating >= :shopRating)")
    List<ShopEntity> findShopsByFilter(@Param("shopDistrict") Integer shopDistrict,
                                       @Param("shopCity") String shopCity,
                                       @Param("shopRating") Integer shopRating);

}
