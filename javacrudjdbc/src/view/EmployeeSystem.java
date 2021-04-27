package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.EmployeeDaoImpl;
import model.Employee;

public class EmployeeSystem {
	
	EmployeeDaoImpl empDAO;
	
	public EmployeeSystem() {
		empDAO=new EmployeeDaoImpl();
	}
	
	public void run() {
		
		while (true) {
			System.out.println("\n**** Employee Management SYSTEM  ****\n");
			System.out.println("\n Menu\n");
			System.out.println("1. Add employee:            ");
			System.out.println("2. List all employees:      ");
			System.out.println("3. Update employee:         ");
			System.out.println("4. Delete employee:    	    ");
			System.out.println("5. Search specific employee:");
			System.out.println("6. Sort All Employees:      ");
			System.out.println("7. Exit Program:            ");
			System.out.println("\n Enter your choice:");
			Scanner sc= new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					empDAO.add(new Employee("Dara", "PP"));
					break;
				case 2:
					List<Employee> employeeList=new ArrayList<Employee>();
					employeeList= empDAO.getEmployees();
					employeeList.forEach((e) -> {
					      System.out.print(e + "\n ");
				    });
					break;
				case 3:
					empDAO.update(new Employee("Dara", "PP"));
					break;
				case 4:
					empDAO.delete(101);
					break;
				case 5:
					System.out.println(empDAO.getEmployee(101));
					break;
				case 6:
				      List<Employee> employees=new ArrayList<Employee>();
				      employees= empDAO.getEmployees();
				      employees.sort((Employee e1, Employee e2)->e1.getEmp_id()-e2.getEmp_id()); 
				      employees.forEach((s)->System.out.println(s)); 
					break;
				case 7:
					System.out.println("System exit, Thank you");
					sc.close(); 
					return;

			}

		}
	}

}
