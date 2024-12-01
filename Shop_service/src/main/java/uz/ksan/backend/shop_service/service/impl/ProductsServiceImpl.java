package uz.ksan.backend.shop_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import uz.ksan.backend.shop_service.exceptions.NotFoundException;
import uz.ksan.backend.shop_service.repository.GalmartRepository;
import uz.ksan.backend.shop_service.repository.KorzinkaRepository;
import uz.ksan.backend.shop_service.repository.MakroRepository;
import uz.ksan.backend.shop_service.repository.ProductInterface;
import uz.ksan.backend.shop_service.service.ProductsService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Primary
public class ProductsServiceImpl implements ProductsService {

    final KorzinkaRepository korzinkaRepository;
    final GalmartRepository galmartRepository;
    final MakroRepository makroRepository;

    @Override
    public List<ProductInterface> getAllByShopName(String shopName) {
        if (shopName.trim().equalsIgnoreCase("korzinka")) {
            return new ArrayList<>(korzinkaRepository.findAll());
        } else if (shopName.trim().equalsIgnoreCase("galmart")) {
            return new ArrayList<>(galmartRepository.findAll());
        } else if (shopName.trim().equalsIgnoreCase("makro")) {
            return new ArrayList<>(makroRepository.findAll());
        } else {
            throw new NotFoundException("Shop name is empty or not available");
        }
    }
}
