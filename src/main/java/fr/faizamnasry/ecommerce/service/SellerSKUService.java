package fr.faizamnasry.ecommerce.service;


import fr.faizamnasry.ecommerce.exception.ProfileNotFoundException;
import fr.faizamnasry.ecommerce.exception.SellerSKUNotFoundException;
import fr.faizamnasry.ecommerce.models.Profile;
import fr.faizamnasry.ecommerce.models.SKUProfileRequest;
import fr.faizamnasry.ecommerce.models.SellerSKU;
import fr.faizamnasry.ecommerce.repository.ProfileRepository;
import fr.faizamnasry.ecommerce.repository.SellerSKURepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Service class for managing Seller SKU operations.
 * This class provides methods to create, get, update, and delete Seller SKU records,
 * as well as associate them with profiles.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SellerSKUService {

    @Autowired
    private final SellerSKURepository sellerSKURepository;

    @Autowired
    private final ProfileRepository profileRepository;

    /**Creates a SellerSKU associated with a Profile.*/
    @Transactional
    public SellerSKU createSKUWithProfile(SKUProfileRequest request) {
        // Find existing profile or create a new one if it doesn't exist
        Profile profile = profileRepository.findByCompanyName(request.getProfile().getCompanyName())
                .orElseGet(() -> {
                    Profile newProfile = request.getProfile();
                    return profileRepository.save(newProfile);
                });

        SellerSKU sku = request.getSku();
        sku.setProfile(profile);  // Associate SKU with Profile
        profile.getSkus().add(sku);  // Add SKU to Profile’s SKU list

        sellerSKURepository.save(sku);  // Save SKU
        profileRepository.save(profile);  // Update Profile

        return sku;
    }

    /**
     * Get all Seller SKUs associated with a specific Profile.
     *
     * @param profileId the ID of the Profile
     * @return a Set of SellerSKUs associated with the Profile
     * @throws ProfileNotFoundException if the Profile with the given ID does not exist
     */
    public Set<SellerSKU> getSellerSKUsByProfile(String profileId) {
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(profileId));

        return profile.getSkus();
    }

    /**Updates an existing SellerSKU with new values.*/
    public SellerSKU updateSellerSKU(String skuId, SellerSKU updatedSKU) {
        SellerSKU existingSKU = sellerSKURepository.findById(skuId)
                .orElseThrow(() -> new SellerSKUNotFoundException(skuId));

        existingSKU.setName(updatedSKU.getName());
        existingSKU.setDescription(updatedSKU.getDescription());
        existingSKU.setImageUrls(updatedSKU.getImageUrls());
        existingSKU.setFallIntoProfiles(updatedSKU.getFallIntoProfiles());

        return sellerSKURepository.save(existingSKU);
    }

    /**Removes a SellerSKU from a Profile and deletes it from the repository.*/
    public void removeSellerSKU(String skuId, String profileId) {
        SellerSKU sku = sellerSKURepository.findById(skuId)
                .orElseThrow(() -> new SellerSKUNotFoundException(skuId));

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(profileId));

        profile.getSkus().remove(sku);  // Remove SKU from Profile’s SKU list
        profileRepository.save(profile);  // Update Profile
        sellerSKURepository.delete(sku);  // Delete SKU from the repository
    }
}