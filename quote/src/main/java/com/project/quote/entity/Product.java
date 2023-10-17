package com.project.quote.entity;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "internal_name")
    private String internalName;

    @Column(name = "details")
    private String details;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInternalName() {
		return internalName;
	}

	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getMaxProductsPerLocation() {
		return maxProductsPerLocation;
	}

	public void setMaxProductsPerLocation(Integer maxProductsPerLocation) {
		this.maxProductsPerLocation = maxProductsPerLocation;
	}

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

	@Column(name = "max_products_per_location")
    private Integer maxProductsPerLocation;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)

    private List<Feature> features;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

