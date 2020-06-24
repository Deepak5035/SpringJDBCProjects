package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDaoImpl implements EmpolyeeDao {
    
	@Autowired
	JdbcTemplate jt=null;
	
	
	public List<Map<String, Object>> fetchEmp(String con) {
        List<Map<String,Object>> empResult=null;
		
        empResult=jt.queryForList("SELECT EMPNO,ENAME,SAL,JOB FROM EMP WHERE JOB IN"+con+"+ORDER BY JOB",new Object[] {});
        
		return empResult;
	}

}
