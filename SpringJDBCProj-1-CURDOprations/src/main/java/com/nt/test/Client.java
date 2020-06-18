package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeMgmtService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService serviceResult=null;
		
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
	    serviceResult=ctx.getBean("ems",EmployeeMgmtService.class);
		
	    System.out.println(serviceResult.EmpCountService());
	    System.out.println("Emp Name is"+serviceResult.EmpNameService(7499));
		System.out.println("Emp Details is"+serviceResult.EmpDetilsService(7499));
		System.out.println("Emp Details By DeptoNO"+serviceResult.EmpDetilsByDeptNoService(20,30));
		System.out.println(serviceResult.UpdateEmpService(4231, "ravi",1000, "teacher", 20));
		((AbstractApplicationContext) ctx).close();	
		
	}
	
	
}
