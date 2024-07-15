package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@Service // AOP가 적용될 유일한 bean 
public class DeptServiceImpl implements DeptService {

	@Autowired //테이블에 접근 필요(필드 주입 방식)
	DeptMapper deptMapper;

	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptInfo(DeptVO deptVO) {
		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int deptInsert(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1 ? deptVO.getDeptno() : -1;

	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		
		int result = deptMapper.updateDeptInfo(deptVO.getDeptno(), deptVO);
		
		if(result ==1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deptVO);
		
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(DeptVO deptVO) {
		Map<String, Object> map = new HashMap<>();
		int result = deptMapper.deleteDeptInfo(deptVO.getDeptno());
		
		if (result == 1) {
			map.put("deptno", deptVO.getDeptno());
		}
		
		return map;
	}

}
