package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmpolyeeDao {
	
	public List<Map<String,Object>> fetchEmp(String con);

}
