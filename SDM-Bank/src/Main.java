import Bank_system.Account;
import Bank_system.DebitAccount;
import Bank_system.Operation;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Accounts account = new Accounts("Antoine",100.0);
		DebitAccount debit_account = new DebitAccount("Julia",0.0,-100.0);
		Account account = new Account("Hugo", 600.0);
		
		Operation operation1 = new Operation("xxx",account, debit_account);
		boolean successfull = operation1.payment(700.0);
		System.out.println(successfull);
		System.out.println(operation1.getType());

	}

}
