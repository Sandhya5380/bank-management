package org.jsp.bank;
import java.util.Scanner;
import org.jsp.bank.DAO.BankCustomerDesk;
import org.jsp.bank.DAO.BankDAO;
import org.jsp.bank.model.Bank;
public class App 
{
    public static void main( String[] args )
    {
    	BankDAO bankDAO=BankCustomerDesk.customerHelpDesk();
    	System.out.println("Enter: \n 1.For Registration  \n 2.Action for credit  \n 3.For Debit \n 4.For changing the password \n 5.For mobile to mobile transaction  \n 6.For check Balance ");
    	Scanner scan=new Scanner(System.in);
    	int response =scan.nextInt();
    	switch(response)
    	{
    	case 1:
    		//Firstly we have to store the values in the bank class objects
        	//so we have chosen the constructor with argumentws
        	//because it is mandatory to give all the details of the user
              System.out.println("Enter your First Name :");
              String fname=scan.next();
              System.out.println("Enter your Last Name :");
              String lname=scan.next();
              System.out.println("Enter your Mobile Num :");
              String mobnum="";
              String pswd="";
              String add="";
             boolean mbstatus=true;
              while(mbstatus)
              {
            	  mobnum=scan.next();
            	  if(mobnum.length()==10){
           		  mbstatus=false;
           		  System.out.println("Enter Your Password:");
           		  boolean pswordstatus=true;
           		  while(pswordstatus)
           		  {    
           			  pswd=scan.next();
           		  

           			  if(pswd.length()==5)
           			  {
           				  pswordstatus=false;
           				  System.out.println("Enter Your address:");
           	              add=scan.next();

           			  }
           			  else
           			  {
           				  System.out.println("Invalid password..");
           				  System.out.println("Enter the valid 5 digit password:");
           			  }
           		  }
            	  }
          	  else
          	  {          		  System.out.println("Enter valid 10 digit mobile num:");
          	  }
              }

            
              
//              System.out.println("Enter your Email id :");
//              String emailid=scan.next();
//            	
             double amount=0;
              System.out.println("Enter your Amount :");
              boolean amountstatus=false;
              while(amountstatus)
              {
              
              amount=scan.nextDouble();
              if(amount>0)
              {
            	  amountstatus=false;
              }
              else
              {
            	  System.out.println("Invalid amount..");
            	  System.out.println("Enter the valid amount:");
              }
              }
//              System.out.println("Enter your AccountNumber :");
//              String acctnum=scan.next();
              
              
    		
    		
    		Bank bank =new Bank(0,fname,lname,mobnum ,null,pswd,add,amount,null);
    	bankDAO.userRegistration(bank);
    	

    	 break;
    	case 2:
    		System.out.println("Enter Your Account Number:");
    		boolean accountstatus2=true;
    		while(accountstatus2)
    		{
    			String accountnumber=scan.next();
    			if(accountnumber.length()==11)
    			{
    				accountstatus2=false;
    				System.out.println("Enter your password:");
    				boolean psswdstatus=true;
    				while(psswdstatus) {
    	    		String password=scan.next();
    	    		
    	    		if(password.length()==5)
    	    		{
    	    			psswdstatus=false;
    	    			//calling the method which is having debit Operation.....
    	    			bankDAO.credit(accountnumber,password);
    	    		}
    	    		else
    	    		{
    	    			System.out.println("Invalid password:");
    	    			System.out.println("Enter the valid 5 digit password:");
    	    		}

    			}
    			}
    			else
    			{
    				System.out.println("Invalid data....");
    				System.out.println("Enter valid 11 digits Account Number:");
    			}
    		}
    	    
    		break;
    		
    	case 3:
    		System.out.println("Enter Your Account Number:");
    		boolean accountstatus=true;
    		while(accountstatus)
    		{
    			String accountnumber=scan.next();
    			if(accountnumber.length()==11)
    			{
    				accountstatus=false;
    				System.out.println("Enter your password:");
    				boolean psswdstatus=true;
    				while(psswdstatus) {
    	    		String password=scan.next();
    	    		
    	    		if(password.length()==5)
    	    		{
    	    			psswdstatus=false;
    	    			//calling the method which is having debit Operation.....
    	    			bankDAO.debit(accountnumber,password);
    	    		}
    	    		else
    	    		{
    	    			System.out.println("Invalid password:");
    	    			System.out.println("Enter the valid 5 digit password:");
    	    		}

    			}
    			}
    			else
    			{
    				System.out.println("Invalid data....");
    				System.out.println("Enter valid 11 digits Account Number:");
    			}
    		}
    	    
    		break;
    	case 4:
    		System.out.println("Enter your Account Number ");
			boolean accountStatus= true;  
			while (accountStatus) {
				String accountNumber = scan.next();
				if (accountNumber.length()==11) {
					accountStatus= false;
					System.out.println("Enter your password");
					boolean passwordStatus= true;
					while (passwordStatus) {
						String userPassword = scan.next();
						if (userPassword.length()==5) {
							passwordStatus = false;
							bankDAO.changingThePassword( accountNumber,  userPassword);
							
							
						} else {
							System.out.println("Invalid Password ");
							System.out.println(" Enter 5 digits password");
						}
						
					}
} else {
					
					System.out.println("Invalid Account Number ");
					System.out.println("Enter 11 digits Account NumbER");
					
				}
				
			}
			break;

					
    
    	case 5:
    		System.out.println("Enter your mobile number:");
    		boolean mobilenumberstatus=true;
    		while(mobilenumberstatus)
    		{
    			String mobilenumber=scan.next();
    			if(mobilenumber.length()==10)
    			{
    				mobilenumberstatus=false;
    				bankDAO.mobileToMobileTransactions(mobilenumber);
    				
    			}
    			else
    			{
    				System.out.println("Enter the valid 10 digit mobile number:");
    			}
    		}
    		
    	default:
    		break;
    	case 6:
    		System.out.println("Enter Your Account Number:");
    		boolean accountstatus3=true;
    		while(accountstatus3)
    		{
    			String accountnumber=scan.next();
    			if(accountnumber.length()>11)
    			{
    				accountstatus3=false;
    				System.out.println("Enter your password:");
    				boolean psswdstatus=true;
    				while(psswdstatus) {
    	    		String password=scan.next();
    	    		
    	    		if(password.length()==5)
    	    		{
    	    			psswdstatus=false;
    	    			//calling the method which is having debit Operation.....
    	    			bankDAO.checkBalance(accountnumber,password);
    	    		}
    	    		else
    	    		{
    	    			System.out.println("Invalid password:");
    	    			System.out.println("Enter the valid 5 digit password:");
    	    		}

    			}
    			}
    			else
    			{
    				System.out.println("Invalid data....");
    				System.out.println("Enter valid 11 digits Account Number:");
    			}
    		}
    	    
    		break;
    		
    	}
    }
}

