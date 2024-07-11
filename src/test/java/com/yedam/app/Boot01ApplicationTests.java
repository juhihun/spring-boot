package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@SpringBootTest
class Boot01ApplicationTests {
	@Autowired
	EmpMapper empMapper;
//	@Test
//	void contextLoads() {
//		assertNotNull(empMapper);
//	}
//	@Test
//	void selectEmpAll() {
		//전체조회
//		List<EmpVO> list = empMapper.selectEmpAll();
//		assertTrue(!list.isEmpty());
//	}
//	@Test
//	void selectEmpInfo() {
		//단건조회
//		EmpVO empVO = new EmpVO();
//		empVO.setEmpid(114);
//		
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		assertEquals(findVO.getEmpname(), "Den");
//	}
	@Test
	void insertEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmpname("Hong");
		empVO.setSal(1000);
		empVO.setDeptid(40);
		
		int result = empMapper.insertEmpInfo(empVO);
//		assertEquals(result,1);	
		assertEquals(empVO.getEmpid(),204);
	}
//	@Test
//	void updateEmpInfo() {
//		//1.단건조회 => 2.업데이트
//		//1-1) 조건(empVO)
//		EmpVO empVO = new EmpVO();
//		empVO.setEmpid(2);
//		//1-2) 조건을 조회(selectEmpInfo에 empVO(조건)를 넣어서 findVO에 담음)
//		EmpVO findVO = empMapper.selectEmpInfo(empVO);
//		//변경하고자하는값을 findVO에 담음
//		findVO.setEmpname("Kang");
//		findVO.setMgr(114);
//		//2.업데이트 (개별로 값을 넣음)
//		int result = empMapper.updateEmpInfo(findVO.getEmpid(), findVO);
//		assertEquals(1,result);
//	}
//	@Test void deleteEmpInfo() {
//		int result = empMapper.deleteEmpInfo(2);
//		assertEquals(1,result);
//	}
	
	
}
