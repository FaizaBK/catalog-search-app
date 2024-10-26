package fr.faizamnasry.ecommerce.repository;


import fr.faizamnasry.ecommerce.models.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Repository interface for managing {@link Profile} entities in MongoDB.
 * This interface extends the  MongoRepository interface,
 * providing basic CRUD operations and custom query methods for the Profile entity.
 */
@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

    /**Finds a Profile by its company name.*/
    Optional<Profile> findByCompanyName(String companyName);
}