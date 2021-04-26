package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;


public class EmployeeDaoImpl implements EmployeeDao { 

	Connection connection = null;
	
	@Override
	public int add(Employee emp) throws SQLException 
	
	{ 
		int n = 0;
		try {
			connection=ConnectionUtils.getMyConnection();
		
		    String query = "insert into employee(emp_name, " + "emp_address) VALUES (?, ?)"; 
		    PreparedStatement ps = connection.prepareStatement(query); 
		    ps.setString(1, emp.getEmp_name()); 
		    ps.setString(2, emp.getEmp_address()); 
		    n = ps.executeUpdate(); 
		
		
		
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Connection fail");
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
	public void delete(int id)   throws SQLException 
	{ 
	    String query  = "delete from employee where emp_id =?"; 
	    PreparedStatement ps  = connection.prepareStatement(query); 
	    ps.setInt(1, id); 
	    ps.executeUpdate(); 
	} 
	
	@Override
	public Employee getEmployee(int id)    throws SQLException 
	{ 
	
	    String query  = "select * from employee where emp_id= ?"; 
	    PreparedStatement ps  = connection.prepareStatement(query); 
	
	    ps.setInt(1, id); 
	    Employee emp = new Employee(); 
	    ResultSet rs = ps.executeQuery(); 
	    boolean check = false; 
	
	    while (rs.next()) { 
	        check = true; 
	        emp.setEmp_id(rs.getInt("emp_id")); 
	        emp.setEmp_name(rs.getString("emp_name")); 
	        emp.setEmp_address(rs.getString("emp_address")); 
	    } 
	
	    if (check == true) { 
	        return emp; 
	    } 
	    else
	        return null; 
	} 
	
	@Override
	public List<Employee> getEmployees()  throws SQLException 
	{ 
	    String query = "select * from employee"; 
	    PreparedStatement ps  = connection.prepareStatement(query); 
	    ResultSet rs = ps.executeQuery(); 
	    List<Employee> ls = new ArrayList(); 
	
	    while (rs.next()) { 
	        Employee emp = new Employee(); 
	        emp.setEmp_id(rs.getInt("emp_id")); 
	        emp.setEmp_name(rs.getString("emp_name")); 
	        emp.setEmp_address(rs.getString("emp_address")); 
	        ls.add(emp); 
	    } 
	    return ls; 
	} 
	
	@Override
	public void update(Employee emp)  throws SQLException 
	{ 
	
	    String query = "update employee set emp_name=?, " + " emp_address= ? where emp_id = ?"; 
	    PreparedStatement ps = connection.prepareStatement(query); 
	    ps.setString(1, emp.getEmp_name()); 
	    ps.setString(2, emp.getEmp_address()); 
	    ps.setInt(3, emp.getEmp_id()); 
	    ps.executeUpdate(); 
	} 
} 
