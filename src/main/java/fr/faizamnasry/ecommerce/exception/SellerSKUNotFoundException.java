package fr.faizamnasry.ecommerce.exception;

public class SellerSKUNotFoundException extends RuntimeException {
    public SellerSKUNotFoundException(String skuId) {
        super("Seller SKU with ID " + skuId + " not found.");
    }
}