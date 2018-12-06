package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Banks.Account1;
import Banks.Bank;
import Banks.InvalidCreationException;

public class AccountTest {

	BasicAccount basic_account = null;
	BasicAccount account = null;
	DebitAccount debit_account = null;
	Bank bank = null;
	@Before
	public void initialize() throws InvalidCreationException{
		bank = new Bank("AA",100000);

	}
	
	
	@Test// (expected = InvalidCreationException.class)
	public void AccountCreationTest() throws InvalidCreationException{
		
		
		basic_account = new BasicAccount("AAA",1000,bank);
		
	
        //fail("Negative Balance on normal account created");
        
        account = new BasicAccount("AAA",1000,bank);
		debit_account = new DebitAccount(account,100,50);
		
        
	}
	@Test ///(expected = InvalidCreationException.class)
	public void AccountNameLenghtTest() throws InvalidCreationException{
		
		//account = new Account1("", 100, bank);
        //fail("Account created with name lenght equal to 0");
        
	}
	@Test //(expected = InvalidCreationException.class)
	public void AccountNameContainingNumberTest() throws InvalidCreationException{
		
		//account = new Account1("abcd", 100, bank);
        //fail("Account created with numeric values");
        
	}
	

	@After
	public void clear(){
		account = null;
	}
}
