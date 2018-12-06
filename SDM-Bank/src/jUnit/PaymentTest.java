package jUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Banks.Account1;
import Banks.DebitAccount;
import Banks.InvalidCreationException;
import Operations.Operation;
import Operations.OperationExecutor;
import Operations.Payment;

public class PaymentTest {

	DebitAccount debit_account = null;
	Account1 account = null;
	
	@Before
	public void initialize() throws InvalidCreationException{
		debit_account = new DebitAccount("Julia",0,-100, null);
		account = new Account1("Hugo", 600, null);
	}
	
	@Test
	public void executeTest(){
		
		//Operation operation = new Operation("xxx",account, debit_account);
		
		OperationExecutor opp = new OperationExecutor();
		boolean isPaid = opp.executePayment(new Payment(100,account,debit_account));
		
		assertEquals(debit_account,100);
		
	}
	
	@After
	public void clear(){
		debit_account = null;
		account = null;
	}
}
