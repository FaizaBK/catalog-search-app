package fr.faizamnasry.ecommerce.exception;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(String profileId) {
        super("Profile with ID " + profileId + " not found.");
    }
}