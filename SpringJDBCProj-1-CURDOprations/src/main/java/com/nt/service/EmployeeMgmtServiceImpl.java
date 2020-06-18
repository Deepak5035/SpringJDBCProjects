 package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeMgmtServiceImpl implements EmployeeMgmtService {

	EmployeeDAO empdao=null;
	
	public EmployeeMgmtServiceImpl(EmployeeDAO empdao) {	
		this.empdao = empdao;
	}

	public String EmpCountService() {		
		
		int result=0;
		
		result=empdao.getEmpCount();
		
		return "Total employee count is"+result;
	}

	public String EmpNameService(int empno) {
		String resultName=null;
		resultName=empdao.getEmpName(empno);
		return resultName;
	}

	public Map<String, Object> EmpDetilsService(int empno) {
		Map<String,Object> empDetails=null;
		empDetails=empdao.getEmpDetails(empno);
		return empDetails;
	}

	public List<Map<String, Object>> EmpDetilsByDeptNoService(int deptno1, int deptno2) {
		List<Map<String,Object>> empDetilsByDeptono=null;
		empDetilsByDeptono=empdao.getEmpDetailsByDeptNo(deptno1, deptno2);
		return empDetilsByDeptono;
	}

	public String UpdateEmpService(int empno, String ename, double sal, String job, int deptno) {
		int result=0;
		result=empdao.updateEmp(empno, ename, sal, job, deptno);
		if(result==0) {
			return"No row Update";
		}
		else
		return "Record insert Sucsessfully";
	}

}
