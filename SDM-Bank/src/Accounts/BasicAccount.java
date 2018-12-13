package Accounts;

import java.util.regex.Pattern;

import Banks.Bank;
import Banks.InvalidCreationException;
import Operations.OperationHistory;

public class BasicAccount extends Account{

		public BasicAccount(String owner_name, int balance, Bank bank) throws InvalidCreationException{
			if (owner_name.length() ==0 || Pattern.compile( "[0-9]" ).matcher( owner_name ).find()){
				throw new InvalidCreationException("Size of the name must be greater than 0 and must not include numbers");
			}else{
				setOwnerName(owner_name);

			}
			if(balance>=0){
				
				setBalance(balance);
				
			}else{
				throw new InvalidCreationException("Negative balance unauthorised");
			}
			
			openAccount(bank);
			addOperationToAccountHistory(new OperationHistory(getBank(),true, this,OperationHistory.TYPE_OPEN_BASIC_ACCOUNT,""));

		}

}
