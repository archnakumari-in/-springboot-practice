package com.myrni.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurants")
@Data
public class RestaurantEO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long restaurantId;

	@Column(nullable = false)
	private String restaurantName;

	private String ownerName;

	private String mobileNo;

	private String email;

	private String address;

	private String city;

	private Double rating;

	private Boolean active;
	
	
	@OneToMany(mappedBy = "restaurant",
	        cascade = CascadeType.ALL,
	        fetch = FetchType.LAZY)
	private List<FoodEO> foodItems;
	

}
