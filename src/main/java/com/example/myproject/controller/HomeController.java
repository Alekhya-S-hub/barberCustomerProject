package com.example.myproject.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.model.Users;
import com.example.myproject.service.UserService;

@RestController
public class HomeController
{
	
	@Autowired
	UserService userService;
	
	@GetMapping("/home")
	public String baseMethod()
	{
		return "Hello World";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody Users user)
	{
		return userService.saveUser(user);
		
	}
	
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody Users user)
	{
		return userService.updateUser(user);
	}
	
	@GetMapping("/getUsers")
	public List<Users> getUsers()
	{
		return userService.getUsers();
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable("userId") int userId)
	{
		return userService.deleteUser(userId);
	}
	
	@GetMapping("/getUserById/{userId}")
	public Map<String,Object> getUserById(@PathVariable("userId") int userId)
	{
		return userService.getUserById(userId);
	}
}