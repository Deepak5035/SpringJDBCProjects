package com.nt.bo;

public class EmployeeBo {

private int empno;
private String ename;
private double sal;
private String job;
private int deptno;

public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}

@Override
public String toString() {
	return "EmployeeBo [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", job=" + job + ", deptno=" + deptno
			+ "]";
}



}
