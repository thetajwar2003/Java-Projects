package Machine;

import dao.DAOImplementation;

import java.sql.SQLException;
import java.util.*;

import java.io.IOException;
import java.text.DecimalFormat;

public class OptionMenu extends DAOImplementation {
	static String id;
	Scanner sc = new Scanner(System.in);
	//Validate login information
	public void login() throws IOException, SQLException {
		System.out.println("Welcome to your personal ATM!");
		System.out.print("Do you have an account? ");
		String choice = sc.nextLine();
		if (choice.equals("yes")) {
			System.out.print("Please enter your Username: ");
			id = sc.nextLine();

			System.out.print("Please enter your pin number: ");
			int pin = sc.nextInt();
			if(checkUser(id, pin)) getAccountType();
		}
		else{
			System.out.print("Would you like to create one? ");
			if(sc.nextLine().equals("yes")){
				System.out.print("Enter a username: ");
				String username = sc.nextLine();
				id = username;
				System.out.print("Enter your name: ");
				String name = sc.nextLine();
				System.out.print("Enter your SSN with dashes: ");
				String ssn = sc.nextLine();
				System.out.print("Enter a 4 digit pin #: ");
				int pin = sc.nextInt();
				createUser(username, pin, ssn, name);

				getAccountType();
			}
			else{
				System.out.println("Goodbye");
				System.exit(1);
			}
		}
	}

	private void getAccountType() throws SQLException {
		System.out.println("Welcome back " + getName(id) +"! Select the Account you want to access: ");
		System.out.println("Type 1 for Checking Account");
		System.out.println("Type 2 for Savings Account");
		System.out.println("Type 3 to exit");
		System.out.print("Choice: ");
		int choice  = sc.nextInt();
		
		switch(choice) {
		case 1:
			getCheckInfo();
			break;
		case 2:
			getSavingsInfo();
			break;
		case 3:
			System.out.println("Thank you for using the ATM.");
			System.exit(1);
		default:
			System.out.println("Invalid choice");
			getAccountType();
			break;
		}
	}

	private void getSavingsInfo() throws SQLException {
		System.out.println("Your Savings Account: ");
		System.out.println("Type 1 to View Balance");
		System.out.println("Type 2 to Withdraw Money");
		System.out.println("Type 3 to Deposit Money");
		System.out.println("Type 4 to exit");
		System.out.print("Choice: ");
		int choice = sc.nextInt();
		boolean done = false;
		
		switch(choice) {
		case 1:
			System.out.println("Savings Account Balance: " + getSavingBalance(id));
			getSavingsInfo();
			break;
		case 2:
			while(!done) {
				System.out.println("Current Savings Account Balance: " + getSavingBalance(id));
				System.out.println("How much would you like to withdraw: ");
				double amount = sc.nextDouble();

				if ((getSavingBalance(id) - amount) >= 0) {
					savingWithdrawal(id, amount);
					System.out.println("New Savings Account Balance: " + getSavingBalance(id));
					done = true;
				}
				else{
					System.out.println("You can't have a negative balance.");
					getSavingsInfo();
				}
			}
			getSavingsInfo();
			break;
		case 3:
			while(!done){
				System.out.println("Current Savings Account Balance: " + getSavingBalance(id));
				System.out.println("How much would you like to deposit: ");
				double amount = sc.nextDouble();

				if((getSavingBalance(id) + amount) >= 0) {
					savingDeposit(id, amount);
					System.out.println("New Savings Account Balance: " + getSavingBalance(id));
					done = true;
				}
				else{
					System.out.println("You can't have a negative balance.");
					getSavingsInfo();
				}
			}
			getSavingsInfo();
			break;
		case 4:
			System.out.println("Main Menu: ");
			getAccountType();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
	private void getCheckInfo() throws SQLException {
		System.out.println("Your Checkings Account: ");
		System.out.println("Type 1 to View Balance");
		System.out.println("Type 2 to Withdraw Money");
		System.out.println("Type 3 to Deposit Money");
		System.out.println("Type 4 to exit");
		System.out.print("Choice: ");
		int choice = sc.nextInt();
		boolean done = false;
		
		switch(choice) {
		case 1:
			System.out.println("Checking Account Balanace: " + getCheckingBalance(id));
			getCheckInfo();
			break;
		case 2: 
			while(!done){
				System.out.println("Current Checking Account Balance: " + getCheckingBalance(id));
				System.out.println("How much would you like to withdraw: ");
				double amount = sc.nextDouble();

				if((getCheckingBalance(id) - amount) >= 0) {
					checkingWithdrawal(id, amount);
					System.out.println("New Checking Account Balance: " + getCheckingBalance(id));
					done = true;
				}
				else {
					System.out.println("You can't have a negative balance.");
					getCheckInfo();
				}
			}
			getCheckInfo();
			break;
		case 3:
			while(!done){
				System.out.println("Current Checking Account Balance: " + getCheckingBalance(id));
				System.out.println("How much would you like to deposit: ");
				double amount = sc.nextDouble();

				if((getCheckingBalance(id) + amount) >= 0) {
					checkingDeposit(id, amount);
					System.out.println("New Checking Account Balance: " + getCheckingBalance(id));
					done = true;
				}
				else {
					System.out.println("You can't have a negative balance.");
					getCheckInfo();
				}
			}
			getCheckInfo();
			break;
		case 4:
			System.out.println("Main Menu: ");
			getAccountType();
			break;
		default:
			System.out.println("Invalid choice");
			break;
		}
	}
}
