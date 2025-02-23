import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {
        int choice, id, balance, accountNumber, amount, size;

        String name;

        int i = 0;

        Scanner input = new Scanner(System.in);

        size = getValidInt(input, "How many accounts do you want to open? ");

        Bank[] account = new Bank[size];

        do {
            System.out.println("=======Menu=======");

            System.out.printf("1-Create new account %n2-Deposit %n3-Withdraw %n4-Transfer %n5-Account Details %n6-Show all accounts %n<-1>- Exit %n============== %nChoose an option: ");

            choice = getValidInt(input, "");

            switch (choice) {
                case 1:
                    System.out.println("*******New Account*******");

                    id = getValidInt(input, "Enter ID: ");
                    
                    System.out.print("Enter Name: ");
                    
                    name = input.nextLine();  // Read full name

                    balance = getValidInt(input, "Initial balance: ");
                    // Check if the user entered invalid balance
                    while (balance < 0) {
                        System.out.println("Balance cannot be negative. Try again.");

                        balance = getValidInt(input, "Initial balance: ");
                    }

                    account[i] = new Bank(id, name, balance);

                    i++;

                    System.out.println("Account created successfully.");

                    break;

                case 2:
                    if (i == 0) {
                        System.out.println("No accounts have been created yet!");

                        continue;
                    }

                    accountNumber = getValidInt(input, "Enter account number: ") - 1;
                    // check if the user entered invalid account number either if he/she entered a negative value or entered a value greater than i
                    if (accountNumber < 0 || accountNumber >= i) {
                        System.out.println("Invalid account number.");

                        continue;
                    }

                    amount = getValidInt(input, "Amount: ");

                    if (amount <= 0) {
                        System.out.println("Amount must be greater than zero.");

                        continue;
                    }

                    account[accountNumber].deposit(amount);

                    break;

                case 3:
                    if (i == 0) {
                        System.out.println("No accounts have been created yet!");

                        continue;
                    }

                    accountNumber = getValidInt(input, "Enter account number: ") - 1;

                    if (accountNumber < 0 || accountNumber >= i) {
                        System.out.println("Invalid account number.");

                        continue;
                    }

                    amount = getValidInt(input, "Amount: ");

                    if (amount <= 0) {
                        System.out.println("Amount must be greater than zero.");

                        continue;
                    }

                    account[accountNumber].withdraw(amount);

                    break;

                case 4:
                    if (i < 2) {
                        System.out.println("At least two accounts are needed to transfer money.");

                        continue;
                    }

                    amount = getValidInt(input, "Amount: ");

                    accountNumber = getValidInt(input, "From account: ") - 1;

                    int num = getValidInt(input, "To account: ") - 1;

                    if (accountNumber < 0 || accountNumber >= i || num < 0 || num >= i) {
                        System.out.println("Invalid account numbers.");

                        continue;
                    }
                    // if the user want to transfer money to the same account, then the program must prevent this transaction
                    if (accountNumber == num) {
                        System.out.println("You cannot transfer money to the same account.");

                        continue;
                    }

                    Bank.transfer(account[accountNumber], account[num], amount);
                    
                    break;

                case 5:
                    if (i == 0) {
                        System.out.println("No accounts have been created yet!");

                        continue;
                    }

                    accountNumber = getValidInt(input, "Enter account number: ") - 1;

                    if (accountNumber < 0 || accountNumber >= i) {
                        System.out.println("Invalid account number.");

                        continue;
                    }

                    account[accountNumber].printDetails();

                    break;

                case 6:
                    if (i == 0) {
                        System.out.println("No accounts have been created yet!");

                        continue;
                    }

                    System.out.println("Acc no   &   Name   &   Balance");

                    System.out.println("========   =========  ==========");

                    for (int j = 0; j < i; j++) {
                        account[j].printAll();
                    }

                    break;

                case -1:
                    break;

                default:
                    System.out.println("You entered an incorrect choice.");
            }

        } while (choice != -1);

        System.out.println("Thank you for using BankApp!");

        input.close();
    }

    private static int getValidInt(Scanner input, String message) {
        int value;

        while (true) {
            try {
                System.out.print(message);

                value = input.nextInt();

                input.nextLine(); // Clear buffer

                return value;

            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");

                input.nextLine();
            }
        }
    }
}

