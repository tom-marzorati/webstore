package com.ats.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_products")
public class OrderProducts {
	
	@Id
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="order_no")
	private Order order;
	
	@Id
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="product_id")
	private Products items;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	//Constructor
	public OrderProducts() {}
	
	//Getters
	public Order getOrder() {return order;}
	public Products getItems() {return items;}
	public int getQuantity() {return quantity;}

	//Setters
	public void setOrder(Order order) {this.order = order;}
	public void setItems(Products items) {this.items = items;}
	public void setQuantity(int quantity) {this.quantity = quantity;}

	
	
}//N P U
