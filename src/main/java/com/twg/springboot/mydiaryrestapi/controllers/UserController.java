package com.twg.springboot.mydiaryrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.twg.springboot.mydiaryrestapi.entities.User;
import com.twg.springboot.mydiaryrestapi.service.Userservice;

@RestController
public class UserController {
	
	@Autowired
	private Userservice userservice;
	
	@GetMapping("/users/")
	public List<User> getUsers()
	{
		List<User> users =userservice.findAll();
		return users;
	}
   @GetMapping("/users/{id}")
	public User getUser(@PathVariable("id") int id)
	{
		User user1=userservice.findById(id);
		return user1;
	}
   @PostMapping("/users/")
   public User setUser(@RequestBody User user)
   {
	   User savedrecord=userservice.saveUser(user);
	   return savedrecord;
   }
   @DeleteMapping("/users/{id}")
   public void deleteuser(@PathVariable int id)
   {
	  User user= userservice.findById(id);
	   userservice.deleteUser(user);
   }
   @PutMapping("/users/")
   public User updateuser(@RequestBody User user)
   {
	   User updated=userservice.updateUser(user);
	   return updated;
   }
   @PutMapping("/users/{id}")
	public void updateEntry1(@RequestBody User user,@PathVariable("id") int id)
	{
		User user1=userservice.findById(id);
		
		user1.setPassword(user.getPassword());
		user1.setUsername(user.getUsername());
		
		userservice.updateUser(user1);
		
	}
   
}
