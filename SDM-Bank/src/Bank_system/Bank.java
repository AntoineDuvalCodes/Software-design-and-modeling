package Bank_system;

import java.util.ArrayList;
import java.util.UUID;

public class Bank {

	private String name, ID;
	private Double balance, max_debit;
	private ArrayList<Account> accounts;
	private OperationHistory operation_history;
	
	public Bank(String name, Double balance){
		this.name = name;
		this.balance = balance;
		CreateBank();
	}
	
	
	private void CreateBank(){
		max_debit = -5000.0;
		ID = UUID.randomUUID().toString();
		accounts = new ArrayList<>();
		operation_history = new OperationHistory();

	}


	public String getName() {
		return name;
	}


	public String getID() {
		return ID;
	}



	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public Double getMax_debit() {
		return max_debit;
	}



	public ArrayList<Account> getAccounts() {
		return accounts;
	}


	public void addAccounts(Account account) {
		accounts.add(account);
	}


	public OperationHistory getOperation_history() {
		return operation_history;
	}


	public void addOperationHistory(Operation operation) {
		operation_history.AddOperationToHistory(operation);
	}
	
	
}
