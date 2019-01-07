package com.ats.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;


@Entity
public class Order {

	//Order number: PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
	@SequenceGenerator(name="order_generator", sequenceName = "order_seq", allocationSize=1)
	@Column(name="orderno", updatable=false, nullable=false)
	public int orderno;
	
	//User performing order
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username", nullable=false)
	private String userid;
	
	@Column(name="order_date", updatable=false, nullable=false)
	private String orderDate;
	
	@Column(name="total_cost", updatable=false, nullable=false)
	private String totalCost;
	
	@Column(name="address", updatable=false, nullable=false)
	private String address;
	
	//WORK IN PROGRESS: adding reference to the items in the cart

	//Default constructor
	public Order(){}
	
	//Getters
	public int getOrderno() {return orderno;}
	public String getUserid() {return userid;}
	public String getOrderDate() {return orderDate;}
	public String getTotalCost() {return totalCost;}
	public String getAddress() {return address;}
	public String getCart() {return cart;}

	//Setters
	public void setOrderno(int orderno) {this.orderno = orderno;}
	public void setUserid(String userid) {this.userid = userid;}
	public void setOrderDate(String orderDate) {this.orderDate = orderDate;}
	public void setTotalCost(String totalCost) {this.totalCost = totalCost;}
	public void setAddress(String address) {this.address = address;}
	public void setCart(String cart) {this.cart = cart;}
	
	
	
}//NON PLUS ULTRA
