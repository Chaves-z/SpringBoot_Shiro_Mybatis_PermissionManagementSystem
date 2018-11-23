package com.example.demo.service;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.example.demo.common.domain.QueryRequest;
import com.example.demo.common.service.IService;
import com.example.demo.model.Dict;

@CacheConfig(cacheNames = "DictService")
public interface DictService extends IService<Dict> {

	@Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
	List<Dict> findAllDicts(Dict dict, QueryRequest request);

	@Cacheable(key = "#p0")
	Dict findById(Long dictId);

	@CacheEvict(allEntries = true)
	void addDict(Dict dict);

	@CacheEvict(key = "#p0", allEntries = true)
	void deleteDicts(String dictIds);

	@CacheEvict(key = "#p0", allEntries = true)
	void updateDict(Dict dicdt);
}
