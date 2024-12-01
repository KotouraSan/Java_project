package uz.ksan.backend.shop_service.repository;

public interface ProductInterface {
    String getProductName();
    String getProductDescription();
    Double getProductPrice();
    Integer getStock();
}