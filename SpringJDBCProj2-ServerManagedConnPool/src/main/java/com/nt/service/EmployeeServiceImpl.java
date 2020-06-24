package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.dao.EmployeeDaoImpl;

public class EmployeeServiceImpl implements EmployeeService {
     
	@Autowired
	EmployeeDaoImpl empdao=null;
	
	public List<Map<String, Object>> getEmpByDeg(String[] deg) {
		
		List<Map<String,Object>> degResult=null;
		String con=null;
		
		StringBuffer sb=null;
		
		sb=new StringBuffer("(");
		
		for(int i=0;i<deg.length;i++) {
		    if(i<deg.length-1) {
		    	sb.append("'"+deg[i]+"',");
		    }	
		    else {
		    	sb.append("'"+deg[i]+",)");
		    }
		}
		con=sb.toString();
		
		degResult=empdao.fetchEmp(con);
		
		return degResult;
	}

}
