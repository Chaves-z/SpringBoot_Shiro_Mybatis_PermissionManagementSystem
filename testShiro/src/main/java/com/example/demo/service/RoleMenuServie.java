package com.example.demo.service;

import com.example.demo.common.service.IService;
import com.example.demo.model.RoleMenu;

public interface RoleMenuServie extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(String roleIds);

	void deleteRoleMenusByMenuId(String menuIds);
}
