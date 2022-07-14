package com.example.springbootapp.feedbackdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//Repository
@Repository
public class FeedbackDao {

	@Autowired
	
	private JdbcTemplate template;
	public int addFeedback(FeedbackEntity feedback) {
		
		return template.update("insert into feedback(name, email, feedback) values (?,?,?)",
				feedback.getName(),feedback.getEmail(),feedback.getFeedback());				
	}
	
	
	  public List<FeedbackEntity> findAll() {
	    return template.query("SELECT * from tutorials", BeanPropertyRowMapper.newInstance(FeedbackEntity.class));
	  }
	  
	 
}
