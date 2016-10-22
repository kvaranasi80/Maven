package com.fannie.interfaces;

import java.util.List;
import com.fannie.beans.Employee;

//Contract for Employee DAO
public interface IEmployeeDAO {
	
	public boolean insertEmployee(Employee emp);
	public List<Employee> getAllEmployees(); 
	public  Employee getEmployee(int empId);
	public boolean updateEmp(int empId, double newSal); 
	public boolean deleteEmp(int empId);  

}
