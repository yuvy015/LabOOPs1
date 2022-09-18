package com.greatlearning.emailapp.main;

import java.util.Scanner;

import com.greatlearning.emailapp.model.Employee;
import com.greatlearning.emailapp.service.CredentialService;
import com.greatlearning.emailapp.service.CredentialServiceImpl;

public class DriverClass {
    public static final String[] depts= {"Technical", "Admin", "Human Resource", "Legal"};
    public static final String[] deptcodes= {"tech", "adm", "hr", "lg"};
	public static void main(String[] args) {
		CredentialService service = new CredentialServiceImpl("gl.in");
		Scanner input = new Scanner(System.in);
		System.out.println("Enter First Name -->");
		String fname = input.next();
		System.out.println("Enter Last Name -->");
		String lname = input.next();
		Employee e = new Employee(fname,lname);
		System.out.println("Please Enter the Department from following -->");
		for(int j=1; j<=depts.length; j++ ) 
			System.out.println(j+". "+depts[j-1]);
		int deptNumber=input.nextInt();
		String emailID=service.generateEmailId(fname, lname, deptcodes[deptNumber-1]);
		e.setEmailId(emailID);
		String password=service.generatePassword();
		e.setPassWord(password);
		service.showcredentials(e);		

	
	}
}
