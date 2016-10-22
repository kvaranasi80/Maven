package com.fannie.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fannie.beans.Employee;
import com.fannie.connection.GetConnection;
import com.fannie.interfaces.IEmployeeDAO;

public class EmployeeDAO implements IEmployeeDAO {

	@Override
	public boolean insertEmployee(Employee emp) {
		String sql = "insert into employee(Emp_name,Emp_sal,Emp_email) values(?,?,?)";
		GetConnection gconn = new GetConnection();
		try {
			gconn.ps = GetConnection.mysqlCon().prepareStatement(sql);
			gconn.ps.setString(1, emp.getEmpName());
			gconn.ps.setDouble(2, emp.getEmpSal());
			gconn.ps.setString(3, emp.getEmpEmail());

			return gconn.ps.executeUpdate() > 0;
		} catch (SQLException e) {
			try {
				GetConnection.mysqlCon().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				GetConnection.mysqlCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		String sql = "select * from employee";
		GetConnection gconn = new GetConnection();
		List<Employee> empList = new ArrayList<>();
		try {
			gconn.ps = GetConnection.mysqlCon().prepareStatement(sql);
			gconn.rs = gconn.ps.executeQuery();
			while (gconn.rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(gconn.rs.getInt(1));
				emp.setEmpName(gconn.rs.getString(2));
				emp.setEmpSal(gconn.rs.getDouble(3));
				emp.setEmpEmail(gconn.rs.getString(4));
				empList.add(emp);
			}

			return empList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				GetConnection.mysqlCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Employee getEmployee(int empId) {

		String sql = "select * from employee where Emp_Id = ?";

		GetConnection gc = new GetConnection();
		try {
			gc.ps = GetConnection.mysqlCon().prepareStatement(sql);

			gc.ps.setInt(1, empId);

			gc.rs = gc.ps.executeQuery();

			if (gc.rs.next()) {
				Employee temp = new Employee();
				temp.setEmpId(gc.rs.getInt(1));
				temp.setEmpName(gc.rs.getString(2));
				temp.setEmpSal(gc.rs.getDouble(3));
				temp.setEmpEmail(gc.rs.getString(4));
				return temp;
			}
		} catch (SQLException e) {
			try {
				GetConnection.mysqlCon().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				GetConnection.mysqlCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@SuppressWarnings("static-access")
	@Override
	public boolean updateEmp(int empId, double newSal) {
		String sql = "update employee set Emp_sal = ? where Emp_Id = ?";
		GetConnection gconn = new GetConnection();
		try {
			gconn.ps = gconn.mysqlCon().prepareStatement(sql);
			gconn.ps.setInt(2, empId);
			gconn.ps.setDouble(1, newSal);
			return gconn.ps.executeUpdate() > 0;
		} catch (SQLException e) {
			try {
				GetConnection.mysqlCon().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				GetConnection.mysqlCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteEmp(int empId) {
		String sql = "delete from employee where Emp_Id = ?";
		GetConnection gconn = new GetConnection();
		try {
			gconn.ps = GetConnection.mysqlCon().prepareStatement(sql);
			gconn.ps.setInt(1, empId);
			return gconn.ps.executeUpdate() > 0;
			//GetConnection.mysqlCon().setAutoCommit(true);
		} catch (SQLException e) {
			try {
				GetConnection.mysqlCon().rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				GetConnection.mysqlCon().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return false;
	}

}
