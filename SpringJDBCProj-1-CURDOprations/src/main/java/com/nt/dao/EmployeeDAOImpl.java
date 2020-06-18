package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
static final String GET_EMP_COUNT="SELECT COUNT(*) FROM EMP";
static final String GET_EMP_NAME="SELECT ENAME FROM EMP WHERE EMPNO=?";
static final String GET_EMP_DETILS="SELECT ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
static final String GET_EMP_DETILS_BY_DEPTNO="select empno,ename,sal,job from emp where deptno in(?,?)";    
static final String UPDATE_EMP="INSERT INTO EMP (EMPNO,ENAME,SAL,JOB,DEPTNO) VALUES(?,?,?,?,?)";    

     JdbcTemplate jt=null;

	public EmployeeDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}



	public int getEmpCount() {
		int count=0;
		
		count=jt.queryForObject(GET_EMP_COUNT, Integer.class);
		return count;
	}



	public String getEmpName(int empno) {
		String result=null;
		result=jt.queryForObject(GET_EMP_NAME, String.class,empno);
		return result;
	}



	public Map<String, Object> getEmpDetails(int empno) {
		Map<String,Object> empDetils=null;
		empDetils=jt.queryForMap(GET_EMP_DETILS, empno);
		return empDetils;
	}



	public List<Map<String, Object>> getEmpDetailsByDeptNo(int deptno1,int deptno2) {
		List<Map<String,Object>> empDetils=null;
		empDetils=jt.queryForList(GET_EMP_DETILS_BY_DEPTNO, deptno1,deptno2);
		return empDetils;
	}



	public int updateEmp(int empno, String ename, double sal, String job, int deptno) {
		int result=0;
		result=jt.update(UPDATE_EMP, empno,ename,sal,job,deptno);
		return result;
	}

}
