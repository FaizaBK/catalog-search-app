package fr.faizamnasry.ecommerce.repository;


import fr.faizamnasry.ecommerce.models.SellerSKU;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository interface for managing  SellerSKU entities in MongoDB.
 * This interface extends the  MongoRepository interface,
 * providing basic CRUD operations for the SellerSKU entity.
 */
@Repository
public interface SellerSKURepository extends MongoRepository<SellerSKU, String> {
}