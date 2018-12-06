package jUnit;


import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Banks.Bank;
import Banks.InvalidCreationException;

public class BankTest {

	@Before
	public void initialize(){
		
	}
	@Test (expected = InvalidCreationException.class)
	public void AccountCreationTest() throws InvalidCreationException{
		
		Bank bank = new Bank("",0);
        fail("Bank created with name lenght equal to 0");
        
	}
	@After
	public void clear(){
		
	}
}
