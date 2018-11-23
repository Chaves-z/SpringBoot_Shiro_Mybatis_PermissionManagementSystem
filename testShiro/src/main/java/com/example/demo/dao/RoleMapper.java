package com.example.demo.dao;

import java.util.List;

import com.example.demo.common.config.MyMapper;
import com.example.demo.model.Role;
import com.example.demo.model.RoleWithMenu;

public interface RoleMapper extends MyMapper<Role> {

	List<Role> findUserRole(String userName);

	List<RoleWithMenu> findById(Long roleId);
}