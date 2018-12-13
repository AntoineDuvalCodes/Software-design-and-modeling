package jUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Banks.Bank;
import Banks.InvalidCreationException;
import Operations.OperationExecutor;
import Operations.Payment;

public class PaymentTest {

	DebitAccount debit_account = null;
	BasicAccount basic_account = null;
	DebitAccount debit_account_2 = null;
	BasicAccount basic_account_2 = null;
	OperationExecutor opp;

	@Before
	public void initialize() throws InvalidCreationException{
		
		Bank bank = new Bank("eee",100000);
		basic_account = new BasicAccount("bb",100, bank);
		basic_account_2 = new BasicAccount("bb",100, bank);
		debit_account = new DebitAccount(new BasicAccount("dd",0,bank), 100,50);
		debit_account_2 = new DebitAccount(new BasicAccount("dd",0,bank), 100,0);
	    opp = new OperationExecutor();

	}
	
	@Test
	public void testBasicToBasicPayment(){
				
		opp.executePayment(new Payment(100,basic_account,basic_account_2));
		
		assertEquals(basic_account.getBalance(),0);
		assertEquals(basic_account_2.getBalance(),200);
		
		
		
	}
	@Test
	public void testBasicToDebitPayment(){
				
		opp.executePayment(new Payment(100,basic_account,debit_account));

		assertEquals(basic_account.getBalance(),0);
		assertEquals(debit_account.getBalance(),50);
		assertEquals(debit_account.getDebit(),0);
		
	}
	@Test
	public void testDebitToDebitPayment(){
		
		
		opp.executePayment(new Payment(50,debit_account,debit_account_2));

		assertEquals(debit_account.getDebit(),100);
		assertEquals(debit_account_2.getBalance(),50);
	}
	@Test
	public void testDebitToBasicPayment(){
		
		
		opp.executePayment(new Payment(50,debit_account,basic_account));

		assertEquals(debit_account.getDebit(),100);
		assertEquals(basic_account.getBalance(),150);
	}
	
	@After
	public void clear(){
		debit_account = null;
	}
}
