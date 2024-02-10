import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Please enter the action you want to make...");
        char operator=scanner.next().charAt(0);
        System.out.print("Number 1 : ");
        double number1=scanner.nextDouble();
        System.out.print("Number 2 : ");
        double number2=scanner.nextDouble();
        Transaction t1=new Transaction();

        System.out.println("Sonuç : "+t1.Transactions(operator,number1,number2));
    }
}