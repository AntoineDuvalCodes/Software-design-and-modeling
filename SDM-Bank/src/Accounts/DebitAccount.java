package Accounts;

import Banks.InvalidCreationException;
import Operations.OperationHistory;

public class DebitAccount extends AccountDecorator{

	int maxDebit, debit;

	public DebitAccount(Account account, int maxDebit, int debit) throws InvalidCreationException{
		if(account.getBalance()>0 && debit>0 || maxDebit<debit){
			throw new InvalidCreationException("To enter debit balance should be 0 or maxdebit>debit");

		}
		setMaxDebit(maxDebit);
		setDebit(debit);
		openAccount(account.getBank());
		addOperationToAccountHistory(new OperationHistory(getBank(),true, this,OperationHistory.TYPE_OPEN_DEBIT_ACCOUNT,""));

	}

	@Override
	public void setMaxDebit(int maxDebit) {
		// TODO Auto-generated method stub
		this.maxDebit = maxDebit;
	}

	@Override
	public void setDebit(int debit) {
		// TODO Auto-generated method stub
			this.debit = debit;
		
	}

	@Override
	public int getMaxDebit() {
		// TODO Auto-generated method stub
		return maxDebit;
	}

	@Override
	public int getDebit() {
		// TODO Auto-generated method stub
		return debit;
	}
	
	
	
	
	
}
