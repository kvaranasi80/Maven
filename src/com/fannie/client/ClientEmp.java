package com.fannie.client;

import com.fannie.dao.EmployeeDAO;
import com.fannie.interfaces.IEmployeeDAO;

public class ClientEmp {
	public static void main(String[] args) {
		IEmployeeDAO dao = new EmployeeDAO();
		// dao.insertEmployee(new
		// Employee("Kiran",23222,"Kiran@fanniemae.com"));
		System.out.println("The employee shown is " + dao.getEmployee(1));
		
		System.out.println("The Employees in Fannie Mae are " + dao.getAllEmployees());
		//Update Employee DAO 
		dao.updateEmp(3, 999999);
		System.out.println("The employee with updated salary is " + dao.getEmployee(3));
		//Deleing an employee at posi 2 
		
		dao.deleteEmp(2); 
		System.out.println("The employee list after removal is " +  dao.getAllEmployees());
	

	}
}
