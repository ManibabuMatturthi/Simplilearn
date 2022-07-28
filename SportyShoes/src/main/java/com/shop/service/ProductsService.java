package com.shop.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.entity.Products;
import com.shop.entity.User;
import com.shop.repo.CategoryRepo;
import com.shop.repo.ProductsRepo;
import com.shop.repo.UserRepo;

import net.bytebuddy.agent.builder.AgentBuilder.FallbackStrategy.Simple;

@Service
public class ProductsService {

	@Autowired
	ProductsRepo prepo;

	@Autowired
	CategoryRepo catg;
	
	@Autowired
	UserRepo urepo;

	public Products addProducts(Products prod, long catId) {

		Category cat = catg.findById(catId).get();
//
		prod.setCat(cat);
		
//		cat.addToProduct(prod);
		return prepo.save(prod);
		
	}

	public List<Products> findAllProductss() {
		return prepo.findAll();

	}

	public boolean deleteProducts(long id) {
		if (prepo.findById(id).isPresent()) {
			prepo.deleteById(id);
			return true;
		}
		return false;
	}

	public Products updateProducts(Products products, long id) {
		if (prepo.findById(id).isPresent()) {
			Products old = prepo.findById(id).get();
			if (products.getPname() != null)
				old.setPname(products.getPname());
			if (products.getDescription() != null)
				old.setDescription(products.getDescription());
			if (products.getPrice() != null)
				old.setPrice(products.getPrice());
			if (products.getQty() != 0)
				old.setQty(products.getQty());
			
			return prepo.save(old);
		} else
			return null;
	}

	public Products getProductsById(long id) {

		if (prepo.findById(id).isPresent())
			return prepo.findById(id).get();
		else
			return null;
	}
	
	public List<Products> searchProductsByCategory(long cid){
		List<Products> products = prepo.findAll();
		List<Products> productsByCategory = new ArrayList<Products>();
		
		for(Products p: products) {
			if(p.getCat().getCtid()==cid)
				productsByCategory.add(p);
		}
		if(productsByCategory!=null)
			return productsByCategory;
		else
			return null;
		
		
	}
	
	 public Products addToPurchase(long pId, User user) {
 		
 		Products pur = prepo.findById(pId).get();
 		int dt = new Date().getDate();
 		if(pur!=null) {
 			  
 			  pur.setSold(true);
 			  pur.setToUser(user);
 			  pur.setDateOfSold(dt);
			  user.addProducts(pur);
 			  urepo.save(user);
 			  prepo.save(pur);
 		}
 		else
 			pur.setSold(false);
 		
 		return prepo.save(pur);
 	}
	

}