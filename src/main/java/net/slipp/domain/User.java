package net.slipp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends AbstractEntity {
	
	@Column(nullable=false, length=20, unique=true)
	@JsonProperty
	private String userId;
	@JsonIgnore
	private String password;
	@JsonProperty
	private String name;
	@JsonProperty
	private String email;

	public boolean matchId( Long newId ) {
		
		if ( newId == null ) return false;
		
		return newId.equals(getId());
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
		return "User [" + super.toString() + ", userId=" + userId + ", password=" + password + ", name=" + name + ", email=" + email + "]";
	}
}
