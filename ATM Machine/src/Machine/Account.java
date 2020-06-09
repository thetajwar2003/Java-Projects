package Machine;
import java.util.*;
import java.text.DecimalFormat;
public class Account {
	private int custNum, pinNum, checkBalance, saveBalance;
	Scanner sc = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("$###,##0.00");
	
	//Set and get customer number
	public void setCustNum(int cn) {
		custNum = cn;
	}
	public int getCustNum() {
		return custNum;
	}
	
	//Set and get pin number
	public void setPin(int pin) {
		pinNum = pin;
	}
	public int getPin() {
		return pinNum;
	}
	
	//Get Checking amount
	public int getCheck() {
		return checkBalance;
	}
	
	//Get Savings amount
	public int getSavings() {
		return saveBalance;
	}
	
	
	//Return balances for withdrawals of both checking and savings account
	public double checkingWithdrawal(double amount) {
		checkBalance -= amount;
		return checkBalance;
	}
	public double savingsWithdrawal(double amount) {
		saveBalance -= amount;
		return saveBalance;
	}
	
	//Withdrawal String methods
	public void getCheckingWithdrawal() {
		System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkBalance));
		System.out.println("How much would you like to withdraw: ");
		double amount = sc.nextDouble();
		
		if((checkBalance - amount) >= 0) {
			checkingWithdrawal(amount);
			System.out.println("New Checking Acount Balance: " + moneyFormat.format(checkBalance));
		}
		else System.out.println("You can't have a negative balance.");
	}
	public void getSavingWithdrawal() {
		System.out.println("Current Savings Account Balance: " + moneyFormat.format(saveBalance));
		System.out.println("How much would you like to withdraw: ");
		double amount = sc.nextDouble();
		
		if((saveBalance - amount) >= 0) {
			savingsWithdrawal(amount);
			System.out.println("New Savings Acount Balance: " + moneyFormat.format(saveBalance));
		}
		else System.out.println("You can't have a negative balance.");
	}
	
	
	//Return deposits for both checking and savings account
	public double checkingDeposit(double amount) {
		checkBalance += amount;
		return checkBalance;
	}
	public double savingsDeposit(double amount) {
		saveBalance += amount;
		return saveBalance;
	}

	//Deposit String methods
	public void getCheckingDeposit() {
		System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkBalance));
		System.out.println("How much would you like to deposit: ");
		double amount = sc.nextDouble();

		if((checkBalance + amount) >= 0) {
			checkingDeposit(amount);
			System.out.println("New Checking Acount Balance: " + moneyFormat.format(checkBalance));
		}
		else System.out.println("You can't have a negative balance.");
	}
	public void getSavingDeposit() {
		System.out.println("Current Savings Account Balance: " + moneyFormat.format(saveBalance));
		System.out.println("How much would you like to deposit: ");
		double amount = sc.nextDouble();

		if((saveBalance + amount) >= 0) {
			savingsDeposit(amount);
			System.out.println("New Savings Acount Balance: " + moneyFormat.format(saveBalance));
		}
		else System.out.println("You can't have a negative balance.");
	}
}
