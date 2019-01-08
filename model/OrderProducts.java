package com.ats.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name="order_products")
public class OrderProducts implements Serializable{
	
	@Id
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="orderno")
	private ShopOrder orderno;
	
	@Id
		//@ManyToOne(fetch= FetchType.EAGER)
		@JoinColumn(name="product_id")
	private int productId;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	//Some overriding
	@Override
  public int hashCode() {
      return Objects.hash(orderno, productId);
  }
	
	
	
	//Constructor
	public OrderProducts() {}
	
	//Getters
	public ShopOrder getOrderno() {return orderno;}
	public int getProductId() {return productId;}
	public int getQuantity() {return quantity;}

	//Setters
	public void setOrderno(ShopOrder orderno) {this.orderno = orderno;}
	public void setProductId(int productId) {this.productId = productId;}
	public void setQuantity(int quantity) {this.quantity = quantity;}

	
	
}//N P U
