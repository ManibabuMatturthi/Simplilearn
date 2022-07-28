package com.shop.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Products;
import com.shop.entity.User;
import com.shop.repo.ProductsRepo;
import com.shop.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo urepo;
	
	@Autowired
	ProductsRepo srepo;

	public User addUser(User usr) {
		return urepo.save(usr);

	}

	public List<User> findAllUsers() {
		return urepo.findAll();

	}

	
	public boolean deleteUser(long id) {
		if (urepo.findById(id).isPresent()) {
			urepo.deleteById(id);
			return true;
		}
		return false;
	}

	public User updateUser(User user, long id) {
		if (urepo.findById(id).isPresent()) {
			User old = urepo.findById(id).get();
			if(user.getName()!=null)
				old.setName(user.getName());
			if(user.getAddress()!=null)
				old.setAddress(user.getAddress());
			if(user.getEmail()!=null)
				old.setEmail(user.getEmail());
			if(user.isAdmin()!=false)
				old.setAdmin(true);
			
			return urepo.save(old);
		} else
			return null;
	}

	public User getUserById(long id) {

		if (urepo.findById(id).isPresent())
			return urepo.findById(id).get();
		else
			return null;
	}

		
	public List<Products> showCart(long id) {
		
		User us = urepo.findById(id).get();
		
		List<Products> prods = us.getProducts();
		
		return prods;
	
	}

	public List<Products> showProductsByDate(long id, int date){
		
		User us = urepo.findById(id).get();
		List<Products> product = us.getProducts();
		List<Products> productsByDate = new ArrayList<Products>();
		for(Products pr :productsByDate) {
			
			if(pr.isSold()==true) {
				
				if(pr.getDateOfSold().equals(date))
					productsByDate.add(pr);
			}
		}
		
		if (productsByDate!=null)
			return productsByDate;
		else
			return null;		
	}
 	
	public List<Products> showProductsByCategory(long uId, long cId){
		
		User us = urepo.findById(uId).get();
		
		List<Products> products = us.getProducts();
		
		List<Products> getProductsByCategory = new ArrayList<Products>();
		
		for(Products p: products) {
			if(p.isSold()==true&& p.getCat().getCtid()==cId) {
				
				getProductsByCategory.add(p);
				
			}
		}
		
		if(getProductsByCategory!=null)
			return getProductsByCategory;
		else
			return null;
		
	}
	
}
