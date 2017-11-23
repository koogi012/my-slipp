package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long   id; 
	
	@Column(nullable=false, length=20, unique=true)
	private String userId;
	private String password;
	private String name;
	private String email;

	public Long getId() {
		return id;
	}
	
	public boolean matchId( Long Id ) {
		
		if ( Id == null ) return false;
		
		if (!this.id.equals(Id)) return false;
		
		return true;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return this.userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public boolean matchPassword( String Password ) {
		if ( Password == null ) return false;
		
		if (!this.password.equals(Password)) return false;
		
		return true;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void update(User newUser) {
		
		this.password = newUser.password;
		this.name = newUser.name;
		this.email = newUser.email;

	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}



	
	

}
