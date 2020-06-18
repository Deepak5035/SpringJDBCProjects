package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {

public int getEmpCount();
public String getEmpName(int empno);
public Map<String,Object> getEmpDetails(int empno);
public List<Map<String,Object>> getEmpDetailsByDeptNo(int deptno1,int deptno2);
public int updateEmp(int empno,String ename,double sal,String job,int deptno);
}
