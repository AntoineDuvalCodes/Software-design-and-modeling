package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Bank_system.Account;
import Bank_system.DebitAccount;
import Bank_system.Operation;

public class OperationTest {

	DebitAccount debit_account = null;
	Account account = null;
	
	@Before
	public void initialize(){
		debit_account = new DebitAccount("Julia",0.0,-100.0);
		account = new Account("Hugo", 600.0);
	}
	
	@Test
	public void executeTest(){
		
		Operation operation = new Operation("xxx",account, debit_account);
		boolean successfull = operation.payment(700.0);
		
		assertTrue(operation.getType(), successfull);
		
	}
	
	@After
	public void clear(){
		debit_account = null;
		account = null;
	}
	
}
