package jUnit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Accounts.Account;
import Accounts.BasicAccount;
import Banks.Bank;
import Banks.CentralBank;
import Banks.InvalidCreationException;
import Operations.InterbankPayment;
import Operations.OperationExecutor;

public class InterBankTest {

	CentralBank central_bank;
	Bank bankone,banktwo;
	Account aone,atwo,athree,afour;
	
	@Before
	public void initialize() throws InvalidCreationException{
		
		bankone = new Bank("Bank",10000);
		banktwo = new Bank("Bankk",10000);
		
		aone = new BasicAccount("a",100,bankone);
		atwo = new BasicAccount("aa",100,bankone);
		athree = new BasicAccount("aaa",100,banktwo);
		afour = new BasicAccount("aaaa",100,banktwo);

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
		
		
		OperationExecutor opp = new OperationExecutor();
		opp.executeInterBankPayment(new InterbankPayment(central_bank, banktwo, aone,athree,50));
		
		assertEquals(aone.getBalance(),50);
		assertEquals(athree.getBalance(),150);

	}
	
	@After
	public void clear(){
		
	}
}
