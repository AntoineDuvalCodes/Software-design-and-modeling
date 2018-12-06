package Banks;

import java.util.ArrayList;

public class CentralBank {
	
	private ArrayList<Bank> banks;
	
	
	public CentralBank(ArrayList<Bank> banks){
		this.banks = banks;
	}


	public ArrayList<Bank> getBanks() {
		return banks;
	}


	public void setBanks(ArrayList<Bank> banks) {
		this.banks = banks;
	}

	public void addBank(Bank bank){
		banks.add(bank);
	}
	
	public void removeBank(Bank bank){		
		banks.remove(bank);
	}
	
}
