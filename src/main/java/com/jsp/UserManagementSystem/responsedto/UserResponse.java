package com.jsp.UserManagementSystem.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor 
public class UserResponse {
	
	private int userId;
	private String userName;
	private String userEmail; 
	
}
