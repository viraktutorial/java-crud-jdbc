package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.ConnectionUtils;


public class EmployeeDaoImpl implements EmployeeDao { 

	
	@Override
	public int add(Employee emp) 
	
	{ Connection connection = null;
		
		int n = 0;
		try {
			connection=ConnectionUtils.getMyConnection();
		
		    String query = "insert into employees(emp_name, " + "emp_address) VALUES (?, ?)"; 
		    PreparedStatement ps = connection.prepareStatement(query); 
		    ps.setString(1, emp.getEmp_name()); 
		    ps.setString(2, emp.getEmp_address()); 
		    n = ps.executeUpdate(); 
		
		
		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	    return n; 
	} 
	
	@Override
	public void delete(int id)   {
		Connection connection = null;
		
		try {
			connection=ConnectionUtils.getMyConnection();
			  String query  = "delete from employees where emp_id =?"; 
			    PreparedStatement ps  = connection.prepareStatement(query); 
			    ps.setInt(1, id); 
			    ps.executeUpdate(); 

		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	  
	} 
	
	@Override
	public Employee getEmployee(int id)  
	{ 

		 Connection connection = null;
		 Employee emp =null;
	
		try {
		connection=ConnectionUtils.getMyConnection();
	    String query  = "select * from employees where emp_id= ?"; 
	    PreparedStatement ps  = connection.prepareStatement(query); 
	
	    ps.setInt(1, id); 
	    
	    emp = new Employee(); 
	    ResultSet rs = ps.executeQuery(); 

	
	    while (rs.next()) { 

	        emp.setEmp_id(rs.getInt("emp_id")); 
	        emp.setEmp_name(rs.getString("emp_name")); 
	        emp.setEmp_address(rs.getString("emp_address")); 
	    } 

		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return emp; 
	} 
	
	@Override
	public List<Employee> getEmployees() 
	{ 
		Connection connection = null;
		 List<Employee> ls;
		try {
			connection=ConnectionUtils.getMyConnection();
		    String query = "select * from employees"; 
		    PreparedStatement ps  = connection.prepareStatement(query); 
		    ResultSet rs = ps.executeQuery(); 
		    ls = new ArrayList<Employee>(); 
		
		    while (rs.next()) { 
		        Employee emp = new Employee(); 
		        emp.setEmp_id(rs.getInt("emp_id")); 
		        emp.setEmp_name(rs.getString("emp_name")); 
		        emp.setEmp_address(rs.getString("emp_address")); 
		        ls.add(emp); 
		    }
		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	    return ls; 
	} 
	
	@Override
	public void update(Employee emp)  
	{ 
		Connection connection = null;
		try {
		connection=ConnectionUtils.getMyConnection();
	    String query = "update employees set emp_name=?, " + " emp_address= ? where emp_id = ?"; 
	    PreparedStatement ps = connection.prepareStatement(query); 
	    ps.setString(1, emp.getEmp_name()); 
	    ps.setString(2, emp.getEmp_address()); 
	    ps.setInt(3, emp.getEmp_id()); 
	    ps.executeUpdate(); 
		}catch(SQLException | ClassNotFoundException e){
			throw new RuntimeException(e);
		}finally {
			try {
				if(connection!=null) {
					connection.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	} 
} 
