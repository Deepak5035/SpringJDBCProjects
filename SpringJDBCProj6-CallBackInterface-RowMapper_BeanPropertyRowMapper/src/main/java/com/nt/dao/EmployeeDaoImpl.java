package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jt=null;
	private final static String GET_EMP_BY_EMPNO="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	
	
	public EmployeeBo fetchDetils(int empno) {
		System.out.println("EmployeeDaoImpl.fetchDetils()");
		EmployeeBo bo1=null;
		bo1=jt.queryForObject(GET_EMP_BY_EMPNO, 
				              new BeanPropertyRowMapper<EmployeeBo>(EmployeeBo.class),
				             empno);
		return bo1;
    }
}
	
	

