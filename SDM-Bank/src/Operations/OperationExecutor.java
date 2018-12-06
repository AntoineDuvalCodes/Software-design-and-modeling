package Operations;

public class OperationExecutor {
	
	public boolean executePayment(Payment payment){
		return payment.execute();
	}
	
	//aka
	public boolean executeInterBankPayment(InterbankPayment payment){
		return payment.execute();
	}
	
	
	
}
