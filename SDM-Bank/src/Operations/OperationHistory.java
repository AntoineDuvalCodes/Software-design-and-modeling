package Operations;



import Accounts.BasicAccount;
import Accounts.DebitAccount;
import Accounts.DepositAccount;
import Accounts.LoanAccount;
import Banks.Bank;

public class OperationHistory {

	private Bank bank;
	private boolean status;
	private String error;
	private String type;
	private int value;
	private BasicAccount bAccount;
	private DebitAccount debAccount;
	private DepositAccount depAccount;
	private LoanAccount loanAccount;
	
	public static final String TYPE_SEND_PAYMENT = "send_payment";  
	public static final String TYPE_RECEIVE_PAYMENT = "receive_payment"; 
	public static final String TYPE_OPEN_BASIC_ACCOUNT = "open_basic_account";  
	public static final String TYPE_OPEN_DEBIT_ACCOUNT = "open_debit_account";  
	public static final String TYPE_OPEN_DEPOSIT_ACCOUNT = "open_deposit_account";  
	public static final String TYPE_OPEN_LOAN_ACCOUNT = "open_loan_account";  
	public static final String TYPE_CLOSE_LOAN_ACCOUNT = "close_loan_account";  
	public static final String TYPE_CLOSE_DEPOSIT_ACCOUNT = "close_deposit_account";  
	public static final String TYPE_TRANSFERT_LOAN_ACCOUNT = "transfert_loan_account";

	//public static final String TYPE_SEND_PAYMENT = "send_payment";  

	public OperationHistory(Bank bank, boolean status, int value, String type, String error){
		this.bank = bank;
		this.status = status;
		this.error = error;
		this.type = type;
		this.value = value;
		
	}
	public OperationHistory(Bank bank, boolean status, BasicAccount account, String type, String error){
		this.bank = bank;
		this.status = status;
		this.error = error;
		this.type = type;
		this.bAccount = account;
		
	}
	public OperationHistory(Bank bank, boolean status, DebitAccount account, String type, String error){
		this.bank = bank;
		this.status = status;
		this.error = error;
		this.type = type;
		this.debAccount = account;
		
	}
	public OperationHistory(Bank bank, boolean status, DepositAccount account, String type, String error){
		this.bank = bank;
		this.status = status;
		this.error = error;
		this.type = type;
		this.depAccount = account;
		
	}
	public OperationHistory(Bank bank, boolean status, LoanAccount account, String type, String error){
		this.bank = bank;
		this.status = status;
		this.error = error;
		this.type = type;
		this.loanAccount = account;
		
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void addOperationToHistory(OperationHistory operation){
		
	}
	
	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public  OperationHistory(Bank bank){
		this.bank = bank;
	}
	
	

}
