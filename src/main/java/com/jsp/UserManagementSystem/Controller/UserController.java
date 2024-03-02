package com.jsp.UserManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.UserManagementSystem.Entity.User;
import com.jsp.UserManagementSystem.Service.UserService;
import com.jsp.UserManagementSystem.UserUtil.ResponseStructure;
import com.jsp.UserManagementSystem.requestdto.UserRequest;
import com.jsp.UserManagementSystem.responsedto.UserResponse;

@RestController
public class UserController {

	@Autowired
	private UserService userservice; 
	
	@PostMapping("/users") 
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(@RequestBody UserRequest userRequest) {
		ResponseEntity<ResponseStructure<UserResponse>> u1=userservice.saveUser(userRequest);
		return u1;
	}
	
	@PutMapping("/users/{userId}") 
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(@PathVariable Integer userId, @RequestBody UserRequest userRequest) {
		ResponseEntity<ResponseStructure<UserResponse>> u1=userservice.updateUser(userId,userRequest);
		return u1;
	}
	
	
	
	
}
