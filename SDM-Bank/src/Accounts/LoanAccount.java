package Accounts;

import Banks.InvalidCreationException;
import Operations.InterestRate;
import Operations.OperationExecutor;
import Operations.OperationHistory;
import Operations.Payment;

public class LoanAccount extends Account{
	
	Account main_account;
	int loan_amount_initial;
	boolean isClosed;
	
	public LoanAccount(Account main_account, int loan_amount_initial){
		this.main_account = main_account;
		setBalance(loan_amount_initial);
		this.loan_amount_initial= loan_amount_initial;
		openAccount(main_account.getBank());
		setBank(main_account.getBank());
		this.isClosed =  false;
		addOperationToAccountHistory(new OperationHistory(getBank(),true, this,OperationHistory.TYPE_OPEN_LOAN_ACCOUNT,""));

	}
	
	public void closeLoanAccount() throws InvalidCreationException{
		InterestRate interestCalculator = new InterestRate(this);
		int interest = interestCalculator.calculateInterest();
		
		OperationExecutor opp = new OperationExecutor();
		if(!opp.executePayment(new Payment(loan_amount_initial+interest-getBalance(),main_account,null))){
			addOperationToAccountHistory(new OperationHistory(getBank(),false, this,OperationHistory.TYPE_CLOSE_LOAN_ACCOUNT,"Your main account cannot refund the bank for the moment"));
			throw new InvalidCreationException("Your main account cannot refund the bank for the moment");
		}
		isClosed = true;
		addOperationToAccountHistory(new OperationHistory(getBank(),true, this,OperationHistory.TYPE_CLOSE_LOAN_ACCOUNT,""));

	}
	public void transfertToMainAccount(int amount) throws InvalidCreationException{
		OperationExecutor opp = new OperationExecutor();
		if(!opp.executePayment(new Payment(amount,this,main_account))){
			addOperationToAccountHistory(new OperationHistory(getBank(),false, this,OperationHistory.TYPE_TRANSFERT_LOAN_ACCOUNT,"Your loan account balance is not sufficient"));
			throw new InvalidCreationException("Your loan account balance is not sufficient");
		}
		addOperationToAccountHistory(new OperationHistory(getBank(),true, this,OperationHistory.TYPE_TRANSFERT_LOAN_ACCOUNT,""));

		
	}
	
	
	
	
	

}
