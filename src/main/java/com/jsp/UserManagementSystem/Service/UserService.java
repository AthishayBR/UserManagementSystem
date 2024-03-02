package com.jsp.UserManagementSystem.Service;

import org.springframework.http.ResponseEntity;

import com.jsp.UserManagementSystem.Entity.User;
import com.jsp.UserManagementSystem.UserUtil.ResponseStructure;
import com.jsp.UserManagementSystem.requestdto.UserRequest;
import com.jsp.UserManagementSystem.responsedto.UserResponse;

public interface UserService {
public ResponseEntity<ResponseStructure<UserResponse>> saveUser(UserRequest userRequest);

public ResponseEntity<ResponseStructure<UserResponse>> updateUser(Integer userId, UserRequest userRequest);


}
