package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBo;

@Repository("empdao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jt=null;
	private final static String GET_EMP_BY_JOB="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE JOB=?";
	
	
	public List<EmployeeBo> fetchDetils(String job) {
		System.out.println("EmployeeDaoImpl.fetchDetils()");
		List<EmployeeBo> bo=null;
		bo=jt.query(GET_EMP_BY_JOB, 
				                new ResultSetExtractor<List<EmployeeBo>>() {

									public List<EmployeeBo> extractData(ResultSet rs){
										List<EmployeeBo> listbo=null;
										listbo=new ArrayList<EmployeeBo>();
											try {
											  while(rs.next()) {
												EmployeeBo bo=new EmployeeBo();
												bo.setEmpno(rs.getInt(1));
												bo.setEname(rs.getString(2));
												bo.setSal(rs.getDouble(3));
												bo.setJob(rs.getString(4));
												bo.setDeptno(rs.getInt(5));
												listbo.add(bo);
											    } 
											}catch (SQLException e) {
												e.printStackTrace();
											}
											return listbo;   
										   }
										
								 	     }
						         ,job);
		return bo;
     }//method
}//class
	
	

