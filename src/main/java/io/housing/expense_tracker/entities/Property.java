// file path to this entity class
package io.housing.expense_tracker.entities;

import java.math.BigDecimal;

// Aside: javax.persistence package is for JPA 2.x / Spring Boot 2.x ...
// ... jakarta.persistence package is for JPA 3.x / Spring Boot 3.x
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// '@Table' std annotation from JPA
import jakarta.persistence.Table;

// lombok annotations to reduce boilerplate code for getter methods, setter methods, and equals/hashCode methods
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* Could use @Data annotation since it includes both @Getter & @Setter ...
** but it also has other excess Lombok annotaitons such as @ToString, @EqualsAndhashCode, and @RequiredArgsConstructor ...
** ... @Data is often discouraged for Entity classes as it defaults 'equals()' and hashCode() implementations which can cause issues w/ lazy loading & identity maps */
// @Getter
// @Setter
// lombok annotations to generate a parameterized constructor w/ all args ...
// ... & constructor w/ no args for JPA entity class
// Side Note: w/o fields in class would cause
// @AllArgsConstructor
// @NoArgsConstructor
// '@Entity' annotation from Java Persistence API (JPA) to mark this class as a JPA entity to be mapped to a DB table
@Entity
// '@Table' annotation to customize table name mapping for this entity otw Hibernate would would give it a default name of 'Property' for the DB table
// @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "properties")
public class Property {
    
    // @Column(name = "property_id")
    // '@Id' annotation indicates this field as the PRIMARY KEY for the DB table ...
    // ... '@Entity' requires a PRIMARY KEY field for the JPA entity class
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer propertyId;
    private String propertyName;
    private String propertyAddress;
    private String propertyType;
    private Integer propertySize;
    private String propertyDescription;
    private BigDecimal propertyPrice;
    private Float propertyRating;

    // intialize getter methods for each individual field members of 'Property' class
    public Integer getPropertyId(){
        return(propertyId);
    }

    public String getPropertyName(){
        return(propertyName);
    }

    public String getPropertyAddress(){
        return(propertyAddress);
    }

    public String getPropertyType(){
        return(propertyType);
    }

    public Integer getPropertySize(){
        return(propertySize);
    }

    public String getPropertyDescription(){
        return(propertyDescription);
    }

    public BigDecimal getPropertyPrice(){
        return(propertyPrice);
    }

    public Float getPropertyRating(){
        return(propertyRating);
    }

    // setter methods for each separate 'Property' class fields
    public void setPropertyId(Integer propertyId){
        // initialize the class field 'propertyId' w/ user input value of 'propertyId' param
        this.propertyId = propertyId;
    }

    public void setPropertyName(String propertyName){
        this.propertyName = propertyName;
    }

    public void setPropertyAddress(String propertyAddress){
        this.propertyAddress = propertyAddress;
    }

    public void setPropertyType(String propertyType){
        this.propertyType = propertyType;
    }

    public void setPropertySize(Integer propertySize){
        this.propertySize = propertySize;
    }

    public void setPropertyDescription(String propertyDescription){
        this.propertyDescription = propertyDescription;
    }

    public void setPropertyPrice(BigDecimal propertyPrice){
        this.propertyPrice = propertyPrice;
    }
    
    public void setPropertyRating(Float propertyRating){
        this.propertyRating = propertyRating;
    }

}
