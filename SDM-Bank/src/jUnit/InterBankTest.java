package jUnit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Banks.Account1;
import Banks.Bank;
import Banks.CentralBank;
import Banks.DebitAccount;
import Banks.InvalidCreationException;
import Operations.InterbankPayment;
import Operations.OperationExecutor;
import Operations.Payment;

public class InterBankTest {

	CentralBank central_bank;
	Bank bankone,banktwo;
	Account1 aone,atwo,athree,afour;
	
	@Before
	public void initialize() throws InvalidCreationException{
		
		bankone = new Bank("Bank",10000);
		banktwo = new Bank("Bankk",10000);
		
		aone = new Account1("a",100,bankone);
		atwo = new Account1("aa",100,bankone);
		athree = new Account1("aaa",100,banktwo);
		afour = new Account1("aaaa",100,banktwo);

		bankone.addAccounts(aone);
		bankone.addAccounts(atwo);
		banktwo.addAccounts(athree);
		banktwo.addAccounts(afour);
		
		ArrayList<Bank> banks = new ArrayList<>();
		banks.add(bankone);
		banks.add(banktwo);
		central_bank = new CentralBank(banks);
	}
	
	@Test
	public void executeTest(){
		
		//Operation operation = new Operation("xxx",account, debit_account);
		
		
		OperationExecutor opp = new OperationExecutor();
		boolean isPaid = opp.executeInterBankPayment(new InterbankPayment(central_bank, bankone, banktwo, aone,athree,50));
		
		assertEquals(aone.getBalance(),50);
		assertEquals(athree.getBalance(),150);

	}
	
	@After
	public void clear(){
		
	}
}
