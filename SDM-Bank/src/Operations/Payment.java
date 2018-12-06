package Operations;

import Banks.Account1;
import Banks.DebitAccount;

public class Payment implements Operation{

	private int amount;
	private Account1 sender, receiver;
	
	public Payment(int amount,Account1 sender, Account1 receiver){
		this.amount = amount;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	
	@Override
	public boolean execute() {
		
		boolean is_success = false;
		
		if(sender instanceof DebitAccount){

			if(((DebitAccount) sender).getMax_debit() > sender.getBalance()-amount){
				
				
			}else{
				sender.setBalance(sender.getBalance()-amount);
				receiver.setBalance(receiver.getBalance()+amount);
				
				is_success = true;
			}
			
		}else {

			if(sender.getBalance() - amount < 0){
				
			}else{
				sender.setBalance(sender.getBalance()-amount);
				receiver.setBalance(receiver.getBalance()+amount);
				
				is_success = true;
			}
			
		}
		
		receiver.addOperationToAccountHistory(this);
		sender.addOperationToAccountHistory(this);

		return is_success;		
		
	}

}
