package com.trekappAPI.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;
	private String name;
	private String email;
	private String password;
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
        return Objects.hash(cid,name, email, password);
}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(!(obj instanceof Customer)) return false;
		Customer customer = (Customer) obj;
		return Objects.equals(email, customer.email)&&
				Objects.equals(password, customer.password);
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", email=" + email + ", password=" + password
				 + "]";
	}

	
	
	
	
	
	
}
