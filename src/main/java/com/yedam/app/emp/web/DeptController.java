package com.yedam.app.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.DeptService;
import com.yedam.app.emp.service.DeptVO;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	//전체조회 
	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		model.addAttribute("deptList", list);
		return "dept/list";
	}
	
	//단건조회
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) { //empvo 커멘드객체 => QueryString(application/x-www-form-urlencoded)
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo",findVO);
		return "dept/info";
	}
	
	//등록 - 등록을 위한 페이지 요청
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
	}
	
	//등록 - DB에 등록하는 처리(연산, submit->커맨트객체사용)
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO deptVO, Model model) {
		int deptInsert = deptService.deptInsert(deptVO);
		String url = null;

		if(deptInsert > -1) {
			//정상적으로 등록된 경우( 'redirect:' 으로 시작되면 경로 재요청으로 이어짐)
			url = "redirect:deptInfo?deptno="+deptInsert;
		}else {
			//정상적으로 등록되지 않은 경우
			url="redirect:deptList";
		}
		return url;
	}
}
