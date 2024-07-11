package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller //기능x, 사용자의 요청(endpoint)에 대한 처리를 정의
			//=> url + method => service => view
public class EmpController {
	//해당 컨트롤러에서 서비스를 추가
	@Autowired
	EmpService empService;
	
	// GET : 조회, 빈페이지 
	// POST : 데이터조각(등록,수정,삭제)
	
	//전체조회 : 데이터 조회하고 페이지 연결
	@GetMapping("empList")
	public String empList(Model model) { //model = request + response
		// 1) 기능 수행 _ 변수에 담기
		List<EmpVO> list = empService.empList();
		// 2) 클라이언트 전달할 데이터(결과) 담기
		model.addAttribute("empList",list);
		// 3) 데이터(결과)를 출력할 페이지 결정
		return "emp/list";
	}
	
	//단건조회
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) { //empvo 커멘드객체 => QueryString(application/x-www-form-urlencoded)
		EmpVO findVO = empService.empInfo(empVO);
		model.addAttribute("empInfo",findVO);
		return "emp/info";
	}
	
	//등록 - 등록을 위한 페이지 요청
	@GetMapping("empInsert")
	public String empInsertForm() {
		return "emp/insert";
	}
	
	//등록 - DB에 등록하는 처리(연산, submit->커맨트객체사용)
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO, Model model) {
		int empInsert = empService.empInsert(empVO);
		String url = null;

		if(empInsert > -1) {
			//정상적으로 등록된 경우( 'redirect:' 으로 시작되면 경로 재요청으로 이어짐)
			url = "redirect:empInfo?empid="+empInsert;
		}else {
			//정상적으로 등록되지 않은 경우
			url="redirect:empList";
		}
		return url;
	}
	
	//수정 - 수정을 위한 페이지 요청
	//@GetMapping("empUpdate")
	
	//수정 - DB에 등록하는 처리(연산, AJAX => QueryString) content type을 달리해서 적용
	
	//수정 - DB에 등록하는 처리(연산, AJAX => JSON)
	
	//삭제 - 페이지 x , 처리만 진행
	
	
	
}
