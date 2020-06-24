package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBo;
import com.nt.dao.EmployeeDao;
import com.nt.dto.EmployeeDto;

@Service("empservice")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empdao=null;
	
	public EmployeeDto getEmpDetils(int empno) {
		EmployeeDto dto=null;
		EmployeeBo bo=null;
		
		
		bo=empdao.fetchDetils(empno);
		
		dto=new EmployeeDto();
		
		BeanUtils.copyProperties(bo, dto);
		
		return dto;
	}

}
