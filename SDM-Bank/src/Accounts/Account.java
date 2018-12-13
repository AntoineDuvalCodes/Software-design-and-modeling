package Accounts;

import java.util.UUID;

import Banks.Bank;
import Operations.InterestRate;
import Operations.OperationHistory;

public abstract class Account {
	private String owner_name, ID;
	private long opening_date;
	private int balance;
	private long last_interest_date;
	private OperationHistory account_history;
	private Bank bank;	
	
	public void openAccount(Bank bank){
		setBank(bank);
		setId(UUID.randomUUID().toString());
		setOpeningDate(System.currentTimeMillis());
		setLast_interest_date(System.currentTimeMillis());

	};
	
	public void getInterest() {
		InterestRate interest = new InterestRate(this);
		setBalance(balance += interest.calculateInterest());
		
	}


	public long getLast_interest_date() {
		return last_interest_date;
	}

	public void setLast_interest_date(long last_interest_date) {
		this.last_interest_date = last_interest_date;
	}
	
	
	public String getOwnerName(){
		return owner_name;
	};
	
	public void setOwnerName(String owner_name){
		this.owner_name = owner_name;
	};
	
	public int getBalance(){
		return balance;
	};
	
	public void setBalance(int balance){
		this.balance = balance;
	};
	
	public String getId(){
		return ID;
	};
	
	private void setId(String ID){
		this.ID = ID;
	}
	public void setBank(Bank bank){
		this.bank = bank;
	}
	public Bank getBank(){
		return bank;
	}
	public long getOpeningDate(){
		return opening_date;
	};
	protected void setOpeningDate(long opening_date){
		this.opening_date = opening_date;
	}
	
	public OperationHistory getOperationHistory(){
		return account_history;
	};
	
	public void addOperationToAccountHistory(OperationHistory operation){
		getBank().addOperationHistory(operation);
	};
	
}
