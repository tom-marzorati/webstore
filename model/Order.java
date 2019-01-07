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
@Table(name="order")
public class Order {

	//Order number: PRIMARY KEY
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
	@SequenceGenerator(name="order_generator", sequenceName = "order_seq", allocationSize=1)
	@Column(name="order_no", updatable=false, nullable=false)
	private int orderno;
	
	//User performing order
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="username", nullable=false)
	private String userid;
	
	@Column(name="order_date", updatable=false, nullable=false)
	private String orderDate;
	
	@Column(name="total_cost", updatable=false, nullable=false)
	private Double totalCost;
	
	@Column(name="address", updatable=false, nullable=false)
	private String address;
	
	@OneToMany(mappedBy="order_no", cascade = CascadeType.ALL)
	private Set<OrderProducts> orderItems = new HashSet<OrderProducts>();
	
	//Default constructor
	public Order(){}
	
	//Getters
	public int getOrderno() {return orderno;}
	public String getUserid() {return userid;}
	public String getOrderDate() {return orderDate;}
	public Double getTotalCost() {return totalCost;}
	public String getAddress() {return address;}

	//Setters
	public void setOrderno(int orderno) {this.orderno = orderno;}
	public void setUserid(String userid) {this.userid = userid;}
	public void setOrderDate(String orderDate) {this.orderDate = orderDate;}
	public void setTotalCost(Double totalCost) {this.totalCost = totalCost;}
	public void setAddress(String address) {this.address = address;}
	
	
	
}//NON PLUS ULTRA
