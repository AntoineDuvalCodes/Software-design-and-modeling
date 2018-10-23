package Bank_system;

public class Operation {

	private String type, description;
	private long execution_date;
	private Account receiver, sender;
	
	public Operation(String description, Account receiver, Account sender){
		
		this.description = description;
		this.receiver = receiver;
		this.sender = sender;
		execution_date = System.currentTimeMillis();
		
	}
	
	

	public boolean payment (Double amount){
		
		boolean is_success = false;
		
		if(sender instanceof DebitAccount){

			if(((DebitAccount) sender).getMax_debit() > sender.getBalance()-amount){
				type = "failed_payment";
				
			}else{
				sender.setBalance(sender.getBalance()-amount);
				receiver.setBalance(receiver.getBalance()+amount);
				type = "payment";
				is_success = true;
			}
			
		}else {

			if(sender.getBalance() - amount < 0){
				type = "failed_payment";
			}else{
				sender.setBalance(sender.getBalance()-amount);
				receiver.setBalance(receiver.getBalance()+amount);
				type = "payment";
				is_success = true;
			}
			
		}
		receiver.addOperationToAccountHistory(this);
		sender.addOperationToAccountHistory(this);

		return is_success;

	}
	
	public String getType() {
		return type;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getExecution_date() {
		return execution_date;
	}



	public Account getReceiver() {
		return receiver;
	}

	public void setReceiver(Account receiver) {
		this.receiver = receiver;
	}

	public Account getSender() {
		return sender;
	}

	public void setSender(Account sender) {
		this.sender = sender;
	}
	
}
