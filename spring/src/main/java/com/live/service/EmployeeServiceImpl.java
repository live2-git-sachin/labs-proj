package com.live.service;

import java.util.List;

import com.live.model.Employee;
import com.live.repository.OracleRepository;


public class EmployeeServiceImpl implements EmployeeService {


	@Override
	public List<Employee> getEmployee() {

		OracleRepository dbOrc= new OracleRepository();
		return dbOrc.getEmployees();
	}

	
	
	
}


