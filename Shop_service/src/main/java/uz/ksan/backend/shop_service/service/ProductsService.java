package uz.ksan.backend.shop_service.service;

import uz.ksan.backend.shop_service.repository.ProductInterface;

import java.util.List;

public interface ProductsService {
    List<ProductInterface> getAllByShopName(String shopName);
}
