package exercices;

public class BankAccount {
	
	private String accountName;
	private double balance;
	private double feeCharge;

	public BankAccount() {
		this.accountName = "anonymous";
		this.balance = 0;
		this.feeCharge = 2;
	}
	
	public BankAccount(String accountName, double balance) {
		this.accountName = accountName;
		this.balance = balance;
		this.feeCharge = 2;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getFeeCharge() {
		return feeCharge;
	}

	public void setFeeCharge(double feeCharge) {
		this.feeCharge = feeCharge;
	}
	
	/** Deposits money into the bank account **/
    public void deposit(double amount)
    {
		if (amount >= 0) {
			balance = balance + amount - feeCharge;
		} else {
			System.out.println("Invalid Amount");
		}
    }
    
    /**Withdrawals money from the bank account **/
    public void withdraw(double amount)
    {
		if (balance >= amount) {
			balance = balance - amount - feeCharge;
		} else {
			System.out.println("Not sufficient balance.");
		}
    }
    
    /**Transfer money from the bank account **/
	public void transfer(double amount, BankAccount from) {
		if (this.balance >= amount) {
			from.balance += amount;
			this.balance -= amount;
			System.out.println("Funds successfully transfered.");
		} else {
			System.out.println("Insufficient funds");

		}
	}
	
	public static void main(String[] args) {
		
	}
}
