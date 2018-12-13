package Accounts;

import Banks.InvalidCreationException;
import Operations.InterestRate;
import Operations.OperationExecutor;
import Operations.OperationHistory;
import Operations.Payment;

public class DepositAccount extends Account{

	private Account main_account;
	public boolean isClosed;
	
	
	public DepositAccount(Account main_account, int deposit_amount) throws InvalidCreationException{
		OperationExecutor opp = new OperationExecutor();
		setBank(main_account.getBank());
		if(!opp.executePayment(new Payment(deposit_amount,main_account,this))){
			throw new InvalidCreationException("Deposit balance greater than original account balance");
		}
		
		this.main_account = main_account;
		openAccount(main_account.getBank());
		this.isClosed =  false;
		addOperationToAccountHistory(new OperationHistory(main_account.getBank(),true, this,OperationHistory.TYPE_OPEN_DEBIT_ACCOUNT,""));

	}

	
	public void closeDepositAccount(){
		InterestRate interestCalculator = new InterestRate(this);
		int interest = interestCalculator.calculateInterest();
		
		OperationExecutor opp = new OperationExecutor();
		opp.executePayment(new Payment(this.getBalance()+interest,this,main_account));
		isClosed = true;
		addOperationToAccountHistory(new OperationHistory(getBank(),true, this,OperationHistory.TYPE_CLOSE_DEPOSIT_ACCOUNT,""));

	}
	
}
