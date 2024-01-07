package org.jsp.bank.DAO;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import org.jsp.bank.model.Bank;
public class BankDaoImpl implements BankDAO {
	 String url="jdbc:mysql://localhost:3307/bank_database?user=root&password=12345";
	 Scanner scan=new Scanner(System.in);

	 public void userRegistration(Bank bank)
	 {
			String insert="insert into bank(firstname,lastname,mobilenum,email_id,password,address,amount,account_num) values(?,?,?,?,?,?,?,?)";
			try
			{
				//connection establishment using drivermanager class and getConnection() over Connection interface
				Connection con=DriverManager.getConnection(url);
//Creating a platform to prepare our statement by providing insert as an argument to the prepareStatement() using the connection objrefvar as it is a nonstatic method
			//	and PreparedStatement is a interface
				PreparedStatement pst=con.prepareStatement(insert);
				pst.setString(1,bank.getFirstname());
				pst.setString(2,bank.getLastname());
				pst.setString(3,bank.getMobilenumber());
				String tempname=bank.getFirstname().toLowerCase();
				Random random=new Random();
				int tempnum=random.nextInt(1000);
				String bankemailid=tempname+tempnum+"@teca52.com";
				pst.setString(4,bankemailid);
				
				pst.setString(5,bank.getPassword());
				pst.setString(6,bank.getAddress());
				pst.setDouble(7,bank.getAmount());
				long acctnum=random.nextLong(100000000000l);
				if(acctnum<100000000000l)
				{
					acctnum+=100000000000l;
				}
				pst.setString(8,""+acctnum);
				int result=pst.executeUpdate();
				if(result!=0)
				{
					System.out.println("Your Registration is succesfull");
					System.out.println("Your Account is Created Successfully");
					try
					{
						Thread.sleep(2000);
						System.out.println("Your Bank Email Id is :"+bankemailid);
						System.out.println("your Account Number is :"+acctnum);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("Inavlid details");
				}
						
			}
			catch(SQLException e)
			{ System.out.println(e);
			}
	 }

	

	



	private int executeUpdate(String insert) {
		// TODO Auto-generated method stub
		return 0;
	}



	public void credit(String accnum,String passwd) {
		try {
			Connection conn=DriverManager.getConnection(url);
			PreparedStatement ps=conn.prepareStatement("select * from bank where account_num=? and password=?");
			ps.setString(1, accnum);
			ps.setString(2, passwd);
			ResultSet resultset=ps.executeQuery();
			if(resultset.next())
			{
				System.out.println("Enter the Amount:");
				boolean amountstatus=true;
				while(amountstatus)
				{
					double useramount=scan.nextDouble();
					if(useramount>0)
					{
						amountstatus=false;
						double databaseamount=resultset.getDouble("Amount");
						double sum=databaseamount+useramount;
						String update="update bank set amount=? where account_num=? and password=?";
						PreparedStatement psu=conn.prepareStatement(update);
						psu.setDouble(1, sum);
						psu.setString(2, accnum);
						psu.setString(3, passwd);
						int result=psu.executeUpdate();
						if(result!=0)
						{
							for(int i=0;i<=5;i++)
							{
								try {
									Thread.sleep(2000);
									System.out.print(".");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
				
						System.out.println("Your amount "+useramount+ "Rs has been credited Successfully.");
						System.out.println("Do you want to check the balance in your Account? \n Yes \n No");
					
						String response=scan.next();
						boolean status=true;
						if(response.equalsIgnoreCase("yes"))
						{
							status=true;
							System.out.println("The Remaining Balance in your account is :"+sum+"Rs");
							
						}
						else
						{
							status=false;
							System.out.println("thank you visit again............");
						}
					}
						else
						{
							for(int i=0;i<=5;i++)
							{
								try {
									Thread.sleep(2000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							System.out.println("Server Issue...Try Again Later...");
						}
					}
					else
					{
						System.out.println("Enter proper  Amount");
						amountstatus=true;
					}
				}
				
			}
			
		
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}


						
					}
				
				
			
		
		
		
	

	public void debit(String accountnumber,String password) {
		try {
			Connection conn=DriverManager.getConnection(url);
			PreparedStatement ps=conn.prepareStatement("select * from bank where account_num=? and password=?");
			ps.setString(1, accountnumber);
			ps.setString(2, password);
			ResultSet resultSet=ps.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Enter Your Amount :");
				boolean amountstatus=true;
				while(amountstatus)
				{
					double useramount=scan.nextDouble();
					if(useramount>0)
					{
						amountstatus=false;
						double databaseamount=resultSet.getDouble("Amount");
						if(databaseamount>useramount)
						{
							double sub=databaseamount-useramount;
							String update="update bank set amount=? where account_num=? and password=?";
							PreparedStatement psu=conn.prepareStatement(update);
							psu.setDouble(1, sub);
							psu.setString(2, accountnumber);
							psu.setString(3, password);
							int result=psu.executeUpdate();
							if(result!=0)
							{
								for(int i=0;i<=5;i++)
								{
									try {
										Thread.sleep(2000);
										System.out.print(".");
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
					
							System.out.println("Your amount "+useramount+ "Rs has been debited Successfully.");
							System.out.println("Do you want to check the balance in your Account? \n Yes \n No");
						
							String response=scan.next();
							boolean status=true;
							if(response.equalsIgnoreCase("yes"))
							{
								status=true;
								System.out.println("The Remaining Balance in your account is :"+sub+"Rs");
								
							}
							else
							{
								status=false;
								System.out.println("thank you visit again............");
							}
						}
							else
							{
								for(int i=0;i<=5;i++)
								{
									try {
										Thread.sleep(2000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								System.out.println("Server Issue...Try Again Later...");
							}
						}
						else
						{
							System.out.println("Insufficient Balance");
							amountstatus=true;
						}
					}
					else
					{
						System.out.println("Invalid amount.");
						System.out.println("Enter amount Greater than Zero..");
						amountstatus=true;
					}
				}
				
			}
			else
			{
				System.out.println("not ok");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
	}

	public void changingThePassword(String accountNumber,String currentPassword) {
		
		try {
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement preparedStatement = 
					 connection.prepareStatement("select * from bank where account_num=? and password=?");
			preparedStatement.setString(1, accountNumber);
			preparedStatement.setString(2, currentPassword);
			ResultSet resultSet = preparedStatement.executeQuery();// buffer memory 
			if (resultSet.next()) {
				System.out.println("Enter the new password (4 digits)");
				String newpass = scan.next();
				System.out.println("Confirm the new password");
				String confirmpass = scan.next();
				if (newpass.equals(confirmpass)) {
					
					String update = "update bank set password=? where account_num=? and password=? ";
					PreparedStatement preparedStatement2 = connection.prepareStatement(update);
					preparedStatement2.setString(1, newpass);
					preparedStatement2.setString(2, accountNumber);
					preparedStatement2.setString(3, currentPassword);
					
					int result = preparedStatement2.executeUpdate();
					if (result!=0) {
						
							System.out.println("New Password Updated Successfully");
						
						
						
					}
					
				} else {
					System.out.println("Password Mismatch");
				}
				
			} else {
				System.out.println("Enter a valid accountnumber and password ");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


			
			
			
		
	

	public void mobileToMobileTransactions(String mobilenumber) {
		try {
			Connection conn=DriverManager.getConnection(url);
			PreparedStatement pst=conn.prepareStatement("select * from bank where mobilenum=?");
			pst.setString(1, mobilenumber);
			ResultSet resultSet=pst.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Enter Receiver's mobile number :");
				boolean recmobnumstatus=true;
				while(recmobnumstatus)
				{
					String recmobnum=scan.next();
					if(recmobnum.length()==10)
					{
						recmobnumstatus=false;
						PreparedStatement pstre=conn.prepareStatement("select * from bank where mobilenum=?");
						pstre.setString(1, recmobnum);
						ResultSet resultsetre=pst.executeQuery();
						if(resultsetre.next())
						{
							System.out.println("Enter Amount:");
							boolean amountstatus=true;
							while(amountstatus)
							{
							double amount=scan.nextDouble();
							if(amount>0)
							{
								amountstatus=false;
								double senderdatabaseamount=resultsetre.getDouble("amount");
								if(senderdatabaseamount>=amount)
								{
									System.out.println("ok");
								}
								else
								{
									System.out.println("Insuffiecient Balance:");
									System.out.println("Your Account Balance is:"+"/-");
									amountstatus=true;
								}
							}
							else
							{
								System.out.println("Enter Valid Amount:");
							}
							}
						}
						else
						{
							System.out.println("Enter valid Receiver's Mobile number:");
							System.out.println("Refer Your Friend to our bank application get Placement Offer");
						}
					}
					else
					{
						System.out.println("Enter the valid 10-digit mobile number:");
					}
				}
			}
			else
			{
				System.out.println("Invalid mobile number:");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void checkBalance(String accountnum,String password) {
		try {
			Connection conn=DriverManager.getConnection(url);
			PreparedStatement ps=conn.prepareStatement("select * from bank where account_num=? and password=?");
			ps.setString(1, accountnum);
			ps.setString(2, password);
			ResultSet resultset=ps.executeQuery();
			if(resultset.next())
			{
				
						double databaseamount=resultset.getDouble("Amount");
						
						System.out.println("Do you want to check the balance in your Account? \n Yes \n No");
					
						String response=scan.next();
						boolean status=true;
						if(response.equalsIgnoreCase("yes"))
						{
							status=true;
							System.out.println("The Balance in your account is :"+databaseamount+"Rs");
							
						}
						else
						{
							status=false;
							System.out.println("thank you visit again............");
						}
					}
						
					
									
				
			
			else
			{
				System.out.println("not ok");
			}
			
		
		
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	}







	









	

}
