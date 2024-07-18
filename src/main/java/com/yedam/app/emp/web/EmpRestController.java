package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

//@CrossOrigin(origins = "http://localhost:5000") //제한을 두지않고 모든 origin에 대응한다("*"), 5000에 대해 제한한다
@RestController	// => @Controller + 모든 메소드에 @ResponseBody 선언한 의미
public class EmpRestController {
	//내부 컨트롤러 전부 AJAX 전용
	
	@Autowired
	EmpService  empService;
	//REST : GET, POST, PUT, DELETE 메소드 사용 / MODEL 안씀, 브라우저에 입력되는건 GET
	//전체조회
	@GetMapping("emps")  //보통 복수 사용
	public List<EmpVO> empList(){
		return empService.empList();
	}
	
	//단건조회
	@GetMapping("emps/{empid}") //pathvariable 방식 (경로가 같아서 에러->구분하기 위해 추가정보)
	public EmpVO empInfo(@PathVariable Integer empid) { //쿼리로 인식하기때문에 pathVariable선언
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		return empService.empInfo(empVO);
	}
	
	//등록
	@PostMapping("emps")
	public int empInsert(@RequestBody EmpVO empVO) { //여러정보 받을땐 pathVariable(QueryString) 보단 RequestBody
		return empService.empInsert(empVO);
	}
	
	//수정(단건조회+등록)
	//Put(기존데이터, 수정데이터 섞어서 넘어옴),  Patch(수정하려는 항목만 넘어옴)
	@PutMapping("emps/{empid}")
	public Map<String, Object> empUpdate(@RequestBody EmpVO empVO, 
										@PathVariable Integer empid) {
		empVO.setEmpid(empid);
		return empService.empUpdate(empVO);
	}
	
	
	//삭제
	@DeleteMapping("emps/{empid}")
	public Map<String, Object> empDelete(@PathVariable Integer empid) { //쿼리로 인식하기때문에 pathVariable선언
		EmpVO empVO = new EmpVO();
		empVO.setEmpid(empid);
		return empService.empDelete(empVO);
	}
}
