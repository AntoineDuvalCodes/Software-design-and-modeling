package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Banks.Account1;
import Banks.Bank;
import Banks.InvalidCreationException;
import Operations.Operation;
import Operations.OperationHistory;

public class OperationHistoryTest {

	OperationHistory operation_history = null;
	Bank bank = null;
	@Before
	public void initialize() throws InvalidCreationException{
		bank = new Bank("AA",100000);
	}
	
	@Test
	public void executeTest() throws InvalidCreationException{
		operation_history = new OperationHistory();

		//operation_history.AddOperationToHistory(new Operation("",new Account("H",100, bank),new Account("K",200, bank)));
		assertEquals(operation_history.GetOperations().size(),1);
		//assertEquals(operation_history.GetOperations().get(0).getReceiver().getOwner_name(),"H");
	}
	
	@After
	public void clear(){
		operation_history = null;
	}
}
