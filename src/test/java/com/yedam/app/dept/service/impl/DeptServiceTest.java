package com.yedam.app.dept.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;
@SpringBootTest
class DeptServiceTest {

	@Autowired DeptMapper deptMapper;
	
	@Test
	void contextLoads() {
		Assertions.assertNotNull(deptMapper);
	}
	@Test
	void selectDeptAll() {
		List<DeptVO> list = deptMapper.selectDeptAll();
		assertTrue(!list.isEmpty());
	}
	@Test
		void selectDeptInfo() {
			DeptVO deptVO = new DeptVO();
			deptVO.setDeptno(30);
			
			DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
			assertEquals(findVO.getDname(), "sales");
	}
	@Test
	void insertDeptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDname("marketing");
		deptVO.setLoc("seoul");
		
		int result = deptMapper.insertDeptInfo(deptVO);
		assertEquals(deptVO.getDeptno(), 51);
	}
	
	@Test
	void updateDeptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptno(51);
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		
		findVO.setDname("accounting");
		findVO.setLoc("Deagu");
		
		int result = deptMapper.updateDeptInfo(findVO.getDeptno(), findVO);
		
		assertEquals(result, 1);
	}
	
	@Test
	void deleteDeptInfo() {
		int result = deptMapper.deleteDeptInfo(52);
		assertEquals(1, result);
	}
	

}
