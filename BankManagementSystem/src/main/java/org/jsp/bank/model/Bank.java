package org.jsp.bank.model;

public class Bank {
	
		private int id;
		private String firstname;
		private String lastname;
		private String mobilenum;
		private String email_id;
		private String password;
		private String address;
		private double amount;
		private String account_num;
		public Bank() {
			
		}
		public Bank(int id, String firstname, String lastname, String mobilenum, String email_id, String password,
				String address, double amount, String account_num) {
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			
			this.mobilenum = mobilenum;
			
			this.email_id = email_id;
		
			this.password = password;
			
			this.address = address;
			this.amount = amount;
			
		this.account_num = account_num;

			
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getMobilenumber() {
			return mobilenum;
		}
		public void setMobilenumber(String mobilenum) {
			this.mobilenum = mobilenum;
		}
		public String getEmailid() {
			return email_id;
		}
		public void setEmailid(String email_id) {
			this.email_id = email_id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getAccountnumber() {
			return account_num;
		}
		public void setAccountnumber(String account_num) {
			this.account_num = account_num;
		}
		@Override
		public String toString() {
			return "Bank [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", mobilenumber="
					+ mobilenum + ", emailid=" + email_id + ", password=" + password + ", address=" + address
					+ ", amount=" + amount + ", accountnumber=" + account_num + "]";
		}
		
		
		

	}


