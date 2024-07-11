package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	//	QueryString(질의문자열) : key=value&key=value&...
	//method 상관없음
	//content-type :application/x-www-form-urlencoded
	
	//QueryString => 커맨드 객체 : 클래스 타입만 받음
	@RequestMapping(path="comobj",
			method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String commandObject(EmpVO empVO) {
		String result = "";
		result +="path : / comobj\n";
		result +="\t empid : " + empVO.getEmpid();
		result +="\t empname : " + empVO.getEmpname();
		return result;
	}
	
	
	//QueryString => @RequestParam : 기본타입, 단일값 (key=value)
	@RequestMapping(path="reqparam",
			method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String requestParam(
			String empname, //생략가능(필수X)
			@RequestParam Integer empid, //필수
			@RequestParam(name = "message",
							defaultValue="No message",
							required=true) String msg){
		String result = "";
		result +="path : / reqparam\n";
		result +="\t empid : " + empid;
		result +="\t empname : " + empname;
		result +="\t message : " + msg;
		return result;
	}
	
	//@PathVariable : 경로에 값을 포함하는 방식, 단일 값
	//method는 상관없음
	//content-type도 상관없음
	@RequestMapping("path/{id}/{pwd}")  //path/Hong, path/1234
	@ResponseBody
	public String pathVariable(@PathVariable String id,
			@PathVariable(name ="pwd") String password){
		String result = "";
		result +="path : / path/{id}/{pwd} \n";
		result +="\t id : " + id;
		result +="\t pwd : " + password;
		return result;
	}
	
	@RequestMapping(path={"rpath/{id}/{pwd}","rpath/{id}"})  //path/Hong, path/1234 중간값은 필수, 마지막값은 가능
	@ResponseBody
	public String rpathVariable(@PathVariable String id,
			@PathVariable(name ="pwd",required=false) String password){
		//pathvariable 기본값 설정하는 방법
		if(password ==null) password="1234";
		String result = "";
		result +="path : / path/{id}/{pwd} \n";
		result +="\t id : " + id;
		result +="\t pwd : " + password;
		return result;
	}
	
	//@RequestBody : JSON 포맷, 배열[{}] or 객체{} 구분 잘 하기!
	//Method  : POST,PUT
	//Content-type : application/json
	@PostMapping("resbody")  
	@ResponseBody
	public String requestBody(@RequestBody EmpVO empVO) {
		String result = "";
		result +="path : / resbody \n";
		result +="\t empid : " + empVO.getEmpid();
		result +="\t empname : " + empVO.getEmpname();
		return result;
	}
	
	
	@PostMapping("resbodyList")  
	@ResponseBody
	public String requestBodyList(@RequestBody List<EmpVO> list) {
		String result = "path : /resbodyList \n";
		for(EmpVO empVO : list){
		result +="\t empid : " + empVO.getEmpid();
		result +="\t empname : " + empVO.getEmpname();
		result +="\n";
		}
		return result;
	}
	
	
	
}
