package com.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.entity.Category;
import com.shop.entity.Products;
import com.shop.repo.CategoryRepo;
import com.shop.repo.ProductsRepo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo crepo;
	
	@Autowired
	ProductsRepo prepo;

	public Category addCategory(Category ctg) {
		return crepo.save(ctg);

	}
	
//	public Category addProduct(Category cat, long pid) {
//		
//		Products pr = prepo.findById(pid).get();
//		cat.addProduct(pr);
//		return crepo.save(cat);
//
//	}

	public List<Category> findAllCategorys() {
		return crepo.findAll();

	}

	
	public boolean deleteCategory(long id) {
		if (crepo.findById(id).isPresent()) {
			crepo.deleteById(id);
			return true;
		}
		return false;
	}

	public Category updateCategory(Category Category, long id) {
		if (crepo.findById(id).isPresent()) {
			Category old = crepo.findById(id).get();
			if(Category.getName()!=null)
				old.setName(Category.getName());
			return crepo.save(old);
		} else
			return null;
	}

	public Category getCategoryById(long id) {

		if (crepo.findById(id).isPresent())
			return crepo.findById(id).get();
		else
			return null;
	}
}
