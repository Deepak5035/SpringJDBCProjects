package com.nt.dao;

import java.sql.ResultSet;
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
		EmployeeBo bo=null;
		bo=jt.queryForObject(GET_EMP_BY_EMPNO, new EmployeeRowMapper(), empno);
		return bo;
	}
	
	//inner class
	
	private class EmployeeRowMapper implements RowMapper<EmployeeBo>{

		public EmployeeBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeBo bo=null;
			bo=new EmployeeBo();
			
			bo.setEmpno(rs.getInt(1));
			bo.setEname(rs.getString(2));
			bo.setSal(rs.getDouble(3));
			bo.setJob(rs.getString(4));
			bo.setDeptno(rs.getInt(5));
			return bo;
		}//mapRow
		
	}//innerClass
	
}//outerClass
