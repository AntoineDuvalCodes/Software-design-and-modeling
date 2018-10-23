package Bank_system;

import java.util.ArrayList;

public class OperationHistory {

	private ArrayList<Operation> operations;
	
	public  OperationHistory(){
		operations = new ArrayList<>();
	}
	
	public ArrayList<Operation> GetOperations(){
		return operations;
	}
	public void AddOperationToHistory(Operation operation){
		operations.add(operation);
	}
}
