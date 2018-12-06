package Operations;

import java.util.ArrayList;

public class OperationHistory {

	private ArrayList<Operation> operations;
	
	public  OperationHistory(){
		operations = new ArrayList<>();
	}
	
	public ArrayList<Operation> GetOperations(){
		return operations;
	}
	
	public void AddOperationToHistory(Operation payment){
		operations.add(payment);
	}
}
