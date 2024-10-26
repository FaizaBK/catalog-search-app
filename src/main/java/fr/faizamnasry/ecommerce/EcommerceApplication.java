package fr.faizamnasry.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Main application class for the eCommerce application.
 * Initializes and runs the Spring Boot application.
 */
@SpringBootApplication
@EntityScan(basePackages = {"models"}) /// Scans the specified package for JPA entities

public class EcommerceApplication {

    /**Main entry point of the application.*/
    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

}
