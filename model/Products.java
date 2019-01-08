package com.ats.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name="products")
public class Products {
	
	
		@Id
		@Column(name="product_id", updatable=false, nullable=false)
	public int productId;
	
		@Column(name="product_name")
	private String productName;
	
		@Column(name="category")
	private String category;
	
		@Column(name="quantity_left")
	private int quantity;
	
		@Column(name="price")
	private double price;
	
	//Constructor
	public Products() {}
	
	//Getters
	public int getProductId() {return productId;}
	public String getProductName() {return productName;}
	public String getCategory() {return category;}
	public int getQuantity() {return quantity;}
	public double getPrice() {return price;}
	//	public Set<OrderProducts> getOrderItems() {return orderItems;}

	//Setters
	public void setProductId(int productId) {this.productId = productId;}
	public void setProductName(String productName) {this.productName = productName;}
	public void setCategory(String category) {this.category = category;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	public void setPrice(double price) {this.price = price;}
	//	public void setOrderItems(Set<OrderProducts> orderItems) {this.orderItems = orderItems;}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", quantity=" + quantity + ", price=" + price +  "]";
	}
	
	
	
	
}//N P U
