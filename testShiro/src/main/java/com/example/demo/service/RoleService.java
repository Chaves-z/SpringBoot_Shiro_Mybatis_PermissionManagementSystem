package com.example.demo.service;

import java.util.List;

import com.example.demo.common.service.IService;
import com.example.demo.model.Role;
import com.example.demo.model.RoleWithMenu;

public interface RoleService extends IService<Role> {

	List<Role> findUserRole(String userName);

	List<Role> findAllRole(Role role);

	RoleWithMenu findRoleWithMenus(Long roleId);

	Role findByName(String roleName);

	void addRole(Role role, Long[] menuIds);

	void updateRole(Role role, Long[] menuIds);

	void deleteRoles(String roleIds);
}
