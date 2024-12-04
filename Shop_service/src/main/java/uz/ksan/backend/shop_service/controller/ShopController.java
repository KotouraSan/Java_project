package uz.ksan.backend.shop_service.controller;

import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import uz.ksan.backend.shop_service.model.ShopEntity;
import uz.ksan.backend.shop_service.repository.ShopRepository;
import uz.ksan.backend.shop_service.service.ShopService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Transactional
@RequestMapping("/api/v1/shop/")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopController {

    ShopService shopService;
    ShopRepository shopRepository;

    @PostMapping
    public String saveShop(@RequestBody ShopEntity shopEntity) {
        shopService.saveShop(shopEntity);
        return "Shop saved";
    }

    @DeleteMapping("{shopName}")
    public String deleteShop(@PathVariable String shopName) {
        shopService.deleteShopByShopName(shopName);
        return "Shop deleted";
    }

    @PutMapping("{shopName}")
    public String updateShop(@PathVariable String shopName,@RequestBody ShopEntity shopEntity) {
        shopService.updateShop(shopEntity, shopName);
        return "Shop updated";
    }

    @GetMapping
    public List<ShopEntity> getAllShops() {
        return shopRepository.findAll();
    }

    @GetMapping("f/")
    public List<ShopEntity> findShopsByFilter(@RequestParam(required = false) Integer shopDistrict,
                                              @RequestParam(required = false) String shopCity,
                                              @RequestParam(required = false) Integer shopRating) {
        return shopRepository.findShopsByFilter(shopDistrict, shopCity, shopRating);
    }
}
