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

	Connection connection = null;
	
	public EmployeeDaoImpl() throws ClassNotFoundException, SQLException {
		connection=ConnectionUtils.getMyConnection();
	}
	
	@Override
	public int add(Employee emp) 
	
	{ 
		int n = 0;
		try {
			
		
		    String query = "insert into employee(emp_name, " + "emp_address) VALUES (?, ?)"; 
		    PreparedStatement ps = connection.prepareStatement(query); 
		    ps.setString(1, emp.getEmp_name()); 
		    ps.setString(2, emp.getEmp_address()); 
		    n = ps.executeUpdate(); 
		
		
		}catch(SQLException e){
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
		try {
			  String query  = "delete from employee where emp_id =?"; 
			    PreparedStatement ps  = connection.prepareStatement(query); 
			    ps.setInt(1, id); 
			    ps.executeUpdate(); 

		}catch(SQLException e){
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

		 Employee emp =null;
	
		try {
	    String query  = "select * from employee where emp_id= ?"; 
	    PreparedStatement ps  = connection.prepareStatement(query); 
	
	    ps.setInt(1, id); 
	    
	    emp = new Employee(); 
	    ResultSet rs = ps.executeQuery(); 

	
	    while (rs.next()) { 

	        emp.setEmp_id(rs.getInt("emp_id")); 
	        emp.setEmp_name(rs.getString("emp_name")); 
	        emp.setEmp_address(rs.getString("emp_address")); 
	    } 

		}catch(SQLException e){
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
		 List<Employee> ls;
		try {
		    String query = "select * from employee"; 
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
		}catch(SQLException e){
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
		try {
	    String query = "update employee set emp_name=?, " + " emp_address= ? where emp_id = ?"; 
	    PreparedStatement ps = connection.prepareStatement(query); 
	    ps.setString(1, emp.getEmp_name()); 
	    ps.setString(2, emp.getEmp_address()); 
	    ps.setInt(3, emp.getEmp_id()); 
	    ps.executeUpdate(); 
		}catch(SQLException e){
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
