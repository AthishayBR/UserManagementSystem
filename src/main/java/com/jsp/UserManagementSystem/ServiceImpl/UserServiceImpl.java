package com.jsp.UserManagementSystem.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.UserManagementSystem.Entity.User;
import com.jsp.UserManagementSystem.Repo.UserRepo;
import com.jsp.UserManagementSystem.Service.UserService;
import com.jsp.UserManagementSystem.UserUtil.ResponseStructure;
import com.jsp.UserManagementSystem.requestdto.UserRequest;
import com.jsp.UserManagementSystem.responsedto.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ResponseStructure<User> rs;

	@Autowired
	private ResponseStructure<UserResponse> rsu;

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequest userRequest) {
		
		User user = mapToUser(userRequest);
		user = userRepo.save(user);
		UserResponse userResponse = mapToUserResponse(user);

		rsu.setStatus(HttpStatus.CREATED.value());
		rsu.setMessage("user data inserted sucessfully");
		rsu.setData(userResponse);
		return new ResponseEntity<ResponseStructure<UserResponse>>(rsu, HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<UserResponse>> updateUser(Integer userId, UserRequest userRequest) {
		// User userobject = userRepo.findById(userId).orElseThrow(() -> new
		// RuntimeException());
		User user = mapToUser(userRequest);
		user.setUserId(userId);
		user = userRepo.save(user);
		ResponseStructure<User> rs = new ResponseStructure<User>();
		rsu.setStatus(HttpStatus.OK.value());
		rsu.setMessage("user data inserted sucessfully");
		rsu.setData(mapToUserResponse(user));
		return new ResponseEntity<ResponseStructure<UserResponse>>(rsu, HttpStatus.OK);
	}

	private User mapToUser(UserRequest userRequest) {
		return User.builder().userName(userRequest.getUserName()).userEmail(userRequest.getUserEmail())
				.userPassword(userRequest.getUserPassword()).build();
	}

	private UserResponse mapToUserResponse(User user) {
		return UserResponse.builder().userId(user.getUserId()).userName(user.getUserName())
				.userEmail(user.getUserEmail()).build();
	}

}
