package com.shop.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ctid;
	private String name;
	
//	@OneToMany(mappedBy="cat")
// 	List<Products> prod;
 	
	public long getCtid() {
		return ctid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public List<Products> getProd() {
//		return prod;
//	}
//	public void addProduct(Products prod) {
//		
//		this.prod.add(prod);
//		
//		
//	}
	
 	
	
}
