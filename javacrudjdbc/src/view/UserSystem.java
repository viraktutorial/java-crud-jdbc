package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.UserDaoImpl;
import model.User;

public class UserSystem {

	UserDaoImpl userDAO;
	
	public UserSystem() {
		userDAO=new UserDaoImpl();
	}
	
	public void run() {
		
		while (true) {
			System.out.println("\n**** User Management SYSTEM  ****\n");
			System.out.println("\n Menu\n");
			System.out.println("1. Add User:            ");
			System.out.println("2. List all Users:      ");
			System.out.println("3. Update User:         ");
			System.out.println("4. Delete User:    	    ");
			System.out.println("5. Search specific User:");
			System.out.println("6. Sort All Users:      ");
			System.out.println("7. Exit Program:            ");
			System.out.println("\n Enter your choice:");
			Scanner sc= new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					
					break;
				case 2:
					
					break;
				case 3:
				
					break;
				case 4:
				
					break;
				case 5:
					System.out.println(userDAO.getUser(101));
					break;
				case 6:
				    
					break;
				case 7:
					System.out.println("System exit, Thank you");
					sc.close(); 
					return;

			}

		}
	}
}
