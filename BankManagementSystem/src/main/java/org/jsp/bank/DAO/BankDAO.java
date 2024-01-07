package org.jsp.bank.DAO;

import org.jsp.bank.model.Bank;

public interface BankDAO {
	
	//step1...Declare all the unimplemented methods to implement in class
	 void userRegistration(Bank bank);
	 void credit(String accnum,String passwd);
	 void debit(String accountnumber, String password);
	 void changingThePassword(String accountNumber,String currentPassword);
	 void mobileToMobileTransactions(String mobilenumber);
	 void checkBalance(String accountnum,String password);
	}


