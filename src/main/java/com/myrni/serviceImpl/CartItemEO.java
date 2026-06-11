package com.myrni.serviceImpl;

import com.myrni.entity.FoodEO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "cart_items")
@Data
public class CartItemEO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartItemId;

	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEO cart;

	@ManyToOne
	@JoinColumn(name = "food_id")
	private FoodEO food;

	private Integer quantity;

	private Double itemTotal;

}
