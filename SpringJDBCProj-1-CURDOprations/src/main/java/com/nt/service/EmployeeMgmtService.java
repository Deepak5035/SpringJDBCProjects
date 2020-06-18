package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeMgmtService {

 public String EmpCountService();
 public String EmpNameService(int empno);
 public Map<String,Object> EmpDetilsService(int empno);
 public List<Map<String,Object>> EmpDetilsByDeptNoService(int deptno1,int deptno2);
 public String UpdateEmpService(int empno,String ename,double sal,String job,int deptno);
}
