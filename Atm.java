package atm_Machine;
import java.util.ArrayList;
import java.util.Scanner;

class AtmSystem{
	public double balance;
	public ArrayList<String> transactionHistory;
	public AtmSystem() {
		super();
	}
	public AtmSystem(double balance, ArrayList<String> transactionHistory) {
		super();
		this.balance = balance;
		this.transactionHistory = new ArrayList<>();
	}
	
	public void checkBalance() {
		System.out.println("Current Balance is : $ "+ balance);
	}
	public void depositMoney(double amount) {
		if(amount > 0) {
			balance = balance+amount;
			transactionHistory.add("Deposited amount :$ " +amount);
		
			System.out.println("deposited Succuessfully " + amount);
		}else {
			System.out.println("Invalid amount withdrawn... please enter right value");
		}
	}
	
	public void withdrawMoney(double amount) {
		if(amount >0 && amount <= balance) {
			balance = balance -amount;
			transactionHistory.add("withdrewed amount : $ "+amount);
			System.out.println("withdrawn amount = " +amount);
		}else if (amount > balance) {
			System.out.println("Insufficient balance .. please verify ");
		}else {
			System.out.println("Invalid amount withdrawn .. please enter right value");
		}
	}
	
}
class Atm_Interface extends AtmSystem{
	public  String userPin;
	public Scanner scanner;
	
	public Atm_Interface(double balance, ArrayList<String> transactionHistory, String userPin, Scanner scanner) {
		
		super(balance, transactionHistory);
		this.userPin = userPin;
		this.scanner = new Scanner(System.in) ;
	}
	





	public void start() {
		System.out.println("Welcome to the ATM 😀");
		if(authenticationUser()) {
			System.out.println("Login Sucessfully ");
			while(true) {
				displayMenu();
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					checkBalance();
					break;
				case 2:
					depositMoney();
					break;
				case 3:
					withdrawMoney();
					break;
				case 4:
					viewTransactionHistory();
					break;
				case 5:
					System.out.println(" Thank You ! Have a nice day 🤗");
					return;
				default:
					System.out.println(" Invalid choice ..  Please enter right choice ");
				}
			}
		}else {
			System.out.println("Authentication failed. Exiting to the Home");
		}
		scanner.close();
	}
	public boolean authenticationUser() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the PIN ");
		String enterpin = scanner.next();
		return enterpin.equals(userPin);
		
		
	}
	void displayMenu() {
		System.out.println( " ATM MENU ");
		System.out.println("1. Check Balance ");
		System.out.println("2. Deposit Money ");
		System.out.println("3. Withdraw money ");
		System.out.println("4. View Transaction History ");
		System.out.println("5. Exit ");
		System.out.println(" Enter your choice ");
		
	}
	
	void depositMoney() {
		System.out.println("Enter the amount to deposit : $ ");
		double amount = scanner.nextDouble();
		super.depositMoney(amount);
	}
	void withdrawMoney() {
		System.out.println("Enter the amount to withdraw : $ ");
		double amount = scanner.nextDouble();
		super.withdrawMoney(amount);
	}
	void viewTransactionHistory() {
		System.out.println(" transaction History ");
		if(transactionHistory.isEmpty()) {
			System.out.println("No transaction found ");
		}else {
			for(String transaction : transactionHistory) {
			System.out.println(transaction);
			}
		}
	}
}
public class Atm {

	public static void main(String[] args) {
		Atm_Interface atm = new Atm_Interface(0, null, "2002", null);
	
		atm.start();

	}

}
