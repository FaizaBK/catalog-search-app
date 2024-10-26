package fr.faizamnasry.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


/**
 * Represents an embedded bean entity with basic attributes for storing identification and repository information.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmbeddedBean {
    @Id  //Unique identifier for the embedded bean.*/
    private String id;
    private String name;
    private String repositoryName;

    // Getters and Setters
}