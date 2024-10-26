package fr.faizamnasry.ecommerce.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a seller's profile in the e-commerce system, containing company details and a collection of Seller SKUs.
 */
@Data
@NoArgsConstructor
@Document(collection = "profiles")
public class Profile {
    @Id
    private String id;
    private String companyName;
    private String description;


    /**
     * A set of Seller SKU entities associated with this profile.
     * This relationship is managed through a DB reference in MongoDB.
     */
    @DBRef
    private Set<SellerSKU> skus = new HashSet<>();
}
