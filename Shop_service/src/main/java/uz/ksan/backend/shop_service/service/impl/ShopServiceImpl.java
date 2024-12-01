package uz.ksan.backend.shop_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.shop_service.model.ShopEntity;
import uz.ksan.backend.shop_service.repository.ShopRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class ShopServiceImpl implements uz.ksan.backend.shop_service.service.ShopService {

    private final ShopRepository shopRepository;

    @Override
    public void saveShop(ShopEntity shop) {
        shopRepository.save(shop);
    }

    @Override
    public void deleteShopByShopName(String shopName) {
        var shop = shopRepository.findByShopName(shopName)
                .orElseThrow(() -> new NoSuchElementException("No shop found with name: " + shopName));
        shopRepository.delete(shop);
    }

    @Override
    public ShopEntity updateShop(ShopEntity shop, String shopName) {
        shopRepository.findByShopName(shopName.toLowerCase())
                .orElseThrow(() -> new NoSuchElementException("No shop found with name: " + shopName));
        deleteShopByShopName(shopName);
        return shopRepository.save(shop);
    }
}

