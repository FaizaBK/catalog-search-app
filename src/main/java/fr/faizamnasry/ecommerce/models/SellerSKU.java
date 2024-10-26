package fr.faizamnasry.ecommerce.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Seller's Stock Keeping Unit (SKU) in the e-commerce system.
 * A Seller SKU includes information such as name, description, associated images, and linked profiles.
 */
@Data
@NoArgsConstructor
@Document(collection = "sellerSKUs")
public class SellerSKU {
    @Id
    private String id;
    private String name;
    private String description;
    private Set<String> imageUrls = new HashSet<>();


    /**
     * A set of profiles where this SKU is applicable, stored as a MongoDB reference to the EmbeddedBean class.
     */
    @DBRef
    private Set<EmbeddedBean> fallIntoProfiles = new HashSet<>();

    /**
     * Profile associated with this SKU, represented as a MongoDB reference.
     */
    @DBRef
    private Profile profile;
}