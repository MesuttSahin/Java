import java.util.Scanner;

public class Atm
{
    Scanner scanner=new Scanner(System.in);
    private static double balance=1000;
    public double password=1234;

    public void displayMenu()
    {
        System.out.println("1- Balance Inquiry");
        System.out.println("2- Withdraw");
        System.out.println("3- Deposit");
        System.out.println("4- Exit");

    }

    public void balanceInquiry()
    {
        System.out.println("Balance : "+balance);
    }

    public void withdraw(int amount)
    {
        balance=balance-amount;
        System.out.println("Process completed");

    }

    public void deposit(int amount)
    {
        balance=balance+amount;
        System.out.println("Process completed");
    }

}
