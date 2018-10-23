package Bank_system;

import java.util.Date;
import java.util.UUID;

public class Account {
	
	private String owner_name, ID;
	private long opening_date;
	private Double balance;
	private OperationHistory account_history;
	
	
	public Account(String owner_name, Double balance){
		this.owner_name = owner_name;
		if(balance>0){
			this.balance = balance;
		}else{
			this.balance = 0.0;
		}
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

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getBalance(){
		return balance;
	}
	
}








