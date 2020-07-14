package com.live;

import com.live.model.Employee;
import com.live.repository.OracleRepository;
import com.live.service.EmployeeServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
       
    	EmployeeServiceImpl getempl = new EmployeeServiceImpl();
	
    	System.out.println(getempl.getEmployee());
    	//System.out.println(emp);
    			
    	
    	
    }
}
