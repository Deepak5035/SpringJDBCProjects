package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeService;

public class Client {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService empservice=null;
		
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		empservice=ctx.getBean("empservice",EmployeeService.class);
		
		
		EmployeeDto dto=empservice.getEmpDetils(7499);
		
		System.out.println(dto.toString());
		
		((AbstractApplicationContext) ctx).close();
	}
	
	
	
}
