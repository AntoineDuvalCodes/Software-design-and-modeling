package jUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Banks.Bank;
import Banks.DebitAccount;
import Banks.InvalidCreationException;

public class DebitAccountTest {

	DebitAccount debit_account = null;
	Bank bank = null;
	@Before
	public void initialize() throws InvalidCreationException{
		bank = new Bank("AA",100000);

	}
	
	@Test
	public void executeTest() throws InvalidCreationException{
		debit_account = new DebitAccount("Julia",0,-100, null);

		assertEquals(0,debit_account.getBalance());
		assertEquals(-200, debit_account.getMax_debit());
		

	}
	
	@After
	public void clear(){
		debit_account = null;
	}
}
