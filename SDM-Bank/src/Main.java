import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Banks.Bank;
import Banks.InvalidCreationException;

public class Main {

	private static ArrayList<Bank> banks;
	
	public static void main(String[] args) {
		
        boolean is_running = true;
        Scanner input;
        banks = new ArrayList<>();
        
        while(is_running){
        	
            input = new Scanner(System.in);

        	printMenu();
            int user_choice = 0;
            try{
                user_choice = input.nextInt();

            }catch(InputMismatchException e){
            	
                user_choice = 0;

            }
            
            //This menu is not fully working
            
            
            switch (user_choice){
            
            	case 1:
            		
                	System.out.println("\n\nCreate Bank\n\n");
                	createBank();
                	
            		break;
            	case 2:
            		
                	System.out.println("\n\nCreate Basic account\n\n");
                	createBasicAccount();
            		break;
            	case 3: 
            		System.out.println("\n\nCreate Debit account\n\n");
            		
            		break;
            	case 4:
            		System.out.println("\n\nCreate Deposit account\n\n");
            		break;
            	case 5:
            		System.out.println("\n\nCreate Loan account\n\n");
            		break;
            	case 6:
                	System.out.println("\n\nMake operation\n\n");
                	subMenuMakeOperations();
            		break;
            	case 7:
                	System.out.println("\n\nGet bank info\n\n");
                	subMenuGetBankInfos();
            		break;
            	case 8:
                	System.out.println("\n\nGet accounts infos\n\n");
                	subMenuGetAccountInfos();
            		break;
            	
            		
            	case 9:
                	System.out.println("\n\nFinished\n\n");
                	is_running = false;
            		break;
            	
            	default:
                	System.out.println("\n\nPlease return a number beetween 1 and 5\n\n");

            		break;
            }
        }
        		

	}
	
	
	private static void printMenu(){
		
		
		System.out.println("\n\n\nChoose the action you want to do:");
		System.out.println("Enter 1 to create a bank");
		System.out.println("Enter 2 to create an account");
		System.out.println("Enter 3 to make an operation");
		System.out.println("Enter 4 to get informations about a bank");
		System.out.println("Enter 5 to get informations about an account");
		System.out.println("Enter 6 to finish\n\n\n");
	}
	
	private static void createBank(){
		

		System.out.println("\n\n\nEnter the name of the bank");
		String bank_name = new Scanner(System.in).nextLine();
		System.out.println("\nEnter the balance of the bank");
		int bank_balance = 0;
		try{
			bank_balance = new Scanner(System.in).nextInt();

        }catch(InputMismatchException e){
        	
        	System.out.println("Please enter a valid integer balance");
            return;

        }
		
		
		try {
			Bank bank = new Bank(bank_name,bank_balance);
			banks.add(bank);
		} catch (InvalidCreationException e) {
			System.out.println(e);
		}
	}
	private static void createBasicAccount(){
		
		 Scanner input_bank_selection = new Scanner(System.in);
		 System.out.println("\n\nSelect a bank:\n");
		 int user_selection = 0;
		 
		 for (int i = 0; i<banks.size();i++){
			 System.out.println("Enter "+(i+1)+" to select the bank "+banks.get(i).getName());
		 }
		 try{
			 
			 user_selection = new Scanner(System.in).nextInt();

         }catch(InputMismatchException e){
         	
        	 user_selection = 0;
        	 System.out.println("Please enter a number");
        	 return;
         }
		 
		 if(user_selection>banks.size() || user_selection<1){
			 System.out.println("Please enter a valid number");
        	 return;
		 }
		 
		 for(int selection = 1; selection<banks.size()+1; selection++){
			 
			 if(selection == user_selection){
				 System.out.println("Enter account owner name");
				 String customer_name = new Scanner(System.in).nextLine();
				 System.out.println("Enter the account is balance");
				 int account_balance = new Scanner(System.in).nextInt();
				 try {
					banks.get(selection-1).createBasicAccount(customer_name,account_balance);
					System.out.println("Account created");
				} catch (InvalidCreationException e) {
					System.out.println(e);
					
				}
			 }
		 }
		 
		 
	}
	
	private static void subMenuGetBankInfos(){
		
		System.out.println("Enter a number to select the bank");

		for(int i = 0; i < banks.size();i++){
			System.out.println("Enter  "+(i+1)+" Bank "+banks.get(i).getName());
		}
		try {
			int bank_selector = new Scanner(System.in).nextInt();
			bank_selector--;
			if(bank_selector <0 || bank_selector > banks.size()){
				System.out.println("Please enter a valid bank number");
				return;
			}
			
			System.out.println("  Bank ID = "+banks.get(bank_selector).getID());
			System.out.println("  Bank name = "+banks.get(bank_selector).getName());
			System.out.println("  Bank balance = "+banks.get(bank_selector).getBalance());			

			for(int i = 0;i<banks.get(bank_selector).getAccounts().size();i++){
				
				System.out.println("  Account ID "+banks.get(bank_selector).getAccounts().get(i).getId());

			}
			
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid bank number");
			
		}

		
	}
	private static void subMenuGetAccountInfos(){
		
		
		
	}
	private static void subMenuMakeOperations(){
		
		
		
	}
	

}
