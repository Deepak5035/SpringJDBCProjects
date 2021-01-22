package com.nt.test;

import java.util.List;

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
		
		
		List<EmployeeDto> listdto=empservice.getEmpDetils("CLERK");
		
		/*
		 * listdto.forEach(dto->{ System.out.println(listdto.toString()); });
		 */
		
		/*
		 * listdto.stream().forEach(dto->{ System.out.println(listdto.toString()); });
		 */
		
		listdto.forEach(System.out::println);
		
		
		
		((AbstractApplicationContext) ctx).close();
	}
	
	
	
}
