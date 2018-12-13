package Operations;


public class OperationExecutor {
	
	public boolean executePayment(Payment payment){
		return payment.execute();
	}
	
	public boolean executeInterBankPayment(InterbankPayment payment){
		return payment.execute();
	}
	
	
}
