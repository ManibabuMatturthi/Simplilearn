package com.shop.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.entity.Category;
import com.shop.entity.Products;
import com.shop.entity.User;
import com.shop.repo.CategoryRepo;
import com.shop.service.CategoryService;
import com.shop.service.ProductsService;
import com.shop.service.UserService;

@RestController
@RequestMapping("/shop")
public class MainController {

	@Autowired
	UserService uservice;

	@Autowired
	CategoryService cservice;

	@Autowired
	ProductsService pservice;

	@Autowired
	CategoryRepo crepo;

	// User Operations Starts here onwards...

	@PostMapping("/users")
	public ResponseEntity<Object> addUsers(@RequestBody User user) {
		User entity = uservice.addUser(user);
		if (entity != null)
			return new ResponseEntity<Object>(entity, HttpStatus.CREATED);
		else
			return new ResponseEntity<Object>("Error while inserting data", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PutMapping("/admin/users/{id}")
	public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id) {
		User usr = uservice.updateUser(user, id);
		if (usr != null)
			return new ResponseEntity<Object>(usr, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Object>("User Not found", HttpStatus.NOT_MODIFIED);

	}

	@DeleteMapping("/admin/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable long id) {
		if (uservice.deleteUser(id))
			return new ResponseEntity<Object>("UserDeleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/admin/users")
	public List<User> getAllUsers() {

		return uservice.findAllUsers();
	}

	@GetMapping("/admin/users/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable long id) {

		if (uservice.getUserById(id) != null)
			return new ResponseEntity<Object>(uservice.getUserById(id), HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Result not fount", HttpStatus.NOT_FOUND);
	}

	//
	// Category Operations Starts here onwards.............
	//

	@PostMapping("/admin/category")
	public ResponseEntity<Object> addCategory(@RequestBody Category category) {
		Category cat = cservice.addCategory(category);
		if (cat != null)
			return new ResponseEntity<Object>(cat, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/admin/category")
	public List<Category> getAllCategoryList() {

		return cservice.findAllCategorys();
	}

	@GetMapping("/admin/category/{id}")
	public ResponseEntity<Object> getCategoryById(@PathVariable long id) {

		if (cservice.getCategoryById(id) != null)

			return new ResponseEntity<Object>(cservice.getCategoryById(id), HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Result not fount", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/admin/category/{id}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category category, @PathVariable long id) {
		Category cat = cservice.updateCategory(category, id);
		if (cat != null)

			return new ResponseEntity<Object>(cat, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@DeleteMapping("/admin/category/{id}")
	public ResponseEntity<Object> deleteCategory(@PathVariable long id) {
		if (cservice.deleteCategory(id))

			return new ResponseEntity<Object>("UserDeleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	//
	// Product Operations Starts here onwards...
	//
	@PostMapping("/admin/products/{catId}")

	public ResponseEntity<Object> addProduct(@PathVariable long catId, @RequestBody Products product) {

		Products prod = pservice.addProducts(product, catId);

		if (prod != null)
			return new ResponseEntity<Object>(prod, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/admin/products")
	public ResponseEntity<Object> getAllProducts() {

		List<Products> prods = pservice.findAllProductss();

		if (prods != null)
			return new ResponseEntity<Object>(prods, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("No products found", HttpStatus.NOT_FOUND);

	}

	@PutMapping("/admin/products/{id}")
	public ResponseEntity<Object> updateProduct(@RequestBody Products product, @PathVariable long id) {
		Products pro = pservice.updateProducts(product, id);
		if (pro != null)

			return new ResponseEntity<Object>(pro, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/admin/products/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable long id) {

		if (pservice.getProductsById(id) != null)

			return new ResponseEntity<Object>(pservice.getProductsById(id), HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Result not fount", HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/admin/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable long id) {
		if (pservice.deleteProducts(id))

			return new ResponseEntity<Object>("ProductDeleted", HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	//
	// Purchase Operations Starts from here....
	//

	@GetMapping("/user/products/{id}")
	public ResponseEntity<Object> getProductsById(@PathVariable long id) {

		if (pservice.getProductsById(id) != null)

			return new ResponseEntity<Object>(pservice.getProductsById(id), HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("Result not fount", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/user/products")
	public ResponseEntity<Object> getAllProductsInList() {

		List<Products> prods = pservice.findAllProductss();

		if (prods != null)
			return new ResponseEntity<Object>(prods, HttpStatus.FOUND);
		else
			return new ResponseEntity<Object>("No products found", HttpStatus.NOT_FOUND);

	}

	@PostMapping("/user/purchase/{uId}/{pId}")
	public ResponseEntity<Object> purchaseProduct(@PathVariable long uId, @PathVariable long pId) {

		User user = uservice.getUserById(pId);
		Products product = pservice.addToPurchase(pId, user);
		if (product != null)
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Product Not Found", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/admin/showcart/{uid}")
	public ResponseEntity<Object> showUserCart(@PathVariable long uid) {

		List<Products> cart = uservice.showCart(uid);

		if (cart != null)
			return new ResponseEntity<Object>(cart, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@GetMapping("/admin/showcard/{id}/{date}")
	public ResponseEntity<Object> showUserCartByDate(@PathVariable long uid, @PathVariable int date) {

		List<Products> cart = uservice.showProductsByDate(uid, date);

		if (cart != null)
			return new ResponseEntity<Object>(cart, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/admin/showcartbycategory/{uid}/{cid}")
	public ResponseEntity<Object> showUserCartByCategory(@PathVariable long uid, @PathVariable long cid) {

		List<Products> cart = uservice.showProductsByCategory(uid,cid);

		if (cart != null)
			return new ResponseEntity<Object>(cart, HttpStatus.OK);
		else
			return new ResponseEntity<Object>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	
}
