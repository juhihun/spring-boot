package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

//사용자에게 제공하는 기능
public interface DeptService {
	//전체 사원정보 조회
	public List<DeptVO> deptList();
	
	//사원정보 조회
	public DeptVO deptInfo(DeptVO deptVO);
	
	//사원정보 등록( 등록,수정,삭제 return int 로 안받아도됨, Map를 많이 씀)
	public int deptInsert(DeptVO deptVO);
	
	//사원정보 수정
	public Map<String, Object> deptUpdate(DeptVO deptVO);
		
	//사원정보 삭제
	public Map<String, Object> deptDelete(DeptVO deptVO);


}
