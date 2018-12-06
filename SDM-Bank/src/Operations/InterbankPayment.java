package Operations;

import Banks.Account1;
import Banks.Bank;
import Banks.CentralBank;

public class InterbankPayment implements Operation {

	private int amount;
	private Account1 account_sender, account_receiver;
	private Bank bank_sender, bank_receiver;
	private CentralBank central_bank;
	
	public InterbankPayment(CentralBank central_bank,Bank bank_sender, Bank bank_receiver, Account1 account_sender, Account1 account_receiver, int amount){
		this.bank_sender = bank_sender;
		this.bank_receiver = bank_receiver;
		this.account_sender = account_sender;
		this.account_receiver = account_receiver;
		this.amount = amount;
		this.central_bank = central_bank;
	}
	
	
	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		boolean isSuccess = false;
		
		if (central_bank.getBanks().contains(bank_receiver)){
			
			if (bank_receiver.getAccounts().contains(account_receiver)){
				
				OperationExecutor opp = new OperationExecutor();
				isSuccess = opp.executePayment(new Payment(amount,account_sender,account_receiver));
			}
		}
		
		return isSuccess;
	}

}
