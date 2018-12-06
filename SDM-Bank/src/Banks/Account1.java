package Banks;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

import Operations.Operation;
import Operations.OperationHistory;

public class Account1 {
	
	private String owner_name, ID;
	private long opening_date;
	private int balance;
	private OperationHistory account_history;
	private Bank bank;
	
	public Account1(String owner_name, int balance, Bank bank) throws InvalidCreationException{
		if (owner_name.length() ==0 || Pattern.compile( "[0-9]" ).matcher( owner_name ).find()){
			throw new InvalidCreationException("Size of the name must be greater than 0 and must not include numbers");
		}else{
			this.owner_name = owner_name;

		}
		if(balance>0){
			
			this.balance = balance;
			
		}else{
			throw new InvalidCreationException("Negative balance unauthorised");
		}
		this.bank = bank;
		OpenAccount();
	}
	
	private void OpenAccount(){
		
		ID = UUID.randomUUID().toString();
		opening_date = System.currentTimeMillis();
		//System.out.println(ID);
		//System.out.println(new Date(opening_date));
		account_history = new OperationHistory();
	}
	
	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public String getID() {
		return ID;
	}


	public long getOpening_date() {
		return opening_date;
	}


	public OperationHistory getOperationHistory() {
		return account_history;
	}

	
	public void addOperationToAccountHistory(Operation operation) {
		account_history.AddOperationToHistory(operation);
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getBalance(){
		return balance;
	}
	
}








