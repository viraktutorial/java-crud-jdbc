package view;

import java.sql.SQLException;
import java.util.List;

import controller.EmployeeDaoImpl;
import model.Employee;


public class Application { 
	  
    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    { 
  
        EmployeeSystem empSystem=new EmployeeSystem();
        empSystem.run();
    } 
} 
