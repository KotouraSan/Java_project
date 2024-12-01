package uz.ksan.backend.shop_service.service;

import uz.ksan.backend.shop_service.model.ShopEntity;

import java.util.List;

public interface ShopService {
    void saveShop(ShopEntity shop);
    void deleteShopByShopName(String shopName);
    ShopEntity updateShop(ShopEntity shop, String shopName);
}
