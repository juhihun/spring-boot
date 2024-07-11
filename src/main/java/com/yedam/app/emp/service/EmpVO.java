package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

//readOnly 일때 Getter , setter도 필요할땐 Data
@Data
public class EmpVO {
	private Integer empid;
	private String empname;
	private int mgr;
	private double sal;
	private int deptid;
	@DateTimeFormat(pattern="yyyy-MM-dd") //파라미터 자동변환
	private Date hiredate; // 2024/07/01 -> 2024-07-01 json타입으로 보낼땐 상관없음.
	
	
}
