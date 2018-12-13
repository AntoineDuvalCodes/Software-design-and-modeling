package Operations;

import Accounts.Account;
import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Accounts.DepositAccount;
import Accounts.LoanAccount;

public class InterestRate{
	private Account account;
	private final int TIME_INTERVAL = 1000; // 1s is easier to test but it should be more in real use case
	
	public InterestRate(Account account){
		this.account = account;
	}
	
	 public int calculateInterest(){
		int interest = 0;

		if(System.currentTimeMillis() - account.getLast_interest_date() > TIME_INTERVAL){
			
			if(account instanceof BasicAccount){
				
				if(account.getBalance() > 100){

					interest = (int) (account.getBalance()*0.03*(System.currentTimeMillis()-account.getLast_interest_date())/TIME_INTERVAL); 
				}
				
				
			}else if(account instanceof DebitAccount){
				
				if(account.getBalance() > 100){

					interest = (int) (account.getBalance()*0.02*(System.currentTimeMillis()-account.getLast_interest_date())/TIME_INTERVAL); 
				}
				
				
			}else if (account instanceof DepositAccount){
				
				 interest = (int) (account.getBalance()*0.05*(System.currentTimeMillis()-account.getLast_interest_date())/TIME_INTERVAL); 
				
				
				
			}else if(account instanceof LoanAccount){
				
				 interest = (int) (account.getBalance()*0.06*(System.currentTimeMillis()-account.getLast_interest_date())/TIME_INTERVAL); 

			}			
				
			account.setLast_interest_date(System.currentTimeMillis());
			return interest;
		}else{
			
			return 0;
		}
	}
	
}
