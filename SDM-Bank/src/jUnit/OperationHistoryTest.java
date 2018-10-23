package jUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Bank_system.Account;
import Bank_system.Operation;
import Bank_system.OperationHistory;

public class OperationHistoryTest {

	OperationHistory operation_history = null;
	
	@Before
	public void initialize(){
		operation_history = new OperationHistory();
	}
	
	@Test
	public void executeTest(){
		operation_history.AddOperationToHistory(new Operation("",new Account("H",100.0),new Account("K",200.0)));
		assertEquals(operation_history.GetOperations().size(),1);
		assertEquals(operation_history.GetOperations().get(0).getReceiver().getOwner_name(),"H");
	}
	
	@After
	public void clear(){
		operation_history = null;
	}
}
