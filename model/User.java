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
@Table(name="user")
public class User {
	
	@Id
	@Column(name="username", updatable=false, nullable=false)
	private String username;
	
	@Column(name="firstname", nullable=false)
	private String firstName;
	
	@Column(name="lastname", nullable=false)
	private String lastName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="orderno")
	private Set<Order> orders = new HashSet<Order>();
	
	//Default constructor
	public User() {}

	//Getters
	public String getUsername() {return username;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getPassword() {return password;}
	public Set<Order> getOrders() {return orders;}

	//Setters
	public void setUsername(String username) {this.username = username;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setPassword(String password) {this.password = password;}
	public void setOrders(Set<Order> orders) {this.orders = orders;}

}
