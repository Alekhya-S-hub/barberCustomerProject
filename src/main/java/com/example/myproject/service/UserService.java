package com.example.myproject.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.example.myproject.model.Users;
import com.example.myproject.repository.UserRepository;
import com.google.gson.Gson;

@Service
public class UserService{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public String saveUser(Users user) {
		 
		repo.save(user);
		return "User Saved";
	}

	public String updateUser(Users user) {
		 
		repo.save(user);
		return "User updated";
	}

	public List<Users> getUsers() {
		
		List<Users> users = new ArrayList<>();
		users=repo.findAll(); 
		return users;
	}

	public String deleteUser(int userId) {
		 
		try {
		repo.deleteById(userId);
		return "User Deleted";
		}
		
		catch(Exception e )
		{
			e.printStackTrace();
			return "Error";
		}
	}

	public Map<String,Object> getUserById(int userId) {
		
		Map<String,Object> map = new HashMap<>();
		try {
			String sql ="select * from users where user_id=?";
			jdbcTemplate.query(sql, new Object[] {userId}, new ResultSetExtractor<Map<String,Object>>() {

				@Override
				public Map<String,Object> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while(rs.next())
					{
						map.put("userName", rs.getString("user_name"));
						map.put("userId", rs.getInt("user_id"));
					}
					return null;
				}
			});
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return map;
	}
	
	
	
}