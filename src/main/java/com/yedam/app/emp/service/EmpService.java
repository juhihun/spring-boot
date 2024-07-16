package com.yedam.app.emp.service;

import java.util.List;
import java.util.Map;

//사용자에게 제공하는 기능
public interface EmpService {
	//전체 사원정보 조회
	public List<EmpVO> empList();
	
	//사원정보 조회
	public EmpVO empInfo(EmpVO empVO); 
	
	//사원정보 등록( 등록,수정,삭제 return int 로 안받아도됨, Map를 많이 씀)
	public int empInsert(EmpVO empVO);
	
	//사원정보 수정
	public Map<String, Object> empUpdate(EmpVO empVO);
		
	//사원정보 삭제
	public Map<String, Object> empDelete(EmpVO empVO);


}
