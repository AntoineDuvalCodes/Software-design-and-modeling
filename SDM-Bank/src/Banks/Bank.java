package Banks;

import java.util.ArrayList;
import java.util.UUID;

import Accounts.Account;
import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Operations.OperationHistory;

public class Bank {

	private String name, ID;
	private int balance;
	private ArrayList<Account> accounts;
	private ArrayList<OperationHistory> operation_history;
	
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
		operation_history = new ArrayList<>();

	}

	public void createBasicAccount(String name, int balance) throws InvalidCreationException{
		BasicAccount account = new BasicAccount(name, balance, this);
		accounts.add(account);
	}
	public void createDebitAccount(String name, int balance, int debit, int maxDebit) throws InvalidCreationException{
		BasicAccount account = new BasicAccount(name, balance, this);
		DebitAccount debitAccount = new DebitAccount(account,maxDebit, debit);
		accounts.add(debitAccount);
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



	public ArrayList<Account> getAccounts() {
		return accounts;
	}


	public void addAccounts(Account account) {
		accounts.add(account);
	}


	public ArrayList<OperationHistory> getOperation_history() {
		return operation_history;
	}


	public void addOperationHistory(OperationHistory operation) {
		operation_history.add(operation);
	}
	
	
}
