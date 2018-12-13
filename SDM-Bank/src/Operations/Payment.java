package Operations;

import Accounts.Account;
import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Accounts.DepositAccount;
import Accounts.LoanAccount;

public class Payment implements Operation{

	private int amount;
	private Account sender, receiver;
	
	public Payment(int amount,Account sender, Account receiver){
		this.amount = amount;
		this.sender = sender;
		this.receiver = receiver;
	}
	
	
	@Override
	public boolean execute() {
		
		boolean is_success = false;
		
		if(sender instanceof DebitAccount && -((DebitAccount) sender).getMaxDebit() <= sender.getBalance()-((DebitAccount) sender).getDebit()-amount){
			is_success = true;
			PayWithDebitAccount((DebitAccount) sender);
		}else if (sender instanceof BasicAccount && amount <= sender.getBalance()){
			PayWithBasicAccount((BasicAccount) sender);
			is_success = true;
		}else if(sender instanceof DepositAccount){
			PayWithDepositAccount((DepositAccount) sender);
			is_success = true;
		}else if (sender instanceof LoanAccount && amount <= sender.getBalance()){
			PayWithLoanAccount((LoanAccount) sender);
			is_success = true;
		}
		else{
			sender.addOperationToAccountHistory(new OperationHistory(sender.getBank(),false, amount,OperationHistory.TYPE_SEND_PAYMENT,"Unknown Account type"));
			if(receiver != null)
			receiver.addOperationToAccountHistory(new OperationHistory(receiver.getBank(),false,amount, OperationHistory.TYPE_SEND_PAYMENT,"Unknown Account type"));

			return false;
		}

		
		
		if(receiver instanceof DebitAccount){
			GetPaymentDebitAccount((DebitAccount) receiver);
		}else if (receiver instanceof BasicAccount){
			GetWithBasicAccount((BasicAccount) receiver);
		}else if (receiver instanceof DepositAccount){
			GetWithDepositAccount((DepositAccount)receiver);
		}
		sender.addOperationToAccountHistory(new OperationHistory(sender.getBank(),true, amount,OperationHistory.TYPE_SEND_PAYMENT,""));
		if(receiver != null)
		receiver.addOperationToAccountHistory(new OperationHistory(receiver.getBank(),true, amount,OperationHistory.TYPE_SEND_PAYMENT,""));

		return is_success;		
		
	}

	private void PayWithDebitAccount(DebitAccount account){//sending ,oney to another account
		
		if(account.getBalance() == 0){
			int deb = account.getDebit()+amount;
			account.setDebit(deb);
		}else{
			int bal = account.getBalance();
			bal -= amount;
			if(bal < 0){
				account.setBalance(0);
				account.setDebit(-bal);
			}else account.setBalance(bal);
		}
		}
	private void GetPaymentDebitAccount(DebitAccount account){//receiving money for another account
		if(account.getDebit()>0){
				
				amount -= account.getDebit();
				if(amount>=0){
					account.setDebit(0);
					account.setBalance(amount);
					
				}else{
					account.setDebit(account.getDebit()+amount);

				}
				
			}else{
				account.setBalance(account.getBalance()+amount);
			}
		}
	private void PayWithBasicAccount(BasicAccount account){
			int bal = account.getBalance();
			account.setBalance(bal -= amount);
		}
	private void PayWithDepositAccount(DepositAccount account){
			int bal = account.getBalance();
			account.setBalance(bal -= amount);
		}
	private void PayWithLoanAccount(LoanAccount account){
			int bal = account.getBalance();
			account.setBalance(bal -= amount);
		}
	private void GetWithBasicAccount(BasicAccount account){
			int bal = account.getBalance();
			account.setBalance(bal += amount);
		}
	private void GetWithDepositAccount(DepositAccount account){
			int bal = account.getBalance();
			account.setBalance(bal += amount);
		}
		
}
