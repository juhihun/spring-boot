package com.yedam.app.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.DeptMapper;
import com.yedam.app.emp.service.DeptService;
import com.yedam.app.emp.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<DeptVO> deptList() {
		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptInfo(DeptVO DeptVO) {
		return deptMapper.selectDeptInfo(DeptVO);
	}

	@Override
	public int deptInsert(DeptVO deptVO) {
		int result = deptMapper.insertDeptInfo(deptVO);
		return result == 1? deptVO.getDeptno() : -1;
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
