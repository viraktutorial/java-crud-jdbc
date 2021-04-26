package view;

import java.sql.SQLException;
import java.util.List;

import controller.EmployeeDaoImpl;
import model.Employee;


public class Application { 
	  
    public static void main(String[] args) throws SQLException, ClassNotFoundException 
    { 
  
        Employee emp = new Employee(); 
        emp.setEmp_name("Dara"); 
        emp.setEmp_address("PP"); 
        EmployeeDaoImpl empDao = new EmployeeDaoImpl(); 
  
        // add 
        empDao.add(emp); 
  
        // read 
        Employee e = empDao.getEmployee(2); 
        System.out.println(e.getEmp_id() + " "
                           + e.getEmp_name() + " "
                           + e.getEmp_address()); 
  
        // read All 
        List<Employee> ls = empDao.getEmployees(); 
        for (Employee allEmp : ls) { 
            System.out.println(allEmp); 
        } 
  
        // update 
        Employee tempEmployee = empDao.getEmployee(1); 
        tempEmployee.setEmp_address("Asgard"); 
        empDao.update(tempEmployee); 
  
        // delete 
        //empDao.delete(1); 
    } 
} 
