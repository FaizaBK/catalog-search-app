package fr.faizamnasry.ecommerce.models;

import lombok.Data;

/**
 * Request class for handling SKU and Profile association operations.
 * This class encapsulates the data for a SellerSKU and its associated Profile.
 */
@Data
public class SKUProfileRequest {
    private SellerSKU sku;
    private Profile profile;
}