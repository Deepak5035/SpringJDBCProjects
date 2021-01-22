package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
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
		List<EmployeeBo> listbo=new ArrayList();
		
		jt.query(GET_EMP_BY_JOB,new EmployeeRowCallBackHandler(listbo),job);
		
		return listbo;
     }//method
	
	
	
	//inner class
	
	class EmployeeRowCallBackHandler implements RowCallbackHandler{
         
		
		List<EmployeeBo> listbo=null;
         
		public EmployeeRowCallBackHandler(List<EmployeeBo> listbo) {
			this.listbo = listbo;
		}

		EmployeeBo bo=new EmployeeBo();

		@Override
		public void processRow(ResultSet rs) throws SQLException {
		  bo.setEmpno(rs.getInt(1));	
		  bo.setEname(rs.getString(2));	
		  bo.setJob(rs.getString(3));
		  bo.setSal(rs.getDouble(4));
		  bo.setDeptno(rs.getInt(5));
		}
		
	}
}//class
	
	

