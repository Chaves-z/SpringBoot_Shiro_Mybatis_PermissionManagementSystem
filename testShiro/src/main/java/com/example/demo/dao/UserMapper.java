package com.example.demo.dao;

import java.util.List;

import com.example.demo.common.config.MyMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserWithRole;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);

	List<UserWithRole> findUserWithRole(Long userId);

	User findUserProfile(User user);
}