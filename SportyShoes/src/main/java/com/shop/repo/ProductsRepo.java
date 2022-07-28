package com.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shop.entity.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long>{
	
//	@Query("select p from products p, users u groupby where u.id=?")
//	public List<Products> purchasedProducts(long uid);

}
