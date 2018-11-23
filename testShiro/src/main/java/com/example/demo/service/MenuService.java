package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.example.demo.common.domain.Tree;
import com.example.demo.common.service.IService;
import com.example.demo.model.Menu;

@CacheConfig(cacheNames = "MenuService")
public interface MenuService extends IService<Menu> {

	List<Menu> findUserPermissions(String userName);

	List<Menu> findUserMenus(String userName);

	List<Menu> findAllMenus(Menu menu);

	Tree<Menu> getMenuButtonTree();

	Tree<Menu> getMenuTree();

	Tree<Menu> getUserMenu(String userName);

	Menu findById(Long menuId);

	Menu findByNameAndType(String menuName, String type);

	void addMenu(Menu menu);

	void updateMenu(Menu menu);

	void deleteMeuns(String menuIds);

	@Cacheable(key = "'url_'+ #p0")
	List<Map<String, String>> getAllUrl(String p1);
}
