package com.example.demo.service;

import java.util.List;

import com.example.demo.common.domain.Tree;
import com.example.demo.common.service.IService;
import com.example.demo.model.Dept;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);

	void addDept(Dept dept);

	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
