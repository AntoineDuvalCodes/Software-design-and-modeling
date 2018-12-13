package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Accounts.DepositAccount;
import Accounts.LoanAccount;
import Banks.Bank;
import Banks.InvalidCreationException;
import Operations.OperationExecutor;

public class AccountTest {

	DebitAccount debit_account = null;
	BasicAccount basic_account = null;
	DebitAccount debit_account_2 = null;
	BasicAccount basic_account_2 = null;
	Bank bank = null;
	OperationExecutor opp;

	
	@Before
	public void initialize() throws InvalidCreationException{
		bank = new Bank("AA",100000);
		Bank bank = new Bank("eee",100000);
		basic_account = new BasicAccount("bb",100, bank);
		basic_account_2 = new BasicAccount("bb",100, bank);
		debit_account = new DebitAccount(new BasicAccount("dd",0,bank), 100,50);
		debit_account_2 = new DebitAccount(new BasicAccount("dd",0,bank), 100,0);
	    opp = new OperationExecutor();
	}
	
	
	@Test (expected = InvalidCreationException.class)
	public void NegativeBalanceTest() throws InvalidCreationException{
		
		basic_account = new BasicAccount("AAA",-1000,bank);
        fail("Negative Balance on normal account created");
	}
	
	@Test (expected = InvalidCreationException.class)
	public void AccountNameLenghtTest() throws InvalidCreationException{
		
		basic_account = new BasicAccount("", 100, bank);
        fail("Account created with name lenght equal to 0");
        
	}
	@Test (expected = InvalidCreationException.class)
	public void AccountNameContainingNumberTest() throws InvalidCreationException{
		
		basic_account = new BasicAccount("10", 100, bank);
        fail("Account created with numeric values");
        
	}
	
	@Test (expected = AssertionError.class)
	public void LoanAccountCloseTest() throws InvalidCreationException{
		
		
		//To close the Loan account you need to refund the bank (+interest) with your main account
		LoanAccount loan2 = new LoanAccount(basic_account, 5000);
		loan2.closeLoanAccount();
        fail("Your main account cannot refund the bank for the moment");
        
		LoanAccount loan = new LoanAccount(debit_account, 100);
		assertEquals(loan.getBalance(),100);
		loan.closeLoanAccount();

		


	
		
	}
	
	@Test 
	public void LoanAccountInterestRateTest() throws InvalidCreationException, InterruptedException{
		
		//Create an LoanAccount with 100, this loan account is linked to the debit_account
		LoanAccount loan = new LoanAccount(debit_account, 100);
		assertEquals(loan.getBalance(),100);

		// Wait 4 seconds to generate the interest
		Thread.sleep(4000);		
		loan.closeLoanAccount();
		//The Debit of the account has increase by 24 (100*0.06*4)
		assertEquals(debit_account.getDebit(),74);
		assertEquals(debit_account.getBalance(),0);

	
		
	}
	@Test (expected = InvalidCreationException.class)
	public void TransfertToMainAccountTest() throws InvalidCreationException{
		

		LoanAccount loan = new LoanAccount(debit_account, 100);
		assertEquals(loan.getBalance(),100);
		
		//Transfer the money from the Loan account to the main account
		loan.transfertToMainAccount(50);
		assertEquals(loan.getBalance(),50);
		assertEquals(debit_account.getDebit(),0);
		loan.transfertToMainAccount(100);
		fail("Your loan account balance is not sufficient");
		
	}
	
	
	@Test (expected = InvalidCreationException.class)
	public void DepositeCreationTest() throws InvalidCreationException, InterruptedException{
		
		DepositAccount dep = new DepositAccount(basic_account, 50);
		assertEquals(dep.getBalance(),50);
		
		//To open a deposit account you need to have enough money on your main account
		DepositAccount dep2 = new DepositAccount(basic_account, 500);
        fail("Deposit balance greater than account balance");

		
	}
	@Test 
	public void CloseDepositeTest() throws InvalidCreationException, InterruptedException{
		
		//When you close your deposit account the bank refund you in the main account + interests
		DepositAccount dep = new DepositAccount(basic_account, 50);
		assertEquals(dep.getBalance(),50);
		Thread.sleep(4000);		
		dep.closeDepositAccount();
		assertEquals(basic_account.getBalance(),110);

		
	}
	
	

	@After
	public void clear(){
		debit_account = null;
		basic_account = null;
		debit_account_2 = null;
		basic_account_2 = null;
		bank = null;
		opp = null;

	}
}
