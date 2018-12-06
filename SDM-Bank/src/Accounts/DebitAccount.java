package Accounts;

public class DebitAccount extends AccountDecorator{

	int maxDebit, debit;

	public DebitAccount(Account account, int maxDebit, int debit){
		setMaxDebit(maxDebit);
		setDebit(debit);
	}

	@Override
	public void setMaxDebit(int maxDebit) {
		// TODO Auto-generated method stub
		this.maxDebit = maxDebit;
	}

	@Override
	public void setDebit(int debit) {
		// TODO Auto-generated method stub
		if(maxDebit >= this.debit+debit){
			this.debit += debit;
		}
		
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
