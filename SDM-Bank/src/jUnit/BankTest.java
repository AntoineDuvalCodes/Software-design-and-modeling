package jUnit;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Accounts.DepositAccount;
import Accounts.LoanAccount;
import Banks.Bank;
import Banks.InvalidCreationException;

public class BankTest {
	Bank bank = null;
	DebitAccount debit_account = null;
	BasicAccount basic_account = null;
	
	@Before
	public void initialize() throws InvalidCreationException{
		bank = new Bank("a",1000000);
		

	}
	@Test (expected = InvalidCreationException.class)
	public void AccountCreationTest() throws InvalidCreationException {
		bank = new Bank("",1000000);
        fail("Bank created with name lenght equal to 0");
		
	}
	
	
	@Test 
	public void OperationHistoryTest() throws InvalidCreationException {

		//Generating some operation in order to see if we can retrieve them with the bank operation_history variable
		basic_account = new BasicAccount("bb",100, bank);
		debit_account = new DebitAccount(new BasicAccount("dd",0,bank), 100,50);
		LoanAccount loan = new LoanAccount(basic_account, 100);
		DepositAccount dep = new DepositAccount(basic_account, 50);
		loan.closeLoanAccount();
		loan = new LoanAccount(debit_account, 100);
		loan.transfertToMainAccount(50);
		dep.closeDepositAccount();
		
		assertEquals(bank.getOperation_history().size(),16);

	}
	
	
	
	
	
	
	@After
	public void clear(){
		
	}
}
