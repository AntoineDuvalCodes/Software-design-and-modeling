package Banks;

public class DebitAccount extends Account1 {

	private String owner_name;
	private int balance, max_debit;
	private Bank bank;
	
	public DebitAccount(String owner_name, int balance,int max_debit,Bank bank) throws InvalidCreationException{
		super(owner_name, balance, bank);
		this.max_debit = max_debit;
	}


	public int getMax_debit() {
		return max_debit;
	}


	public void setMax_debit(int max_debit) {
		this.max_debit = max_debit;
	}
	
	
}
