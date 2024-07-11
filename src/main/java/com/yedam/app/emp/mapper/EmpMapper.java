package com.yedam.app.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.emp.service.EmpVO;

public interface EmpMapper {
	//쿼리실행
	//테이블을 기준으로 함
	//전체조회 전체조회라 매개변수없음
	public List<EmpVO>selectEmpAll();
	//단건조회 단건이라 List아니고, 매개변수 잇음
	public EmpVO selectEmpInfo(EmpVO empvo);
	//아래부터 리턴타입 정해져잇음(int기반)
	//등록(전체대상으로 등록이라 매개변수 empvo)
	public int insertEmpInfo(EmpVO empvo);
	//수정 매개변수가 두개라 emp-map에서 값을 지정받을수 없기때문에 
	//param을 적어줘서 mybatis안에서 사용할 변수 선언해줌, 외의 이름 지정되지않은것은 #{emp.empname}으로 쓰기
	public int updateEmpInfo(@Param("id")int empId, @Param("emp")EmpVO empvo);
	//삭제(아이디값만필요해서 empid EmpVO 변수명과 달라도됨)
	public int deleteEmpInfo(int empId);
}
