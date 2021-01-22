package com.nt.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
				                       
				                  (rs, rowNum) -> {
										EmployeeBo bo=null;
										bo=new EmployeeBo();
										
										bo.setEmpno(rs.getInt(1));
										bo.setEname(rs.getString(2));
										bo.setSal(rs.getDouble(3));
										bo.setJob(rs.getString(4));
										bo.setDeptno(rs.getInt(5));
										return bo;
									}
									   
				                          ,empno);
		return bo1;
		                         }
}
	
	

