package Bank_system;

public class DebitAccount extends Account {

	private String owner_name;
	private Double balance, max_debit;
	
	
	public DebitAccount(String owner_name, Double balance,Double max_debit){
		super(owner_name, balance);
		this.max_debit = max_debit;
	}


	public Double getMax_debit() {
		return max_debit;
	}


	public void setMax_debit(Double max_debit) {
		this.max_debit = max_debit;
	}
	
	
}
