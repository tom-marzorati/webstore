package com.ats.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
//@Table(name="order")
public class ShopOrder {

	//Order number: PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
	@SequenceGenerator(name="order_generator", sequenceName = "order_seq", allocationSize=1)
	@Column(name="order_no", updatable=false, nullable=false)
	private int orderno;
	
	//User performing order
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username", nullable=false)
	private ShopUser userid;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="total_cost")
	private Double totalCost;
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="orderno", cascade = CascadeType.ALL)
	private Set<OrderProducts> orderItems = new HashSet<OrderProducts>();
/*	*/
	//Default constructor
	public ShopOrder(){}
	
	//Getters
	public int getOrderno() {return orderno;}
	public ShopUser getUserid() {return userid;}
	public String getOrderDate() {return orderDate;}
	public Double getTotalCost() {return totalCost;}
	public String getAddress() {return address;}
	//public Set<OrderProducts> getOrderItems() {return orderItems;}

	//Setters
	public void setOrderno(int orderno) {this.orderno = orderno;}
	public void setUserid(ShopUser userid) {this.userid = userid;}
	public void setOrderDate(String orderDate) {this.orderDate = orderDate;}
	public void setTotalCost(Double totalCost) {this.totalCost = totalCost;}
	public void setAddress(String address) {this.address = address;}
//	public void setOrderItems(Set<OrderProducts> orderItems) {this.orderItems = orderItems;}
	
	
	
}//NON PLUS ULTRA
