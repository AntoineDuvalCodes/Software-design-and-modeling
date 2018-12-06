package Banks;

import java.util.ArrayList;
import java.util.UUID;

import Operations.Operation;
import Operations.OperationHistory;

public class Bank {

	private String name, ID;
	private int balance;
	private ArrayList<Account1> accounts;
	private OperationHistory operation_history;
	
	public Bank(String name, int bank_balance) throws InvalidCreationException{
		if(name.length()==0){
			throw new InvalidCreationException("Bank name lenght must be greater than 0");
		}else{
			this.name = name;

		}
		this.balance = bank_balance;
		CreateBank();
	}
	
	
	private void CreateBank(){

		ID = UUID.randomUUID().toString();
		accounts = new ArrayList<>();
		operation_history = new OperationHistory();

	}

	public void createAccount(String name, int balance) throws InvalidCreationException{
		Account1 account = new Account1(name, balance, this);
		accounts.add(account);
	}
	
	public void CreateDebitAccount(String name, int balance){
		
	}
	public String getName() {
		return name;
	}


	public String getID() {
		return ID;
	}



	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}



	public ArrayList<Account1> getAccounts() {
		return accounts;
	}


	public void addAccounts(Account1 account) {
		accounts.add(account);
	}


	public OperationHistory getOperation_history() {
		return operation_history;
	}


	public void addOperationHistory(Operation operation) {
		operation_history.AddOperationToHistory(operation);
	}
	
	
}
