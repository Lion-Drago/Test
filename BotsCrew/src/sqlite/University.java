package sqlite;

import java.util.Scanner;

public class University {

	public static void main(String[] args) {
		System.out.println("1. Who is head of department {department_name} ");
		System.out.println("2. Show {department_name} statistic ");
		System.out.println("3. Show the average salary for department {department_name} ");
		System.out.println("4. Show count of employee for {department_name} ");
		System.out.println("5. Global search by {template} ");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the question number: ");
		int number = sc.nextInt();
		
		if(number >= 1 && number <= 4) {		
			System.out.print("Please, enter department_name: ");
			Scanner sc1 = new Scanner(System.in);
			String dep_name = sc1.nextLine();
			switch(number) {
			case 1: Zapytannya.zapyt1(dep_name); break;
			case 2:	Zapytannya.zapyt2(dep_name); break;			
			case 3: Zapytannya.zapyt3(dep_name); break;
			case 4: Zapytannya.zapyt4(dep_name); break;
			}
			sc1.close();
		} else
		if(number == 5) {
			System.out.print("Global search by ");
			Scanner sc1 = new Scanner(System.in);
			String template = sc1.nextLine();
			Zapytannya.zapyt5(template);
			sc1.close();
		} else
			System.out.println("Please, enter correct number.");
		
		sc.close();
	}

}