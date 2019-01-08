package com.ats.model; /**/
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
//@Table(name="user")
public class ShopUser {
	
	@Id
	@Column(name="username", updatable=false, nullable=false)
	private String username;
	
	@Column(name="firstname", nullable=false)
	private String firstName;
	
	@Column(name="lastname", nullable=false)
	private String lastName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="userid")
	private Set<ShopOrder> orders = new HashSet<ShopOrder>();
	
	//Default constructor
	public ShopUser() {}

	//Getters
	public String getUsername() {return username;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getPassword() {return password;}
	public Set<ShopOrder> getOrders() {return orders;}

	//Setters
	public void setUsername(String username) {this.username = username;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setPassword(String password) {this.password = password;}
	public void setOrders(Set<ShopOrder> o1) {this.orders = o1;}

}
