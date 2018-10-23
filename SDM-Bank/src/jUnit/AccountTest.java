package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Bank_system.Account;

public class AccountTest {

	Account account = null;
	
	@Before
	public void initialize(){
		account = new Account("Hugo", 600.0);
	}
	
	@Test
	public void executeTest(){
	
		assertEquals(600.0,account.getBalance(),0.1);
	}
	

	@After
	public void clear(){
		account = null;
	}
}
