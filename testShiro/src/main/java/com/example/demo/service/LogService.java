package com.example.demo.service;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import com.example.demo.common.service.IService;
import com.example.demo.model.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface LogService extends IService<SysLog> {

	List<SysLog> findAllLogs(SysLog log);

	void deleteLogs(String logIds);

	@Async
	void saveLog(ProceedingJoinPoint point, SysLog log) throws JsonProcessingException;
}
