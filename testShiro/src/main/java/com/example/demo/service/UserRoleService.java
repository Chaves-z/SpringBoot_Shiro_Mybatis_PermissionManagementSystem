package com.example.demo.service;

import com.example.demo.common.service.IService;
import com.example.demo.model.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
