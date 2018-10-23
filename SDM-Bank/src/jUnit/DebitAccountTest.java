package jUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Bank_system.DebitAccount;

public class DebitAccountTest {

	DebitAccount debit_account = null;

	@Before
	public void initialize(){
		debit_account = new DebitAccount("Julia",0.0,-100.0);
	}
	
	@Test
	public void executeTest(){
		assertEquals(0.0,debit_account.getBalance(),0.1);
		assertEquals(-200.0, debit_account.getMax_debit(),0.1);
		

	}
	
	@After
	public void clear(){
		debit_account = null;
	}
}
