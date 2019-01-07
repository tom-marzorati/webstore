package com.ats.model; /**/
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
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
	
	//Default constructor
	public User() {}

	//Getters
	public String getUsername() {return username;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getPassword() {return password;}

	//Setters
	public void setUsername(String username) {this.username = username;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setPassword(String password) {this.password = password;}

}
