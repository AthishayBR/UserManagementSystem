package com.jsp.UserManagementSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.UserManagementSystem.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
