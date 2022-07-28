package com.shop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	//List<User> findByName(String uname);
	
	
}
