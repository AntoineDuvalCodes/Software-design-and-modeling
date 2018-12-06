package Accounts;


public abstract class AccountDecorator extends Account{

	public Account account;
	public int maxDebit;
	public int debit;
	
	
	public abstract void setMaxDebit(int maxDebit);
	public abstract void setDebit(int debit);
	public abstract int getMaxDebit();
	public abstract int getDebit();

}
