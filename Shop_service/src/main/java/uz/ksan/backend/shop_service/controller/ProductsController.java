package uz.ksan.backend.shop_service.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ksan.backend.shop_service.repository.ProductInterface;
import uz.ksan.backend.shop_service.service.ProductsService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/shop/products/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductsController {
    final ProductsService productsService;

    @GetMapping("{shopName}")
    public List<ProductInterface> getProducts(@PathVariable String shopName) {
        return productsService.getAllByShopName(shopName);
    }
}
