package fr.faizamnasry.ecommerce.controller;

import fr.faizamnasry.ecommerce.models.SKUProfileRequest;
import fr.faizamnasry.ecommerce.models.SellerSKU;
import fr.faizamnasry.ecommerce.service.SellerSKUService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Controller for handling Seller SKU operations.
 * Provides endpoints for creating, retrieving, updating, and deleting SKUs associated with a seller's profile.
 */
@Slf4j
@RestController
@RequestMapping("/api/seller-skus")
@RequiredArgsConstructor
public class SellerSKUController {

    private final SellerSKUService sellerSKUService;

    /**Endpoint to create a new Seller SKU associated with a specific profile.*/
    @PostMapping("/create/")
    public ResponseEntity<SellerSKU> createSellerSKU(@RequestBody SKUProfileRequest request) {
        SellerSKU createdSKU = sellerSKUService.createSKUWithProfile(request);
        return ResponseEntity.ok(createdSKU);
    }

    /**Endpoint to retrieve all SKUs associated with a specific profile.*/
    @GetMapping("/{profileId}")
    public ResponseEntity<Set<SellerSKU>> getSellerSKUsByProfile(@PathVariable String profileId) {
        return ResponseEntity.ok(sellerSKUService.getSellerSKUsByProfile(profileId));
    }

    /**Endpoint to update an existing Seller SKU.*/
    @PutMapping("/{skuId}")
    public ResponseEntity<SellerSKU> updateSellerSKU(
            @PathVariable String skuId,
            @RequestBody SellerSKU updatedSKU) {
        return ResponseEntity.ok(sellerSKUService.updateSellerSKU(skuId, updatedSKU));
    }

    /**Endpoint to delete a Seller SKU from a specific profile.*/
    @DeleteMapping("/{skuId}/{profileId}")
    public ResponseEntity<Void> removeSellerSKU(
            @PathVariable String skuId,
            @PathVariable String profileId) {
        sellerSKUService.removeSellerSKU(skuId, profileId);
        return ResponseEntity.noContent().build();
    }
}
