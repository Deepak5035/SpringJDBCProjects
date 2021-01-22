package com.nt.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<EmployeeDto> getEmpDetils(String job) {
		
		List<EmployeeBo> listbo=null;
		
		List<EmployeeDto> listdto=new ArrayList<EmployeeDto>();
		
		listbo=empdao.fetchDetils(job);
		
		listbo.forEach(bo->{
		EmployeeDto dto=new EmployeeDto();	
			BeanUtils.copyProperties(bo,dto);
		    listdto.add(dto);
		});
		return listdto;
	}

}
