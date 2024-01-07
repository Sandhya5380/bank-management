package org.jsp.bank.DAO;
//Helper Class
public class BankCustomerDesk {
	
        public static BankDAO customerHelpDesk()
        {
        	BankDAO bankDAO=new BankDaoImpl();
        	return bankDAO;
        }
}
