package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jt=null;
	private final static String GET_EMP_BY_JOB="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE JOB=?";
	
	
	@SuppressWarnings("unchecked")
	public List<EmployeeBo> fetchDetils(String job) {
		System.out.println("EmployeeDaoImpl.fetchDetils()");
		List<EmployeeBo> bo=null;
		bo=(List<EmployeeBo>) jt.query(GET_EMP_BY_JOB, 
				                new RowMapperResultSetExtractor(new BeanPropertyRowMapper<EmployeeBo>(EmployeeBo.class))
						         ,job);
		return bo;
     }//method
}//class
	
	

