public class Bank {

    private int id;

	private String name;

	private int balance;

	private int accountNumber;

	private static String branch="Taif";

	static int i = 0; // counter for number of accounts

	public Bank (int id, String name, int balance)
	{
		this.id=id;
		this.name=name;
		this.balance=balance;
		this.accountNumber=++i;
	}

	public Bank() {
		
	}

	public void deposit (int amount)
	{
		this.balance=this.balance+amount;

        System.out.println("Deposit completed successfully.");
	}

	public void withdraw(int amount)
	{
		if (amount>balance)
			System.out.println("You do not have enough balance!!");

		else {
			this.balance=this.balance-amount;

            System.out.println("Withdraw completed successfully.");
        }
	}

	public static void transfer(Bank a1, Bank a2, int amount)
	{
		if (a1.balance<amount)
			System.out.println("You do not have enough balance!!");
		else
		{
			a1.withdraw(amount);

			a2.deposit(amount);

            System.out.println("Transfer completed successfully.");
		}
	}
    
	public void printAll()
	{
		System.out.print(accountNumber+"-      ");
		System.out.print(name+"       ");
		System.out.println(balance);
	}
	
	public void printDetails() {
		System.out.println("Id = "+id);
		System.out.println("Account no = "+accountNumber);
		System.out.println("Name = "+name);
		System.out.println("Balance = "+balance);
		System.out.println("Branch = "+branch);
	}
}
